package avgscore;

import java.util.List;

public interface AverageScoreStrategy {
    /**
     * Calculates the average score of the list
     *
     * @param numbers a list of Double numbers
     * @return the average score
     */
    double calculateAvgScore(List<Double> numbers);
}
