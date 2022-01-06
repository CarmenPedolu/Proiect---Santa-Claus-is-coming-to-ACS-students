package fileio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public final class Input {
    private static final Input INPUT = new Input();

    public static Input getInput() {
        return INPUT;
    }

    private int numberOfYears;
    private double santaBudget;
    private InitialDataInput initialData;
    private List<ChangesInput> annualChanges;
    @JsonIgnore
    private double sumAvgScores;


    private Input() {
        this.numberOfYears = 0;
        this.santaBudget = 0;
        this.initialData = null;
        this.annualChanges = null;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public List<ChangesInput> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(final List<ChangesInput> annualChanges) {
        this.annualChanges = annualChanges;
    }

    public double getSumAvgScores() {
        return sumAvgScores;
    }

    public void setSumAvgScores(final double sumAvgScores) {
        this.sumAvgScores = sumAvgScores;
    }

    public InitialDataInput getInitialData() {
        return initialData;
    }

    public void setInitialData(final InitialDataInput initialData) {
        this.initialData = initialData;
    }
}
