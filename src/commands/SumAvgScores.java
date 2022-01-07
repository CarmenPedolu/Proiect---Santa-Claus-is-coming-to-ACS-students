package commands;

import avgscore.BabyScore;
import avgscore.KidScore;
import avgscore.TeenScore;
import avgscore.YoungAdult;
import common.Constants;
import fileio.ChildInput;
import fileio.Input;

import java.util.ArrayList;
import java.util.List;

public class SumAvgScores implements Command {
    @Override
    public final void execute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        double sumAvgScores = 0;
        for (ChildInput child : allChildren) {
            if (child.getAge() < Constants.FIVE) {
                child.setAvgScoreStrategy(new BabyScore());
            } else if (child.getAge() < Constants.TWELVE) {
                child.setAvgScoreStrategy(new KidScore());
            } else if (child.getAge() < Constants.NINETEEN) {
                child.setAvgScoreStrategy(new TeenScore());
            } else {
                child.setAvgScoreStrategy(new YoungAdult());
                child.setAvgScore(child.getAvgScoreStrategy().
                        calculateAvgScore(child.getNiceScoreHistory()));
                continue;
            }

            // Add the nice score in the list if it is empty
            List<Double> niceScores = child.getNiceScoreHistory();
            if (niceScores == null) {
                List<Double> niceScoreHistory = new ArrayList<>();
                niceScoreHistory.add(Double.valueOf(child.getNiceScore()));
                child.setNiceScoreHistory(niceScoreHistory);
            }
            //Am adaugat niceScoreBonus
            // Calculates the average score for each child
            double avgScore = child.getAvgScoreStrategy().
                    calculateAvgScore(child.getNiceScoreHistory());
            avgScore += avgScore * child.getNiceScoreBonus() / 100;
//            if (avgScore > 10) {
//                avgScore = 10;
//            }
            child.setAvgScore(avgScore);
            sumAvgScores = sumAvgScores + avgScore;
        }
        input.setSumAvgScores(sumAvgScores);
    }
}
