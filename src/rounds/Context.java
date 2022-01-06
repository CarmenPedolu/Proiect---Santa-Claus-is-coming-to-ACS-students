package rounds;

public interface Context {
    /**
     * Set de number of round simulation and the strategy for the simulation
     *
     * @param round the number of the round
     */
    void setNrRoundStrategy(int round);

    /**
     * Executes the strategy
     *
     */
    void action();
}
