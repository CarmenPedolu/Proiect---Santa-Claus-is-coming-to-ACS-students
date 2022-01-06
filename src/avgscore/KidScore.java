package avgscore;

import java.util.List;

public final class KidScore implements AverageScoreStrategy {
    @Override
    public double calculateAvgScore(final List<Double> numbers) {
        double sum = 0;
        for (Double nr : numbers) {
            sum = sum + nr;
        }
        return sum / numbers.size();
    }
}
