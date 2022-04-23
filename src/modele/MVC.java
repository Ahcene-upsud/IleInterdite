package modele;

import java.util.ArrayList;

interface Observer{
    public void update();

    }

abstract class Observable {
    private ArrayList<Observer> observers;

    public Observable(){ this.observers = new ArrayList<Observer>(); }

    public void addObserver(Observer o){ observers.add(o);}

    public void notifyObservers(){
        for(Observer o : observers){
            o.update();
        }
    }

}
