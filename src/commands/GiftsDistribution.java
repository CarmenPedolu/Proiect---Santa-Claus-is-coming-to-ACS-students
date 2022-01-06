package commands;

import enums.Category;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaGiftsInput;

import java.util.ArrayList;
import java.util.List;

public class GiftsDistribution implements Command {
    private final double budgetUnit;

    public GiftsDistribution(final double budgetUnit) {
        this.budgetUnit = budgetUnit;
    }

    @Override
    public final void execute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        List<SantaGiftsInput> santaGifts = input.getInitialData().getSantaGifts();

        for (ChildInput child : allChildren) {
            // Calculates and sets the assigned budget for each child
            double childAssignedBudget = budgetUnit * child.getAvgScore();
            child.setAssignedBudget(childAssignedBudget);

            List<Category> giftsPref = child.getGiftsPreferences();
            List<SantaGiftsInput> receivedGifts = new ArrayList<>();
            child.setReceivedGifts(receivedGifts);
            for (Category category : giftsPref) {
                SantaGiftsInput givedGift = null;
                for (SantaGiftsInput gift : santaGifts) {
                    // Give the cheapest gift from that category
                    if (category.equals(gift.getCategory())
                            && childAssignedBudget > gift.getPrice()) {
                        if (givedGift == null) {
                            givedGift = gift;
                        } else {
                            if (givedGift.getPrice() > gift.getPrice()) {
                                givedGift = gift;
                            }
                        }
                    }
                }
                // Add the gift in the received gifts list
                if (givedGift != null) {
                    receivedGifts.add(givedGift);
                    child.setReceivedGifts(receivedGifts);
                    childAssignedBudget = childAssignedBudget - givedGift.getPrice();
                }
            }
        }
    }
}
