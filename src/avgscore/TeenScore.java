package avgscore;

import java.util.List;

public final class TeenScore implements AverageScoreStrategy {
    @Override
    public double calculateAvgScore(final List<Double> numbers) {
        double sum = 0;
        double numitor = 0;
        for (int i = 1; i <= numbers.size(); i++) {
            sum = sum + i * numbers.get(i - 1);
            numitor = numitor + i;
        }
        return sum / numitor;
    }
}
