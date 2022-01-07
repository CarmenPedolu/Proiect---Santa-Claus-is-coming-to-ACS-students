package giftdistribution;

import enums.Category;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaGiftsInput;

import java.util.ArrayList;
import java.util.List;

public class IdDistribution implements StrategyGiftDistribution {
    @Override
    public void distribute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        List<SantaGiftsInput> santaGifts = input.getInitialData().getSantaGifts();

        for (ChildInput child : allChildren) {
            double childAssignedBudget = child.getAssignedBudget();

            List<Category> giftsPref = child.getGiftsPreferences();
            List<SantaGiftsInput> receivedGifts = new ArrayList<>();
            child.setReceivedGifts(receivedGifts);
            for (Category category : giftsPref) {
                SantaGiftsInput givedGift = null;
                for (SantaGiftsInput gift : santaGifts) {
                    if (gift.getQuantity() > 0) {
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
                }
                // Add the gift in the received gifts list
                if (givedGift != null) {
                    receivedGifts.add(givedGift);
                    child.setReceivedGifts(receivedGifts);
                    childAssignedBudget = childAssignedBudget - givedGift.getPrice();
                    // Scad cantitatea cadoului
                    for (SantaGiftsInput gift : santaGifts) {
                        if (gift.getPrice().equals(givedGift.getPrice()) && gift.getCategory().equals(givedGift.getCategory())) {
                            gift.setQuantity(gift.getQuantity() - 1);
                        }
                    }
                }
            }
        }
    }
}

