package nl.novi.dpcc.observerpattern.subject;

import nl.novi.dpcc.observerpattern.domain.Message;
import nl.novi.dpcc.observerpattern.observer.Observer;

// AKA Publisher
public interface Subject {

    void attach(Observer o);
    void detach(Observer o);
    void notifyUpdate(Message message);
}
