package org.java.factory.ShapeClasses;

import org.java.factory.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
