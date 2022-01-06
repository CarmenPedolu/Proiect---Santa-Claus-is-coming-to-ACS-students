package avgscore;

import common.Constants;

import java.util.List;

public final class BabyScore implements AverageScoreStrategy {
    @Override
    public double calculateAvgScore(final List<Double> numbers) {
        return Constants.TEN;
    }
}
