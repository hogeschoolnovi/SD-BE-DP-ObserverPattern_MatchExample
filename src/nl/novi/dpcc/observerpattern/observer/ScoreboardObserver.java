package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.MatchStatistics;
import nl.novi.dpcc.observerpattern.domain.Message;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScoreboardObserver implements Observer {

    private final Map<String, MatchStatistics> teams = new LinkedHashMap<>();

    @Override
    public void update(Message message) {

        String clubName = message.getClubName();
        checkIfExistsAndAdd(clubName);

        switch(message.getMatchEventType()) {
            case GOAL:
                addGoal(clubName);
                break;
            case YELLOW_CARD:
                addYellowCard(clubName);
                break;
            case RED_CARD:
                addRedCard(clubName);
                break;
            case MATCH_END:
                printScoreBoard();
                break;
            default:
                //Should do nothing in other cases.
        }

    }

    private void checkIfExistsAndAdd(String clubName) {
        if(!teams.containsKey(clubName)) {
            teams.put(clubName, new MatchStatistics());
        }
    }

    private void addGoal(String clubName) {
        teams.get(clubName).addGoal();
    }

    private void addYellowCard(String clubName) {
        teams.get(clubName).addYellowCard();
    }

    private void addRedCard(String clubName) {
        teams.get(clubName).addRedCard();
    }
    private void printScoreBoard() {

        if(!isMapValid()) {
            throw new RuntimeException("Cannot make scoreboard");
        }
        String firstClubName = teams.keySet().toArray()[0].toString();
        MatchStatistics firstClubStatistics = (MatchStatistics) teams.values().toArray()[0];
        String secondClubName = teams.keySet().toArray()[1].toString();
        MatchStatistics secondClubStatistics = (MatchStatistics) teams.values().toArray()[1];

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstClubName).append(" - ").append(secondClubName).append(" (")
                .append(firstClubStatistics.getGoalsScored()).append("-")
                .append(secondClubStatistics.getGoalsScored()).append(")").append("\n\r");

        stringBuilder.append("Yellow cards: ").append(firstClubName).append(" (")
                .append(firstClubStatistics.getAmountYellowCards()).append(") ").append(secondClubName)
                .append(" (").append(secondClubStatistics.getAmountYellowCards()).append(") ").append("\r\n");

        stringBuilder.append("Red cards: ").append(firstClubName).append(" (")
                .append(firstClubStatistics.getAmountRedCards()).append(") ").append(secondClubName)
                .append(" (").append(secondClubStatistics.getAmountRedCards()).append(") ");

        System.out.println(stringBuilder.toString());
    }

    private boolean isMapValid() {
        return teams.keySet().toArray()[0] != null && teams.keySet().toArray()[1] != null;
    }
}
