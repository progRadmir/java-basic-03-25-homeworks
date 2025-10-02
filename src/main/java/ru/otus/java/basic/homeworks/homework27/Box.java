package ru.otus.java.basic.homeworks.homework27;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private List<T> fruits = new ArrayList<>();
    private int weight;

    public void putFruitInBox(T fruit) {
        fruits.add(fruit);
        weight += fruit.getFruitWeight();
    }

    public boolean compare(Box<? extends Fruit> box) {
        if(box.weight == this.weight) {
            return true;
        }
        return false;
    }

    public void transfer(Box<? super T> boxTo) {
        boxTo.fruits.addAll(fruits);
        fruits.clear();
    }

    public void whatInBox() {
        for(Fruit f : fruits) {
            if(f.getClass() == Apple.class) {
                System.out.print("Яблоко ");
            } else if(f.getClass() == Orange.class) {
                System.out.print("Апельсин ");
            }
        }
        System.out.println();
    }

}
