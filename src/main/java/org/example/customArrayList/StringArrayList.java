package org.example.customArrayList;

import org.example.customInterface.StringList;
import org.example.stringListExceptions.StringNotFoundException;

public class StringArrayList implements StringList {
    private String[] values;
    private int size;
    private boolean isEmpty = true;

    public StringArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.values = new String[initialCapacity];
            size = 0;
        } else {
            throw new IllegalArgumentException("Недопустимый размер: " + initialCapacity);
        }
    }

    public StringArrayList() {
        this.values = new String[0];
        size = 0;
    }

    @Override
    public String add(String item) {
        checkNullPointerExceptionException(item);
        if (isBoundsAreReached()) {
            values = newArray(true);
        }
        values[size] = item;
        size++;
        isEmpty = false;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkIndexOutOfBoundsException(index);
        checkNullPointerExceptionException(item);

        shiftArray(index, true);
        values[index] = item;
        size++;
        isEmpty = false;

        return item;
    }

    @Override
    public String set(int index, String item) {


        checkNullPointerExceptionException(item);

        String previous = "";
        previous = values[index];
        values[index] = item;

        return previous;
    }

    @Override
    public String remove(String item) {
        boolean isExist = false;
        checkNullPointerExceptionException(item);
        String previous = "";
        for (int i = 0; i < size; i++) {
            if (values[i].equals(item)) {
                previous = values[i];
                shiftArray(i, false);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            throw new StringNotFoundException("Такой строки в листе нет");
        }
        size--;

        if (size == 0) {
            isEmpty = true;
        }
        return previous;
    }

    @Override
    public String remove(int index) {
        checkIndexOutOfBoundsException(index);
        String s = values[index];
        shiftArray(index, false);
        size--;
        if (size == 0) {
            isEmpty = true;
        }
        return s;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (values[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndexOutOfBoundsException(index);
        return values[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        checkNullPointerExceptionException(otherList);
        if (otherList.size() != this.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!otherList.get(i).equals(values[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void clear() {
        size = 0;
        values = new String[0];
        isEmpty = true;
    }

    @Override
    public String[] toArray() {
        String[] newVal = new String[size];
        for (int i = 0; i < size; i++) {
            newVal[i] = values[i];
        }
        return newVal;
    }


    //custom methods
    private boolean isBoundsAreReached() {
        return values.length <= size;
    }

    private String[] newArray(boolean expand) {
        String[] newVal;

        if (expand) {
            newVal = new String[values.length + 1];
        } else {
            newVal = new String[values.length];
        }
        for (int i = 0; i < size; i++) {
            newVal[i] = values[i];
        }
        return newVal;
    }

    private void shiftArray(int index, boolean right) {
        String[] newVal;

        if (right) {
            if (isBoundsAreReached()) {
                values = newArray(true);
            } else {
                values = newArray(false);
            }
            for (int i = values.length - 1; i > index; i--) {
                values[i] = values[i - 1];
            }
        } else {
            values = newArray(false);
            for (int i = index; i < values.length - 1; i++) {
                values[i] = values[i + 1];
            }
        }
    }

    private void checkNullPointerExceptionException(Object item) {
        if (item == null) {
            throw new NullPointerException("Переданный в метод параметр равен 'null'");
        }
    }
    private void checkIndexOutOfBoundsException(int index){
        if(index>=size){
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс '" + index + "' для размера '" + size + "'");
        }
    }
}
