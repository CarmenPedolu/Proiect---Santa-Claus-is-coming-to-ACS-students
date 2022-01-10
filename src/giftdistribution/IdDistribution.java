package giftdistribution;

import commands.GiftsDistribution;
import commands.RoundInvoker;
import fileio.ChildInput;
import fileio.Input;

import java.util.List;

public final class IdDistribution implements StrategyGiftDistribution {
    @Override
    public void distribute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        // fac distribuirea pentru copyChildren
        RoundInvoker round = new RoundInvoker();
        round.execute(new GiftsDistribution(allChildren));

    }
}

