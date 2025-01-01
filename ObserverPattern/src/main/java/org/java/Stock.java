package org.java;

import org.java.Observable.IphoneObservableImpl;
import org.java.Observable.StockObservable;
import org.java.Observer.EmailAlertObserverImpl;
import org.java.Observer.NotificationAlertObserver;
import org.java.Observer.PhoneAlertObserverImpl;

public class Stock {
    public static void main(String[] args) {
        StockObservable iphoneObservavle = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("rohanbadgujar@gmail.com",iphoneObservavle);
        NotificationAlertObserver observer2=new EmailAlertObserverImpl("rohan@gmail.com",iphoneObservavle);
        NotificationAlertObserver observer3= new PhoneAlertObserverImpl("9075130922",iphoneObservavle);

        iphoneObservavle.add(observer1);
        iphoneObservavle.add(observer2);
        iphoneObservavle.add(observer3);

        iphoneObservavle.setStockCount(10);
    }
}