package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;

public  class SupporterObserver implements Observer {

    private String favouriteClub;

    public SupporterObserver(String favouriteClub) {
        this.favouriteClub = favouriteClub;
    }

    public  void update(Message message) {
        String clubname = message.getClubName();
        MatchEventType eventType = message.getMatchEventType();

        StringBuilder sb = new StringBuilder("The ").append(favouriteClub).append("-crowd ");

        if(favouriteClub.equalsIgnoreCase(clubname)) {
            sb.append(crowdReactionOwnTeam(eventType));
        } else {
            sb.append(crowdReactionOpponent(eventType));
        }
        System.out.println(sb.toString());
    }

    private String crowdReactionOwnTeam(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "cheers.";
            case PENALTY:
                return "cheers the striker for the penalty.";
            case YELLOW_CARD:
                return "boos the referee.";
            case SCHWALBE:
                return "cheers for the schwalbe";
            case RED_CARD:
                return "whistles at the referee";
        }
        return "leave the stadium.";
    }

    private String crowdReactionOpponent(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "shows dismay.";
            case PENALTY:
                return "yell the goalkeepers name for the penalty.";
            case YELLOW_CARD:
                return "laugh at the yellow player.";
            case SCHWALBE:
                return "yells SCHWALBE!";
            case RED_CARD:
                return "cheers in celebration of the red card.";
        }
        return "leave the stadium.";
    }

}
