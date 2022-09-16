package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void where() {
        System.out.println(getClass().getSimpleName() + " на рельсах");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам");
    }
}
