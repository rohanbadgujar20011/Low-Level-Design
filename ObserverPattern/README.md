What is the Observer Design Pattern?
The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency between objects. When one object (the subject) changes state, all its dependents (observers) are notified and updated automatically. It primarily deals with the interaction and communication between objects, specifically focusing on how objects behave in response to changes in the state of other objects.

Note: Subjects are the objects that maintain and notify observers about changes in their state, while Observers are the entities that react to those changes.

# Observer Design Pattern Implementation

This repository demonstrates the implementation of the **Observer Design Pattern** in Java. The example used is a stock notification system for iPhones, where multiple observers (e.g., email alerts, phone alerts) are notified when the stock count changes.

## **Packages and Classes**

### **1. `org.java`**
- Contains the `Stock` class with the `main` method to execute the program.

### **2. `org.java.Observable`**
- **`StockObservable` (Interface):**
    - Methods:
        - `add(NotificationAlertObserver notificationAlertObserver)`: Adds an observer.
        - `remove(NotificationAlertObserver notificationAlertObserver)`: Removes an observer.
        - `notifySubscriber()`: Notifies all subscribed observers.
        - `setStockCount(int newStock)`: Updates the stock count.
        - `getStockCount()`: Returns the current stock count.

- **`IphoneObservableImpl` (Implementation):**
    - Implements `StockObservable`.
    - Maintains a list of observers and notifies them when stock updates occur.

### **3. `org.java.Observer`**
- **`NotificationAlertObserver` (Interface):**
    - Method:
        - `update()`: Called to notify the observer of changes.

- **`EmailAlertObserverImpl` (Implementation):**
    - Sends notifications via email.

- **`PhoneAlertObserverImpl` (Implementation):**
    - Sends notifications via phone alert.

## **How It Works**

1. Create an instance of `IphoneObservableImpl` (the observable object).
2. Add observers (e.g., `EmailAlertObserverImpl`, `PhoneAlertObserverImpl`) to the observable.
3. Update the stock count using `setStockCount()`. When the stock is updated, all subscribed observers are notified.

## **Code Example**

### **Main Class**
```java
import org.java.Observable.IphoneObservableImpl;
import org.java.Observable.StockObservable;
import org.java.Observer.EmailAlertObserverImpl;
import org.java.Observer.NotificationAlertObserver;
import org.java.Observer.PhoneAlertObserverImpl;

public class Stock {
    public static void main(String[] args) {
        StockObservable iphoneObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("rohanbadgujar@gmail.com", iphoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("rohan@gmail.com", iphoneObservable);
        NotificationAlertObserver observer3 = new PhoneAlertObserverImpl("9075130922", iphoneObservable);

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        iphoneObservable.setStockCount(10);
    }
}
```

### **Observable Interface**
```java
package org.java.Observable;

import org.java.Observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver notificationAlertObserver);
    void remove(NotificationAlertObserver notificationAlertObserver);
    void notifySubscriber();
    void setStockCount(int newStock);
    int getStockCount();
}
```

### **Observable Implementation**
```java
package org.java.Observable;

import org.java.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {
    List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observerList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscriber() {
        for (NotificationAlertObserver observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStock) {
        if (stockCount == 0) {
            notifySubscriber();
        }
        stockCount += newStock;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
```

### **Observer Interface**
```java
package org.java.Observer;

public interface NotificationAlertObserver {
    void update();
}
```

### **Email Alert Observer Implementation**
```java
package org.java.Observer;

import org.java.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    private String email;
    private StockObservable stockObservable;

    public EmailAlertObserverImpl(String email, StockObservable stockObservable) {
        this.email = email;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Email sent to " + email + ": iPhone stock is now available!");
    }
}
```

### **Phone Alert Observer Implementation**
```java
package org.java.Observer;

import org.java.Observable.StockObservable;

public class PhoneAlertObserverImpl implements NotificationAlertObserver {
    private String phoneNumber;
    private StockObservable stockObservable;

    public PhoneAlertObserverImpl(String phoneNumber, StockObservable stockObservable) {
        this.phoneNumber = phoneNumber;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("SMS sent to " + phoneNumber + ": iPhone stock is now available!");
    }
}
```

## **How to Run**
1. Clone this repository.
2. Compile all the `.java` files.
3. Run the `Stock` class.

## **Output**
```
Email sent to rohanbadgujar@gmail.com: iPhone stock is now available!
Email sent to rohan@gmail.com: iPhone stock is now available!
SMS sent to 9075130922: iPhone stock is now available!
```

