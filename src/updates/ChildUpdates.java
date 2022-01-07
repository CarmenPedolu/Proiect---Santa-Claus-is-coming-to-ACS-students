package updates;

import enums.Category;
import fileio.ChangesInput;
import fileio.ChildInput;
import fileio.Input;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

final class ChildUpdates extends Changes {
    @Override
    public void update(final int nrRound) {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();

        ChangesInput changes = input.getAnnualChanges().get(nrRound - 1);
        List<ChildInput> updateChildren = changes.getChildrenUpdates();

        for (ChildInput childChanged : updateChildren) {
            for (ChildInput child : allChildren) {
                if (child.getId() == childChanged.getId()) {
                    // Add the new nice score
                    if (childChanged.getNiceScore() != null) {
                        List<Double> niceScores = child.getNiceScoreHistory();
                        niceScores.add(Double.valueOf(childChanged.getNiceScore()));
                        child.setNiceScoreHistory(niceScores);
                    }
                    // Add the new gifts preferences
                    if (childChanged.getGiftsPreferences() != null) {
                        List<Category> newGiftsPref = childChanged.getGiftsPreferences();
                        List<Category> oldGiftsPref = child.getGiftsPreferences();
                        newGiftsPref.addAll(oldGiftsPref);
                        // Eliminates the duplicates from the list
                        LinkedHashSet<Category> hashSet = new LinkedHashSet<>(newGiftsPref);
                        List<Category> currentGiftsPref = new ArrayList<>(hashSet);
                        child.setGiftsPreferences(currentGiftsPref);
                    }
                    // Add the new elf
                    child.setElf(childChanged.getElf());
                }
            }
        }
    }
}
