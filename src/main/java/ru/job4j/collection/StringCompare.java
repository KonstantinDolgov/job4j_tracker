package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();
        int leftInt = 0;
        int rightInt = 0;
        if (!Arrays.equals(leftArr, rightArr)) {
            if (leftArr.length < rightArr.length) {
                leftArr = Arrays.copyOf(leftArr, rightArr.length);
            }
            if (leftArr.length > rightArr.length) {
                rightArr = Arrays.copyOf(rightArr, leftArr.length);
            }
            for (int i = 0; i < leftArr.length; i++) {
                if (leftArr[i] != rightArr[i]) {
                    leftInt = leftArr[i];
                    rightInt = rightArr[i];
                    break;
                }
            }
        }
        return Integer.compare(leftInt, rightInt);
    }
}