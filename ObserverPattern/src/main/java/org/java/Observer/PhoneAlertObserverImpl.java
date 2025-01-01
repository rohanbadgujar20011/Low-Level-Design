package org.java.Observer;

import org.java.Observable.StockObservable;

public class PhoneAlertObserverImpl implements NotificationAlertObserver {
    String phoneNumber;
    StockObservable stockObservable;

    public PhoneAlertObserverImpl(String  phoneNumber, StockObservable stockObservable) {
        this.phoneNumber = phoneNumber;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendToNumber(phoneNumber , "Hurry Up Product in Stocks");
    }

    public void sendToNumber(String phoneNumber , String msg){
        System.out.println("Msg send to Number :" + phoneNumber);

    }
}
