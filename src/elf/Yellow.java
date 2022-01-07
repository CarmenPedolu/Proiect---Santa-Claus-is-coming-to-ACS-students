package elf;

import enums.Category;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaGiftsInput;

import java.util.ArrayList;
import java.util.List;

public class Yellow extends Elf {
    @Override
    public void help(ChildInput child) {
        if (child.getReceivedGifts() == null) {
            Category prefCategory = child.getGiftsPreferences().get(0);
            // caut cadoul cel mai ieftin
            SantaGiftsInput givedGift = null;

            List<SantaGiftsInput> receivedGifts = new ArrayList<>();
            List<SantaGiftsInput> santaGifts = Input.getInput().getInitialData().getSantaGifts();

            for (SantaGiftsInput gift : santaGifts) {
                if (gift.getQuantity() > 0) {
                    // Give the cheapest gift from that category
                    if (prefCategory.equals(gift.getCategory())
                            && child.getAssignedBudget() > gift.getPrice()) {
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