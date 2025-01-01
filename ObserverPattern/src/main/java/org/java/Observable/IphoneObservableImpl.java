package org.java.Observable;

import org.java.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements  StockObservable{

    List <NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCout=0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observerList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubsciber() {
        for (NotificationAlertObserver observer : observerList){
            observer.update();
        }

    }

    @Override
    public void setStockCount(int newStack) {
        if(stockCout==0){
            notifySubsciber();
        }
        stockCout = stockCout+newStack;

    }

    @Override
    public int getStockcout() {
        return stockCout;
    }
}
