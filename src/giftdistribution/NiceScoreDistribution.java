package giftdistribution;

import commands.GiftsDistribution;
import commands.RoundInvoker;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaGiftsInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class NiceScoreDistribution implements StrategyGiftDistribution {
    @Override
    public void distribute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();

        //fac o noua lista de copii pe care o sortez dupa avg score
        List<ChildInput> copyChildren = new ArrayList<>(allChildren);
        copyChildren.sort(new Comparator<ChildInput>() {
            @Override
            public int compare(final ChildInput child1, final ChildInput child2) {
                if (child1.getAvgScore() > child2.getAvgScore()) {
                    return -1;
                } else if (child1.getAvgScore() < child2.getAvgScore()) {
                    return 1;
                } else {
                    return Integer.compare(child1.getId(), child2.getId());
                }
            }
        });

        // fac distribuirea pentru copyChildren
        RoundInvoker round = new RoundInvoker();
        round.execute(new GiftsDistribution(copyChildren));

        // copiez cadourile primite ale copiilor din copychildren in cel normal
        for (ChildInput child : copyChildren) {
            for (ChildInput childInput : allChildren) {
                if (child.getId() == childInput.getId()) {
                    List<SantaGiftsInput> receivedGifts = new ArrayList<>(child.getReceivedGifts());
                    childInput.setReceivedGifts(receivedGifts);
                }
            }
        }
    }
}
