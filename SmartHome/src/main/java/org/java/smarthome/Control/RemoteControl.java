package org.java.smarthome.Control;

public class RemoteControl implements ControlMode{

    @Override
    public void execute(String command) {
        System.out.println("Executing via Remote : " + command);
        
    }
}
