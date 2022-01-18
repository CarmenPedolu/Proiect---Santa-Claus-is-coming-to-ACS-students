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

        // Creates a new list which contains all the children
        List<ChildInput> copyChildren = new ArrayList<>(allChildren);
        // Sorts the list by children's average scores or by children's id
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

        // Send the gifts to the children from the sorted list
        RoundInvoker round = new RoundInvoker();
        round.execute(new GiftsDistribution(copyChildren));

        // Copy the received gifts of each child from the previous list in the first list
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
