package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.Message;

public interface Observer {
    void update(Message message);
}
