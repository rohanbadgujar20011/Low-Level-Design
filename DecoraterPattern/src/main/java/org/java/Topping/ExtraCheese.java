package org.java.Topping;

import org.java.Pizza.BasePizza;
import org.java.ToppingDecorator;

public class ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;
    public ExtraCheese(BasePizza pizza){
        this.basePizza=pizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() +110;
    }
}
