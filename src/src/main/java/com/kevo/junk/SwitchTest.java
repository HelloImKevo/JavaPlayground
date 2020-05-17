package com.kevo.junk;

/**
 * @author kevo
 */
public class SwitchTest {

    public enum Fruit {
        APPLE, BANANA, TOMATO
    }

    public static void main(String[] args) {
        int countTomatoes = 0;
        for (int i = 0; i < 100; i++) {
            switch (getRandomFruit()) {
                case APPLE:
                    break;
                case BANANA:
                    break;
                default:
                    break;
                case TOMATO:
                    System.out.println("Got a " + Fruit.TOMATO + "!!!");
                    countTomatoes++;
                    break;
            }
        }
        System.out.println("How many " + Fruit.TOMATO + ": " + countTomatoes);
    }

    static Fruit getRandomFruit() {
        double val = Math.random();
        if (val < 0.3) {
            return Fruit.APPLE;
        } else if (val < 0.6) {
            return Fruit.BANANA;
        } else {
            return Fruit.TOMATO;
        }
    }
}
