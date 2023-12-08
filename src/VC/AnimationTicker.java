package src.VC;

import java.util.ArrayList;
import java.util.List;

public class AnimationTicker {

    public void animate(){
        try {
            while (true) {
                Thread.sleep(50);
                notifyObservers();
            }
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }

    private final List<AnimationTickerObserver> observers = new ArrayList<>();

    public void addObserver(AnimationTickerObserver observer){
        observers.add(observer);
    }

    protected void notifyObservers(){
        for (AnimationTickerObserver observer : observers)
            observer.actOnAnimationTicker();
    }

}
