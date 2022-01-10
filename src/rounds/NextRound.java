package rounds;

import commands.DeleteYoungAdults;
import commands.IncreaseAge;
import commands.RoundInvoker;
import commands.SumAvgScores;
import commands.PutSantaComing;
import elf.ElfFactory;
import enums.ElvesType;
import fileio.AnnualChildren;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaComing;
import giftdistribution.DistributionContext;
import updates.UpdatesFactory;

import java.util.List;

public final class NextRound implements Simulation {
    @Override
    public void execute(final int nrRound) {
        Input input = Input.getInput();
        RoundInvoker round = new RoundInvoker();

        // Increase the age of the children
        round.execute(new IncreaseAge());

        round.execute(new DeleteYoungAdults());

        // Update the changes
        for (enums.UpdatesType updateType : enums.UpdatesType.values()) {
            UpdatesFactory.getUpdate(updateType).update(nrRound);
        }

        round.execute(new SumAvgScores());
        double budgetUnit = input.getSantaBudget() / input.getSumAvgScores();

        List<ChildInput> allChildren = input.getInitialData().getChildren();
        for (ChildInput child : allChildren) {
            // Calculates and sets the assigned budget for each child
            double childAssignedBudget = budgetUnit * child.getAvgScore();
            child.setAssignedBudget(childAssignedBudget);
            // aplic modificarile elfilor black si pink
            if (child.getElf().equals("black")) {
                ElfFactory.getHelp(ElvesType.BLACK).help(child);
            }
            if (child.getElf().equals("pink")) {
                ElfFactory.getHelp(ElvesType.PINK).help(child);
            }
        }

        //round.execute(new GiftsDistribution(budgetUnit));
        DistributionContext strategy = new DistributionContext();
        strategy.setStrategy(Input.getInput().getAnnualChanges().get(nrRound - 1).getStrategy());
        strategy.sendGifts();

        // aplic modificarile elfului galben
        for (ChildInput child : allChildren) {
            if (child.getElf().equals("yellow")) {
                ElfFactory.getHelp(ElvesType.YELLOW).help(child);
            }
        }

        // Add the children in output
        List<AnnualChildren> santaCame = SantaComing.getAnnualSanta().getAnnualChildren();
        round.execute(new PutSantaComing(santaCame));
    }
}
