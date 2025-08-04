package ru.otus.java.basic.homeworks.homework12;

public class Plate {
    int maxAmountFood;
    int currentAmountFood;

    public Plate(int maxAmountFood) {
        this.maxAmountFood = maxAmountFood;
        currentAmountFood = maxAmountFood;
    }

    public void addFood(int amount) {
        currentAmountFood = Math.min(currentAmountFood + amount, maxAmountFood);
    }

    public boolean decreaseFood(int amount) {
        if (currentAmountFood - amount >= 0) {
            currentAmountFood -= amount;
            return true;
        }
        return false;
    }

}
