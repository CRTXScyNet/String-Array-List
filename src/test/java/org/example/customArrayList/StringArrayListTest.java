package org.example.customArrayList;

import org.example.stringListExceptions.StringNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayListTest {
    private StringArrayList list;

    @BeforeEach
    public void init() {
        list = new StringArrayList();
    }

    @Test
    void add() {
        StringArrayList list1 = new StringArrayList();
        list1.add("Hello");
        //given
        //do
        //then
        assertEquals("Hello", list.add("Hello"));
        assertTrue(list.equals(list1));
    }

    @Test
    void addWithIndex() {
        //given
        StringArrayList list1 = new StringArrayList();
        list1.add("Hello");
        list1.add("Hi");

        list.add("Hi");
        //do
        //then
        assertEquals("Hello", list.add(0, "Hello"));
        assertTrue(list.equals(list1));
    }

    @ParameterizedTest
    @MethodSource(value = "illegalIndexArguments")
    void addWithIllegalIndexShouldThrowException(int i) {
        //given
        //do
        //then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.add(i, "Hello"));
    }

    @Test
    void addNullShouldThrowException() {
        //given
        //do
        //then
        assertThrows(NullPointerException.class, () -> list.add(null));

    }

    @Test
    void addNullWithIndex() {
        //given
        list.add("sdfsdf");
        //do
        //then
        assertThrows(NullPointerException.class, () -> list.add(0, null));
    }

    @Test
    void set() {
        //given
        StringArrayList list1 = new StringArrayList();
        list1.add("Hello");
        //do
        list.add("Hi");
        //then
        assertEquals("Hi", list.set(0, "Hello"));
        assertTrue(list.equals(list1));
    }

    @ParameterizedTest
    @MethodSource(value = "illegalIndexArguments")
    void setWithIllegalIndexShouldThrowException(int i) {
        //given
        //do
        //then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.set(i, "Hello"));
    }

    @Test
    void remove() {
        //given
        StringArrayList list1 = new StringArrayList();

        //do
        list.add("Hello");
        //then
        assertEquals("Hello", list.remove("Hello"));
        assertTrue(list.equals(list1));
    }

    @Test
    void removeByIndex() {
        //given
        StringArrayList list1 = new StringArrayList();

        //do
        list.add("Hello");
        //then
        assertEquals("Hello", list.remove(0));
        assertTrue(list.equals(list1));
    }

    @ParameterizedTest
    @MethodSource(value = "illegalIndexArguments")
    void removeByIllegalIndexShouldThrowException(int i) {
        //given
        //do
        //then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(i));

    }

    static Stream<Arguments> illegalIndexArguments() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(0),
                Arguments.of(-1)
        );
    }

    @Test
    void removeNotExistedShouldThrowException() {
        //given
        //do
        list.add("Hello");
        //then
        assertThrows(StringNotFoundException.class, () -> list.remove("sdf"));
    }


    @Test
    void contains() {
        //given
        list.add("Hi");
        //do
        //then
        assertTrue(list.contains("Hi"));
    }

    @Test
    void notContains() {
        //given
        list.add("Hi");
        //do
        //then
        assertFalse(list.contains("hi"));
    }

    @Test
    void indexOf() {
        //given
        list.add("Hi");
        list.add("Ho");
        list.add("Ho");
        //do
        //then
        assertEquals(1, list.indexOf("Ho"));
    }

    @Test
    void lastIndexOf() {
        //given
        list.add("Hi");
        list.add("Ho");
        list.add("Ho");
        //do
        //then
        assertEquals(2, list.lastIndexOf("Ho"));
    }

    @Test
    void get() {
        //given
        list.add("Hi");
        list.add("Ho");
        list.add("Ho");
        //do
        //then
        assertEquals("Ho", list.get(2));
    }

    @ParameterizedTest
    @MethodSource(value = "illegalIndexArguments")
    void getByIllegalIndexShouldThrowException(int i) {
        //given
        //do
        //then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(i));
    }

    @Test
    void testEquals() {
        //given
        StringArrayList list1 = new StringArrayList();
        list1.add("Hello");
        list.add("Hello");
        //do
        //then
        assertTrue(list.equals(list1));
    }

    @Test
    void testNotEquals() {
        //given
        StringArrayList list1 = new StringArrayList();
        list1.add("Hello");

        //do
        //then
        assertFalse(list.equals(list1));
    }

    @Test
    void testEqualsWithNullShouldThrowException() {
        //given
        StringArrayList list1 = null;


        //do
        //then
        assertThrows(NullPointerException.class, () -> list.equals(list1));
    }

    @Test
    void size() {
        //given
        list.add("Hi");
        list.add("Ho");
        list.add("Ho");
        //do
        //then
        assertEquals(3, list.size());
    }

    @Test
    void isEmpty() {
        //given
        //do
        //then
        assertTrue(list.isEmpty());
    }

    @Test
    void isNotEmpty() {
        //given
        list.add("Ho");
        //do
        //then
        assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        //given
        list.add("Hi");
        list.add("Ho");
        list.add("Ho");
        //do
        list.clear();
        //then
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void toArray() {
        //given
        String[] strings = {"Hi", "Ho", "Ho"};
        list.add("Hi");
        list.add("Ho");
        list.add("Ho");
        //do
        //then
        assertTrue(list.toArray() instanceof String[]);
    }
}