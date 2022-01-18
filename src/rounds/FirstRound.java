package rounds;

import commands.PutSantaComing;
import commands.RoundInvoker;
import commands.SumAvgScores;
import elf.ElfFactory;
import enums.ElvesType;
import fileio.AnnualChildren;
import fileio.ChildInput;
import fileio.Input;
import giftdistribution.DistributionContext;

import java.util.ArrayList;
import java.util.List;

public final class FirstRound implements Simulation {
    @Override
    public void execute(final int nrRound) {
        Input input = Input.getInput();
        RoundInvoker round = new RoundInvoker();

        round.execute(new SumAvgScores());
        double budgetUnit = input.getSantaBudget() / input.getSumAvgScores();

        // Calculates and sets the assigned budget for each child
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        for (ChildInput child : allChildren) {
            // Calculates and sets the assigned budget for each child
            double childAssignedBudget = budgetUnit * child.getAvgScore();
            child.setAssignedBudget(childAssignedBudget);
            // Applies the changes of black and pink elves
            if (child.getElf().equals("black")) {
                ElfFactory.getHelp(ElvesType.BLACK).help(child);
            }
            if (child.getElf().equals("pink")) {
                ElfFactory.getHelp(ElvesType.PINK).help(child);
            }
        }

        // Send gifts
        DistributionContext distribution = new DistributionContext();
        distribution.sendGifts();

        // Applies the changes of yellow elves
        for (ChildInput child : allChildren) {
            if (child.getElf().equals("yellow")) {
                ElfFactory.getHelp(ElvesType.YELLOW).help(child);
            }
        }

        // Add the children in output
        List<AnnualChildren> santaCame = new ArrayList<>();
        round.execute(new PutSantaComing(santaCame));
    }
}
