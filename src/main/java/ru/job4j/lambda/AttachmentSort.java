package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        ArrayList<Integer> list = new ArrayList<Integer>() {
            @Override
            public boolean add(Integer o) {
                System.out.println("Add a new element to list: " + o);
                return super.add(o);
            }
        };
        list.add(100500);
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> comparatorName = new Comparator<Attachment>() {
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}