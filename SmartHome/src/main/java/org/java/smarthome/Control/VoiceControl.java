package org.java.smarthome.Control;

public class VoiceControl implements ControlMode{
    @Override
    public void execute(String command) {
        System.out.println("Executing via Voice" + command);
    }
}

