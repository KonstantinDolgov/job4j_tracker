package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "DDD"),
                new Item(2, "FFF"),
                new Item(3, "XXX"),
                new Item(4, "AAA"),
                new Item(5, "CCC")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(List.of(
                new Item(3, "XXX"),
                new Item(2, "FFF"),
                new Item(1, "DDD"),
                new Item(5, "CCC"),
                new Item(4, "AAA")
        ));
    }

}