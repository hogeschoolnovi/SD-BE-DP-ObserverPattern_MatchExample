package nl.novi.dpcc.observerpattern.domain;

public class MatchStatistics {

    private int goalsScored;
    private int amountYellowCards;
    private int amountRedCards;

    public MatchStatistics() {
        this.goalsScored = 0;
        this.amountYellowCards = 0;
        this.amountRedCards = 0;
    }

    public void addGoal() {
        this.goalsScored += 1;
    }

    public void addYellowCard() {
        this.amountYellowCards += 1;
    }

    public void addRedCard() {
        this.amountRedCards += 1;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getAmountYellowCards() {
        return amountYellowCards;
    }

    public int getAmountRedCards() {
        return amountRedCards;
    }
}
