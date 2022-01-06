package updates;

import fileio.ChangesInput;
import fileio.ChildInput;
import fileio.Input;
import fileio.InitialDataInput;
import fileio.SantaGiftsInput;

import java.util.List;

final class NewGiftsChildrenUpdates extends Changes {
    @Override
    public void update(final int nrRound) {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        // Adds the new gifts which Santa has
        ChangesInput changes = input.getAnnualChanges().get(nrRound - 1);
        List<SantaGiftsInput> newGifts = changes.getNewGifts();
        List<SantaGiftsInput> oldGifts = input.getInitialData().getSantaGifts();
        oldGifts.addAll(newGifts);
        // Adds the new children in the input
        List<ChildInput> newChildren = changes.getNewChildren();
        allChildren.addAll(newChildren);
        // Updates the input
        InitialDataInput newData = new InitialDataInput(allChildren, oldGifts);
        input.setInitialData(newData);
    }
}
