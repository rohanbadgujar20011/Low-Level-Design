package org.java.Observable;

import org.java.Observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver notificationAlertObserver);
    public void remove(NotificationAlertObserver notificationAlertObserver);
    public void notifySubsciber();
    public void setStockCount(int newStack);
    public int getStockcout();
}
