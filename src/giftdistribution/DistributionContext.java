package giftdistribution;

import enums.CityStrategyEnum;

public final class DistributionContext {
    private StrategyGiftDistribution strategy;

    public DistributionContext() {
        this.strategy = new IdDistribution();
    }

    public StrategyGiftDistribution getStrategy() {
        return strategy;
    }

    /**
     * Sets the strategy for gifts distribution
     *
     * @param strategy the strategy which will be set
     */
    public void setStrategy(final CityStrategyEnum strategy) {
        if (strategy.equals(CityStrategyEnum.ID)) {
            this.strategy = new IdDistribution();
        }
        if (strategy.equals(CityStrategyEnum.NICE_SCORE)) {
            this.strategy = new NiceScoreDistribution();
        }
        if (strategy.equals(CityStrategyEnum.NICE_SCORE_CITY)) {
            this.strategy = new NiceScoreCityDistribution();
        }
    }

    /**
     * Executes gifts distribution
     */
    public void sendGifts() {
        strategy.distribute();
    }
}
