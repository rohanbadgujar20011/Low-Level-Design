package org.java.smarthome.Control;

public class AppControl implements ControlMode{

    @Override
    public void execute(String command) {
        System.out.println("Exectuing via App :" + command);
    }
}
