package main;

import checker.Checker;
import common.Constants;
import java.io.IOException;

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
            Test testSimulation = new Test(i);
            testSimulation.simulateTest();
        }
        Checker.calculateScore();
    }
}
