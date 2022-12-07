package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> containsName = x -> x.getName().contains(key);
        Predicate<Person> containsSurname = x -> x.getSurname().contains(key);
        Predicate<Person> containsPhone = x -> x.getPhone().contains(key);
        Predicate<Person> containsAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = containsName.or(containsSurname).
                or(containsPhone).or(containsAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
