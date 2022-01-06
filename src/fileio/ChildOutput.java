package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public final class ChildOutput {
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
    @JsonProperty("giftsPreferences")
    private List<Category> giftsPreferences;
    @JsonProperty("averageScore")
    private double avgScore;
    @JsonProperty("niceScoreHistory")
    private List<Double> niceScoreHistory;
    @JsonProperty("assignedBudget")
    private double assignedBudget;
    @JsonProperty("receivedGifts")
    private List<SantaGiftsInput> receivedGifts;

    public ChildOutput(final ChildInput child) {
        id = child.getId();
        lastname = child.getLastname();
        firstname = child.getFirstname();
        age = child.getAge();
        city = child.getCity();
        giftsPreferences = child.getGiftsPreferences();
        niceScoreHistory = new ArrayList<>();
        niceScoreHistory.addAll(child.getNiceScoreHistory());
        avgScore = child.getAvgScore();
        assignedBudget = child.getAssignedBudget();
        receivedGifts = child.getReceivedGifts();
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

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
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

}
