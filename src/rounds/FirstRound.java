package rounds;

import commands.GiftsDistribution;
import commands.PutSantaComing;
import commands.RoundInvoker;
import commands.SumAvgScores;
import fileio.AnnualChildren;
import fileio.Input;

import java.util.ArrayList;
import java.util.List;

public final class FirstRound implements Simulation {
    @Override
    public void execute(final int nrRound) {
        Input input = Input.getInput();
        RoundInvoker round = new RoundInvoker();

        round.execute(new SumAvgScores());
        double budgetUnit = input.getSantaBudget() / input.getSumAvgScores();

        round.execute(new GiftsDistribution(budgetUnit));

        // Add the children in output
        List<AnnualChildren> santaCame = new ArrayList<>();
        round.execute(new PutSantaComing(santaCame));
    }
}
