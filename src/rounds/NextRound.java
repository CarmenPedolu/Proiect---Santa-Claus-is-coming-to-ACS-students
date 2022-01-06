package rounds;

import commands.DeleteYoungAdults;
import commands.IncreaseAge;
import commands.RoundInvoker;
import commands.SumAvgScores;
import commands.GiftsDistribution;
import commands.PutSantaComing;
import fileio.AnnualChildren;
import fileio.Input;
import fileio.SantaComing;
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

        round.execute(new GiftsDistribution(budgetUnit));

        // Add the children in output
        List<AnnualChildren> santaCame = SantaComing.getAnnualSanta().getAnnualChildren();
        round.execute(new PutSantaComing(santaCame));
    }
}
