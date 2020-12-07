package nl.novi.dpcc.observerpattern.subject;

import nl.novi.dpcc.observerpattern.domain.Message;
import nl.novi.dpcc.observerpattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class MatchPublisher implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyUpdate(Message message) {
        for(Observer o : observers) {
            o.update(message);
        }
    }
}
