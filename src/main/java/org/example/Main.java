package org.example;

import org.example.customArrayList.StringArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<>(5);
//        strings.add(1,"asfdg");
//        System.out.println(strings);

        StringArrayList strings = new StringArrayList(1);
        strings.add("sdafs");
//        print(strings);
//        strings.add("sdafs");
//        print(strings);
//        strings.add(0, "change");
//        print(strings);
//        strings.add("sdafs");
//        print(strings);
        System.out.println(strings.set(0, "hello"));
//        print(strings);
//        strings.remove("change");
//        print(strings);
//        strings.remove(1);
//        print(strings);
//        System.out.println(strings.lastIndexOf("hello"));
//
//        StringArrayList strings2 = new StringArrayList(10);
//        strings2.add("helo");
//        System.out.println(strings.equals(strings2));
        System.out.println(Arrays.toString(strings.toArray()));
    }


    static void print(StringArrayList list) {
        System.out.print("[ ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
}