package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .flatMap(Stream::ofNullable)
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparing(profile -> profile.getAddress().getCity()))
                .map(Profile::getAddress)
                .distinct()
                .collect(Collectors.toList());
    }
}