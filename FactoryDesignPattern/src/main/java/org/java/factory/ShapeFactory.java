package org.java.factory;

import org.java.factory.ShapeClasses.Circle;
import org.java.factory.ShapeClasses.Rectangel;

public class ShapeFactory
{
    Shape getShape(String input){
        switch (input){
            case "Circle" : return new Circle();
            case "Reactangle" : return new Rectangel();
            default: return null;
        }
    }
}
