package giftdistribution;

import enums.Category;
import enums.Cities;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaGiftsInput;

import java.util.*;

public class NiceScoreCityDistribution implements StrategyGiftDistribution {
    @Override
    public void distribute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        // fac un map care va contine orasul si scorul mediu al copiilor din acel oras
        Map<Cities, Double> map = new HashMap<>();
        for (Cities city : enums.Cities.values()) {
            double avgCitySum = 0;
            int childCount = 0;
            for (ChildInput child : allChildren) {
                if (child.getCity().equals(city)) {
                    avgCitySum += child.getAvgScore();
                    childCount++;
                }
            }
            map.put(city, avgCitySum / childCount);
        }
        // sortez mapul in functie de valori si returnez o lista de orase sortate de la avgscore cel mai mare la cel mai mic
        List<Cities> citiesSorted = new ArrayList(map.entrySet().stream().sorted(new Comparator<Map.Entry<Cities, Double>>() {
            @Override
            public int compare(Map.Entry<Cities, Double> o1, Map.Entry<Cities, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).map(Map.Entry::getKey).toList());
        //fac o noua lista de copii si adaug copiii in lista noua in ordinea oraselor
        List<ChildInput> copyChildren = new ArrayList<>();
        for (Cities city : citiesSorted) {
            for (ChildInput child : allChildren) {
                if (child.getCity().equals(city)) {
                    copyChildren.add(new ChildInput(child));
                }
            }
        }

        List<SantaGiftsInput> santaGifts = input.getInitialData().getSantaGifts();
        // fac distribuirea pentru copyChildren
        for (ChildInput child : copyChildren) {
            double childAssignedBudget = child.getAssignedBudget();

            List<Category> giftsPref = child.getGiftsPreferences();
            List<SantaGiftsInput> receivedGifts = new ArrayList<>();
            child.setReceivedGifts(receivedGifts);
            for (Category category : giftsPref) {
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
