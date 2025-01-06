# Factory Method Design Pattern with Shapes

This project demonstrates the **Factory Method Design Pattern** using two shapes: `Circle` and `Rectangle`. The Factory Method Pattern provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.

## Overview

The **Factory Method Design Pattern** is a creational design pattern that provides a way to create objects without specifying their exact classes. This project uses a `ShapeFactory` to instantiate different shape objects (`Circle` and `Rectangle`) based on a provided input string.

## Project Structure

```
org/java/factory/
├── Shape.java                 # Interface for shapes
├── ShapeFactory.java          # Factory class to create shapes
└── ShapeClasses/
    ├── Circle.java            # Implementation of Shape (Circle)
    ├── Rectangle.java         # Implementation of Shape (Rectangle)
```

### Classes

#### `Shape` Interface
This interface defines a method `draw()` that must be implemented by all concrete shape classes.

```java
package org.java.factory;

public interface Shape {
    void draw();
}
```

#### `Circle` Class
Implements the `Shape` interface and provides the implementation for the `draw()` method.

```java
package org.java.factory.ShapeClasses;

import org.java.factory.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
```

#### `Rectangle` Class
Implements the `Shape` interface and provides the implementation for the `draw()` method.

```java
package org.java.factory.ShapeClasses;

import org.java.factory.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
```

#### `ShapeFactory` Class
The factory class contains a method `getShape(String input)` that returns the appropriate shape object based on the input.

```java
package org.java.factory;

import org.java.factory.ShapeClasses.Circle;
import org.java.factory.ShapeClasses.Rectangle;

public class ShapeFactory {
    public Shape getShape(String input) {
        switch (input) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            default:
                return null;
        }
    }
}
```

## Usage

1. Create an instance of the `ShapeFactory` class.
2. Use the `getShape(String input)` method to obtain a `Shape` object.
3. Call the `draw()` method on the `Shape` object to perform the desired action.

### Example
```java
package org.java.factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("Circle");
        if (circle != null) {
            circle.draw();
        }

        Shape rectangle = shapeFactory.getShape("Rectangle");
        if (rectangle != null) {
            rectangle.draw();
        }
    }
}
```

### Output
```
Drawing Circle
Drawing Rectangle
```

## Advantages

- Promotes loose coupling by reducing the dependency between the client code and the specific classes.
- Provides a single point of control for creating objects.
- Makes the code more scalable and easier to maintain.

## Disadvantages

- Adds complexity to the code.
- May require additional classes or methods for simple object creation scenarios.

## How to Run

1. Clone the repository.
2. Compile the Java files using the following command:
   ```bash
   javac org/java/factory/*.java org/java/factory/ShapeClasses/*.java
   ```
3. Run the `Main` class:
   ```bash
   java org.java.factory.Main
   ```

