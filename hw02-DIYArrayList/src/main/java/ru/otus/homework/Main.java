package ru.otus.homework;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        DIYArrayList<Integer> addAll = new DIYArrayList<>();
        Collections.addAll(addAll, 2,2,2,2,2,2,2,2,2,22,2,2,2,2,2,22,2,2,2,2,22,2,2);
        System.out.println(addAll);
        DIYArrayList<Integer> src = new DIYArrayList<>(new Integer[]{1,2,3,4,5,1,1,1,1,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        DIYArrayList<Integer> dest = new DIYArrayList<>(50);
        System.out.println(src.size() + " " + dest.size());
        Collections.copy(dest, src);
        System.out.println(dest);
        dest.toArray();
    }

}
