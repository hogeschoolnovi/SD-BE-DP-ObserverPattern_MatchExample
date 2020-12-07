package nl.novi.dpcc.observerpattern.domain;

public class Message {
    private final String clubName;
    private final MatchEventType matchEventType;

    public Message(String clubName, MatchEventType matchEventType) {
        this.clubName = clubName;
        this.matchEventType = matchEventType;
    }

    public String getClubName() {
        return clubName;
    }

    public MatchEventType getMatchEventType() {
        return matchEventType;
    }

}
