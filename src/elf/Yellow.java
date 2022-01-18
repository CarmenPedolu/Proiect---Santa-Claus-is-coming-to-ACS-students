package elf;

import enums.Category;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaGiftsInput;

import java.util.ArrayList;
import java.util.List;

public final class Yellow extends Elf {
    @Override
    public void help(final ChildInput child) {
        if (child.getReceivedGifts().size() == 0) {
            Category prefCategory = child.getGiftsPreferences().get(0);
            // Finds the cheapest gift
            SantaGiftsInput givedGift = null;

            List<SantaGiftsInput> receivedGifts = new ArrayList<>();
            List<SantaGiftsInput> santaGifts = Input.getInput().getInitialData().getSantaGifts();

            for (SantaGiftsInput gift : santaGifts) {
                // Give the cheapest gift from that category
                if (prefCategory.equals(gift.getCategory())) {
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
            if (givedGift != null && givedGift.getQuantity() > 0) {
                receivedGifts.add(givedGift);
                child.setReceivedGifts(receivedGifts);
                // Decrement the gift's quantity
                for (SantaGiftsInput gift : santaGifts) {
                    if (gift.getPrice().equals(givedGift.getPrice())
                            && gift.getCategory().equals(givedGift.getCategory())) {
                        gift.setQuantity(gift.getQuantity() - 1);
                    }
                }
            }
        }
    }
}
