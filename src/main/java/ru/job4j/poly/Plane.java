package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void where() {
        System.out.println(getClass().getSimpleName() + " в небе");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }
}
