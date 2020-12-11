package nl.novi.dpcc.observerpattern;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;
import nl.novi.dpcc.observerpattern.observer.Observer;
import nl.novi.dpcc.observerpattern.observer.ScoreboardObserver;
import nl.novi.dpcc.observerpattern.observer.SupporterObserver;
import nl.novi.dpcc.observerpattern.subject.MatchSubject;
import nl.novi.dpcc.observerpattern.subject.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Observer ajaxSupporter = new SupporterObserver("Ajax");
        Observer feyenoordSupporter = new SupporterObserver("Feyenoord");
        Observer scoreboard = new ScoreboardObserver();

        Subject match = new MatchSubject();

        match.attach(ajaxSupporter);
        match.attach(feyenoordSupporter);
        match.attach(scoreboard);

        for(int i = 0; i <= 90; i = i + 5) {
            match.notifyUpdate(pickRandomMessage());
            Thread.sleep(500);
        }
        match.notifyUpdate(new Message("Ajax", MatchEventType.MATCH_END));
    }

    private static Message pickRandomMessage() {
        List<Message> messages = makeList();
        Random random = new Random();

        return messages.get(random.nextInt(messages.size()));
    }

    private static List<Message> makeList() {
        List<Message> matchReports = new ArrayList<>();
        matchReports.add(new Message("Ajax", MatchEventType.GOAL));
        matchReports.add(new Message("Ajax", MatchEventType.YELLOW_CARD));
        matchReports.add(new Message("Ajax", MatchEventType.RED_CARD));
        matchReports.add(new Message("Ajax", MatchEventType.SCHWALBE));
        matchReports.add(new Message("Ajax", MatchEventType.PENALTY));
        matchReports.add(new Message("Feyenoord", MatchEventType.RED_CARD));
        matchReports.add(new Message("Feyenoord", MatchEventType.YELLOW_CARD));
        matchReports.add(new Message("Feyenoord", MatchEventType.SCHWALBE));
        matchReports.add(new Message("Feyenoord", MatchEventType.PENALTY));
        matchReports.add(new Message("Feyenoord", MatchEventType.GOAL));
        matchReports.add(new Message("Ajax", MatchEventType.CORNER_KICK));
        matchReports.add(new Message("Feyenoord", MatchEventType.CORNER_KICK));

        return matchReports;
    }
}
