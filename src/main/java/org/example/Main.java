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
        System.out.println("Добавляем строку 'sdafs' без индекса");
        print(strings);
        strings.add(0, "change");
        System.out.println("Добавляем строку 'change' с индексом 0");
        print(strings);
        strings.set(1,"yourself");
        System.out.println("Заменяем строку с индексом 1 на 'yourself'");
        print(strings);
        strings.add(0, "hello");
        strings.add("hello");
        System.out.println("Добавляем строку 'hello' с индексом 0 и без индекса");
        print(strings);
        System.out.println("последний индекс строки 'hello': " + strings.lastIndexOf("hello"));
        System.out.println("первый индекс строки 'hello': " + strings.indexOf("hello"));
        strings.remove("change");
        System.out.println("Удаляем 'change'");
        print(strings);
        strings.remove(0);
        System.out.println("Удаляем строку с индексом 0");
        print(strings);

        StringArrayList strings2 = new StringArrayList(10);
        strings2.add("yourself");
        strings2.add("hello");
        System.out.println("Создаем дополнительный лист");
        print(strings2);
        System.out.println("Проверяем равны ли имеющиеся листы");
        System.out.println(strings.equals(strings2));
        System.out.println("Проверяем работу метода 'toArray()'");
        System.out.println(Arrays.toString(strings2.toArray()));
        System.out.println("Проверяем содержит ли лист строку 'hello'");
        System.out.println(strings2.contains("hello"));
        System.out.println("Выводим строку с индексом 1");
        System.out.println(strings2.get(1));
        System.out.println("Выводим размер списка");
        System.out.println(strings2.size());
        System.out.println("Проверяем пустой ли список");
        System.out.println(strings2.isEmpty());
        System.out.println("Очищаем список с помощью метода 'clear()'");
        strings2.clear();
        System.out.println("Снова проверяем пустой ли список");
        System.out.println(strings2.isEmpty());
        System.out.println("Снова проверяем равны ли имеющиеся листы");
        System.out.println(strings.equals(strings2));
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