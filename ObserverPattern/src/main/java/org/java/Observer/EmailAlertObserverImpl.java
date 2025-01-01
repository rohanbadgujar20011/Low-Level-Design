package org.java.Observer;

import org.java.Observable.StockObservable;

public class EmailAlertObserverImpl  implements  NotificationAlertObserver{
    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId , StockObservable stockObservable) {
        this.emailId =emailId;
        this.observable=stockObservable;
    }

    @Override
    public void update() {
        sendMail(emailId , "Please Hurry up product in stock");

    }
    public  void sendMail(String emailId , String msg){
        System.out.println("Email send to : "+ emailId);

    }
}
