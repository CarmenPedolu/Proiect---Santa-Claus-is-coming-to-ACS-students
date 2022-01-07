package fileio;

import avgscore.AverageScoreStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;
import enums.Cities;

import java.util.List;

public final class ChildInput {
    @JsonProperty("id")
    private int id;
    @JsonProperty("lastName")
    private String lastname;
    @JsonProperty("firstName")
    private String firstname;
    @JsonProperty("city")
    private Cities city;
    @JsonProperty("age")
    private int age;
    @JsonProperty("niceScore")
    private String niceScore;
    @JsonProperty("giftsPreferences")
    private List<Category> giftsPreferences;
    @JsonProperty("niceScoreHistory")
    private List<Double> niceScoreHistory;
    @JsonProperty("averageScore")
    private double avgScore;
    @JsonProperty("assignedBudget")
    private double assignedBudget;
    @JsonProperty("receivedGifts")
    private List<SantaGiftsInput> receivedGifts;
    @JsonIgnore
    private AverageScoreStrategy avgScoreStrategy;
    @JsonProperty("niceScoreBonus")
    private int niceScoreBonus;
    @JsonProperty("elf")
    private String elf;

    public ChildInput() {
    }

    public ChildInput(ChildInput child) {
        id = child.getId();
        lastname = child.getLastname();
        firstname = child.getFirstname();
        city = child.getCity();
        age = child.getAge();
        niceScore = child.niceScore;
        giftsPreferences = child.getGiftsPreferences();
        niceScoreHistory = child.getNiceScoreHistory();
        avgScore = child.getAvgScore();
        assignedBudget = child.getAssignedBudget();
        receivedGifts = child.getReceivedGifts();
        avgScoreStrategy = child.getAvgScoreStrategy();
        niceScoreBonus = child.niceScoreBonus;
        elf = child.getElf();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public String getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final String niceScore) {
        this.niceScore = niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(final double avgScore) {
        this.avgScore = avgScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<SantaGiftsInput> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final List<SantaGiftsInput> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public AverageScoreStrategy getAvgScoreStrategy() {
        return avgScoreStrategy;
    }

    public void setAvgScoreStrategy(final AverageScoreStrategy avgScoreStrategy) {
        this.avgScoreStrategy = avgScoreStrategy;
    }

    public int getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public void setNiceScoreBonus(int niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public String getElf() {
        return elf;
    }

    public void setElf(String elf) {
        this.elf = elf;
    }
}
