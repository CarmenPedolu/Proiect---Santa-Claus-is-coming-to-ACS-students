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

    public static final class Builder {
        private final int id;
        private final String lastname;
        private final String firstname;
        private final Cities city;
        private final int age;
        private final String niceScore;
        private final List<Category> giftsPreferences;
        private final String elf;
        private List<Double> niceScoreHistory = null;
        private double avgScore = 0;
        private double assignedBudget = 0;
        private List<SantaGiftsInput> receivedGifts = null;
        private AverageScoreStrategy avgScoreStrategy = null;
        private int niceScoreBonus = 0;

        public Builder(final int id, final String lastname, final String firstname,
                       final Cities city, final int age, final String niceScore,
                       final List<Category> giftsPreferences, final String elf) {
            this.id = id;
            this.lastname = lastname;
            this.firstname = firstname;
            this.city = city;
            this.age = age;
            this.niceScore = niceScore;
            this.giftsPreferences = giftsPreferences;
            this.elf = elf;
        }

        /**
         * Sets the nice score history
         *
         * @param scoreHistory the child's nice score history
         * @return the builder
         */
        public Builder niceScoreHistory(final List<Double> scoreHistory) {
            this.niceScoreHistory = scoreHistory;
            return this;
        }

        /**
         * Sets the average score
         *
         * @param score the child's average score
         * @return the builder
         */
        public Builder avgScore(final double score) {
            this.avgScore = score;
            return this;
        }

        /**
         * Sets the child's assigned budget
         *
         * @param budget the child's assigned budget
         * @return the builder
         */
        public Builder assignedBudget(final double budget) {
            this.assignedBudget = budget;
            return this;
        }

        /**
         * Sets the received gifts
         *
         * @param gifts the child's received gifts
         * @return the builder
         */
        public Builder receivedGifts(final List<SantaGiftsInput> gifts) {
            this.receivedGifts = gifts;
            return this;
        }

        /**
         * Sets the strategy for the average score of the child
         *
         * @param strategy the child's strategy for the average score
         * @return the builder
         */
        public Builder avgScoreStrategy(final AverageScoreStrategy strategy) {
            this.avgScoreStrategy = strategy;
            return this;
        }

        /**
         * Sets the nice score bonus
         *
         * @param bonus the child's nice score bonus
         * @return the builder
         */
        public Builder niceScoreBonus(final int bonus) {
            this.niceScoreBonus = bonus;
            return this;
        }

        /**
         * Creates the child
         *
         * @return the child
         */
        public ChildInput build() {
            return new ChildInput(this);
        }
    }

    private ChildInput(final Builder builder) {
        id = builder.id;
        lastname = builder.lastname;
        firstname = builder.firstname;
        city = builder.city;
        age = builder.age;
        niceScore = builder.niceScore;
        giftsPreferences = builder.giftsPreferences;
        niceScoreHistory = builder.niceScoreHistory;
        avgScore = builder.avgScore;
        assignedBudget = builder.assignedBudget;
        receivedGifts = builder.receivedGifts;
        avgScoreStrategy = builder.avgScoreStrategy;
        niceScoreBonus = builder.niceScoreBonus;
        elf = builder.elf;
    }

    public ChildInput() {
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

    public void setNiceScoreBonus(final int niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public String getElf() {
        return elf;
    }

    public void setElf(final String elf) {
        this.elf = elf;
    }
}
