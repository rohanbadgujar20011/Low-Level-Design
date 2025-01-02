# Decorator Design Pattern in Java

The **Decorator Design Pattern** is a structural design pattern that allows the dynamic addition of behavior or functionality to individual objects without altering the behavior of other objects from the same class. This pattern is highly useful when you want to add responsibilities to objects without modifying their code.

---

## Key Features of the Decorator Pattern

- Provides a flexible and reusable alternative to subclassing for extending functionality.
- Follows the Open/Closed Principle by allowing classes to be open for extension but closed for modification.
- Enables composition of behavior at runtime by decorating objects dynamically.
- Separates concerns by allowing decorators to handle additional responsibilities.

---

## Components of the Decorator Pattern

- **Component Interface:** Defines the interface or abstract class for objects that can have additional responsibilities added dynamically.
- **Concrete Component:** The class that implements the component interface and provides the basic behavior.
- **Decorator:** An abstract class that implements the component interface and contains a reference to a component object.
- **Concrete Decorators:** Specific implementations of the decorator that add additional behavior or functionality.

---

## Example: Pizza Customization

### **Base Class**
```java
package org.java.Pizza;

public abstract class BasePizza {
    public abstract int cost();
}
```

### **Concrete Components**
```java
package org.java.Pizza;

public class Farmhouse extends BasePizza {
    @Override
    public int cost() {
        return 200;
    }
}

package org.java.Pizza;

public class Margherita extends BasePizza {
    @Override
    public int cost() {
        return 150;
    }
}

package org.java.Pizza;

public class VegDelight extends BasePizza {
    @Override
    public int cost() {
        return 120;
    }
}
```

### **Decorator Abstract Class**
```java
package org.java;

import org.java.Pizza.BasePizza;

public abstract class ToppingDecorator extends BasePizza {
}
```

### **Concrete Decorators**
```java
package org.java.Topping;

import org.java.Pizza.BasePizza;
import org.java.ToppingDecorator;

public class ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;

    public ExtraCheese(BasePizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 110;
    }
}

package org.java.Topping;

import org.java.Pizza.BasePizza;

public class Mushroom extends BasePizza {
    BasePizza basePizza;

    public Mushroom(BasePizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 100;
    }
}
```

### **Client Code**
```java
package org.java;

import org.java.Pizza.VegDelight;
import org.java.Topping.ExtraCheese;

public class Main {
    public static void main(String[] args) {
        System.out.println(new ExtraCheese(new VegDelight()).cost());
    }
}
```

---

## Advantages

- **Flexibility:** Enhances individual objects without modifying the code of others.
- **Reusability:** Can create different combinations of behavior at runtime.
- **Adherence to Principles:** Promotes Open/Closed Principle.

---

## Disadvantages

- **Complexity:** Can lead to an increase in the number of classes.
- **Debugging:** Tracing issues might become harder with multiple layers of decorators.

---

## When to Use

- When you need to add responsibilities to individual objects dynamically.
- When you want a flexible alternative to subclassing.

---

## When Not to Use

- When the design becomes too complex due to excessive layering of decorators.
- When the added complexity outweighs the benefits of using the pattern.

---


