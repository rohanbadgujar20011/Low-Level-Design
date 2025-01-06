# Smart Home Automation System

This project demonstrates the **Strategy**, **Observer**, and **Decorator** design patterns in a single cohesive application. The system models a Smart Home Automation System where users can control devices using different modes, receive notifications for device state changes, and dynamically enhance device functionalities.

---

## **Features**

- **Dynamic Device Control**: Select different control modes such as Voice, App, or Remote.
- **Real-time Notifications**: Receive updates on your phone or email when device states change.
- **Enhanced Functionality**: Add features like Energy Monitoring or Auto-Shutdown to devices dynamically.

---

## **Design Patterns Used**

### 1. **Strategy Pattern**
Used to implement multiple control modes for interacting with devices.
- **Component Interface**: Defines a common interface for all control modes.
- **Concrete Strategies**: Implements specific control mechanisms.

### 2. **Observer Pattern**
Used for real-time notifications when device states change.
- **Observable**: Represents the device being monitored.
- **Observers**: Represents different notification mechanisms like phone or email.

### 3. **Decorator Pattern**
Used to dynamically add functionality to devices.
- **Base Component**: Represents a smart device with basic functionality.
- **Concrete Decorators**: Adds features like Energy Monitoring or Auto-Shutdown to devices.

---

## **Project Structure**

### **1. Strategy Pattern Implementation**
#### Control Modes
```java
public interface ControlMode {
    void execute(String command);
}

public class VoiceControl implements ControlMode {
    @Override
    public void execute(String command) {
        System.out.println("Executing via voice: " + command);
    }
}

public class AppControl implements ControlMode {
    @Override
    public void execute(String command) {
        System.out.println("Executing via app: " + command);
    }
}

public class RemoteControl implements ControlMode {
    @Override
    public void execute(String command) {
        System.out.println("Executing via remote: " + command);
    }
}
```

### **2. Observer Pattern Implementation**
#### Device State Notifications
```java
import java.util.ArrayList;
import java.util.List;

public class Device {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

public interface Observer {
    void update(String state);
}

public class PhoneNotification implements Observer {
    @Override
    public void update(String state) {
        System.out.println("Phone notification: Device state changed to " + state);
    }
}

public class EmailNotification implements Observer {
    @Override
    public void update(String state) {
        System.out.println("Email notification: Device state changed to " + state);
    }
}
```

### **3. Decorator Pattern Implementation**
#### Enhance Device Features
```java
public abstract class SmartDevice {
    public abstract void turnOn();
    public abstract void turnOff();
}

public class Light extends SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Light is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

public abstract class DeviceFeatureDecorator extends SmartDevice {
    protected SmartDevice device;

    public DeviceFeatureDecorator(SmartDevice device) {
        this.device = device;
    }
}

public class EnergyMonitoring extends DeviceFeatureDecorator {
    public EnergyMonitoring(SmartDevice device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
        System.out.println("Energy monitoring enabled.");
    }

    @Override
    public void turnOff() {
        device.turnOff();
        System.out.println("Energy monitoring disabled.");
    }
}

public class AutoShutdown extends DeviceFeatureDecorator {
    public AutoShutdown(SmartDevice device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
        System.out.println("Auto-shutdown feature active.");
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }
}
```

---

## **Client Code**
```java
public class Main {
    public static void main(String[] args) {
        // Strategy Pattern
        ControlMode controlMode = new VoiceControl();
        controlMode.execute("Turn on the light");

        // Observer Pattern
        Device lightDevice = new Device();
        Observer phoneObserver = new PhoneNotification();
        Observer emailObserver = new EmailNotification();

        lightDevice.addObserver(phoneObserver);
        lightDevice.addObserver(emailObserver);
        lightDevice.setState("ON");

        // Decorator Pattern
        SmartDevice light = new Light();
        SmartDevice enhancedLight = new EnergyMonitoring(new AutoShutdown(light));

        enhancedLight.turnOn();
        enhancedLight.turnOff();
    }
}
```

---

## **Benefits of the Project**

- **Strategy Pattern**: Offers flexible control mechanisms.
- **Observer Pattern**: Enables real-time notifications.
- **Decorator Pattern**: Adds modular and dynamic functionality.

---

## **How to Run**
1. Clone the repository.
2. Compile and run the `Main` class.
3. Observe how the patterns interact to provide a cohesive Smart Home Automation experience.

---

## **License**
This project is licensed under the MIT License. Feel free to modify and extend it as needed.

