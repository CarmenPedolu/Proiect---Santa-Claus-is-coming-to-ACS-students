package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import fileio.Input;
import fileio.SantaComing;
import rounds.Context;
import rounds.RoundContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score
     *
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            File inputFile = new File(Constants.TESTS_PATH + i + Constants.FILE_EXTENSION);
            Path path = Paths.get(Constants.OUTPUT_PATH);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            File outputFile = new File(Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION);
            ObjectMapper objectMapper = new ObjectMapper();
            Input input = objectMapper.readValue(inputFile, Input.class);

            Input.getInput().setNumberOfYears(input.getNumberOfYears());
            Input.getInput().setSantaBudget(input.getSantaBudget());
            Input.getInput().setInitialData(input.getInitialData());
            Input.getInput().setAnnualChanges(input.getAnnualChanges());

            for (int nrRound = 0; nrRound <= input.getNumberOfYears(); nrRound++) {
                Context context = new RoundContext();
                context.setNrRoundStrategy(nrRound);
                context.action();
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, SantaComing.getAnnualSanta());
        }
        Checker.calculateScore();
    }
}
