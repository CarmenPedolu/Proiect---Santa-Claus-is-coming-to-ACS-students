package giftdistribution;

import enums.Category;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaGiftsInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NiceScoreDistribution implements StrategyGiftDistribution {
    @Override
    public void distribute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        List<SantaGiftsInput> santaGifts = input.getInitialData().getSantaGifts();

        //fac o noua lista de copii pe care o sortez dupa avg score
        List<ChildInput> copyChildren = new ArrayList<>(allChildren);
        copyChildren.sort(new Comparator<ChildInput>() {
            @Override
            public int compare(ChildInput child1, ChildInput child2) {
                if (child1.getAvgScore() > child2.getAvgScore()) {
                    return -1;
                } else if (child1.getAvgScore() < child2.getAvgScore()) {
                    return 1;
                } else {
                    return Integer.compare(child1.getId(), child2.getId());
                }
            }
        });
        for (ChildInput child : copyChildren) {
            double childAssignedBudget = child.getAssignedBudget();

            List<Category> giftsPref = child.getGiftsPreferences();
            List<SantaGiftsInput> receivedGifts = new ArrayList<>();
            child.setReceivedGifts(receivedGifts);
//            for (int i = 0; i < giftsPref.size(); i++){
            for (Category category : giftsPref) {
//                Category category = giftsPref.get(i);
                SantaGiftsInput givedGift = null;
                for (SantaGiftsInput gift : santaGifts) {
                        // Give the cheapest gift from that category
                        if (category.equals(gift.getCategory())
                                && childAssignedBudget > gift.getPrice()
                                && gift.getQuantity() > 0) {
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
                    // Scad cantitatea cadoului
                    for (SantaGiftsInput gift : santaGifts) {
                        if (gift.getPrice().equals(givedGift.getPrice()) && gift.getCategory().equals(givedGift.getCategory())) {
                            gift.setQuantity(gift.getQuantity() - 1);
                        }
                    }
                }
            }
        }

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
