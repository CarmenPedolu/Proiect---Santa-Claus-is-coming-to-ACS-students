package main;

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

public final class Test {
    private int i;

    public Test(final int i) {
        this.i = i;
    }

    /**
     * This method is used to simulate the test with number i
     */
    public void simulateTest() throws IOException {
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

        objectMapper.writerWithDefaultPrettyPrinter()
                .writeValue(outputFile, SantaComing.getAnnualSanta());
    }
}
