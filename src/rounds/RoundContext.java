package rounds;

public final class RoundContext implements Context {
    private int nrRound;
    private Simulation strategy;

    @Override
    public void setNrRoundStrategy(final int round) {
        this.nrRound = round;
        if (nrRound != 0) {
            strategy = new NextRound();
        } else {
            strategy = new FirstRound();
        }
    }

    @Override
    public void action() {
        strategy.execute(nrRound);
    }
}
