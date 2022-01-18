package giftdistribution;

import commands.GiftsDistribution;
import commands.RoundInvoker;
import enums.Cities;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaGiftsInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;


public final class NiceScoreCityDistribution implements StrategyGiftDistribution {
    @Override
    public void distribute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        // Creates a new map which contains all the cities and the cities average score
        Map<Cities, Double> citiesScores = new HashMap<>();
        for (Cities city : enums.Cities.values()) {
            double avgCitySum = 0;
            int childCount = 0;
            for (ChildInput child : allChildren) {
                if (child.getCity().equals(city)) {
                    avgCitySum += child.getAvgScore();
                    childCount++;
                }
            }
            double avgCity = 0;
            if (avgCitySum != 0) {
                avgCity = avgCitySum / childCount;
            }
            citiesScores.put(city, avgCity);
        }
        // Sort the map by the score or alphabetical and return a list of Cities sorted
        List<Cities> citiesSorted = new ArrayList(citiesScores.entrySet().stream()
                .sorted(new Comparator<Map.Entry<Cities, Double>>() {
                    @Override
                    public int compare(final Map.Entry<Cities, Double> city1,
                                       final Map.Entry<Cities, Double> city2) {
                        if (city1.getValue() > city2.getValue()) {
                            return -1;
                        } else if (city1.getValue() < city2.getValue()) {
                            return 1;
                        } else {
                            return (city1.getKey().toString().compareTo(city2.getKey().toString()));
                        }
                    }
                }).map(Map.Entry::getKey).toList());

        // Creates a new list which contains all the children added in cities order
        List<ChildInput> copyChildren = new ArrayList<>();
        for (Cities city : citiesSorted) {
            for (ChildInput child : allChildren) {
                if (child.getCity().equals(city)) {
                    copyChildren.add(new ChildInput.Builder(child.getId(), child.getLastname(),
                            child.getFirstname(), child.getCity(), child.getAge(),
                            child.getNiceScore(), child.getGiftsPreferences(), child.getElf())
                            .avgScore(child.getAvgScore())
                            .assignedBudget(child.getAssignedBudget()).build());
                }
            }
        }

        // Send the gifts to the children from the sorted list
        RoundInvoker round = new RoundInvoker();
        round.execute(new GiftsDistribution(copyChildren));

        // Copy the received gifts of each child from the previous list in the first list
        for (ChildInput child : copyChildren) {
            for (ChildInput childInput : allChildren) {
                if (child.getId() == childInput.getId()) {
                    List<SantaGiftsInput> receivedGift = new ArrayList<>(child.getReceivedGifts());
                    childInput.setReceivedGifts(receivedGift);
                }
            }
        }
    }
}
