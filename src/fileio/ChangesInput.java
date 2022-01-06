package fileio;

import enums.CityStrategyEnum;

import java.util.List;

public final class ChangesInput {
    private double newSantaBudget;
    private List<ChildInput> newChildren;
    private List<SantaGiftsInput> newGifts;
    private List<ChildInput> childrenUpdates;
    private CityStrategyEnum strategy;

    public ChangesInput() {
    }

    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<ChildInput> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final List<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public List<SantaGiftsInput> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final List<SantaGiftsInput> newGifts) {
        this.newGifts = newGifts;
    }

    public List<ChildInput> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final List<ChildInput> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    public void setStrategy(CityStrategyEnum strategy) {
        this.strategy = strategy;
    }
}
