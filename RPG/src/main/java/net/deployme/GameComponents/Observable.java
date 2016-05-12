package net.deployme.GameComponents;

import java.util.List;
import java.util.ArrayList;
import java.util.Observer;

public abstract class Observable extends java.util.Observable {
    List<Observer> observerList = new ArrayList<Observer>();
    public void notifyObservers() {
        //System.out.println("called notify");
        for(Observer obs : observerList) {
            obs.update(this, null);
        }
    }
    public void notifyObservers(Object o) {
        for(Observer obs : observerList) {
            obs.update(this, o);
        }
    }
    public void registerObserver(Observer obs) {
        observerList.add(obs);
    }
    public void unregisterObserver(Observer obs) {
        observerList.remove(obs);
    }
}
