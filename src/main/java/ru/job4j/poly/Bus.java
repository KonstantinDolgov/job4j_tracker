package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("В город");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Вмещает " + count + " пасажиров");
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 44.5;
    }
}
