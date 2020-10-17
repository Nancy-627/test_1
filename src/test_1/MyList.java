package test_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyList<E> implements List<E> {

    private Object[] elementData={};

    private int size;

    private int cursor = -1;

    public MyList() {
        elementData = new Object[10];
    }

    public MyList(Collection<? extends E> collection) {
        elementData = collection.toArray();
        size = elementData.length;
        if (elementData.getClass() !=Object[].class) {
            elementData = Arrays.copyOf(elementData, size, Object[].class
            );
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add( Object obj) {
        ensureCapacity();
       elementData[size++] = obj;


    }

    private void rangCheck(int index) {
        if (index < 0 || index >=size) {
            throw new IllegalArgumentException();
        }
    }

    private void ensureCapacity() {
        if (size == elementData.length) {
            Object[] newArray = new Object[size*2 + 1]; //扩容
            System.arraycopy(elementData, 0, newArray, 0, elementData.length); //拷贝原数组内容到扩容后数组
            elementData = newArray;
        }
    }

    @Override
    public void remove(int index) {
        rangCheck(index);
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size--]=null;

    }

    @Override
    public E get(int index) {
        rangCheck(index);
        return (E) elementData[index];
    }

    @Override
    public void set(int index, Object obj) {
        rangCheck(index);
        elementData[index] = obj;

    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0 ; i < size; i++) {
            if (elementData[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size ==0 ?true:false;
    }

    @Override
    public void clear() {
        for (int i = 0; i<size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

public Iterator<E> iterator() {
    Iterator<E> iterator = new Iterator<E>() {
        @Override
        public boolean hasNext() {
            return cursor + 1 < size;
        }

        @Override
        public E next() {
            cursor++;
            return (E) elementData[cursor];
        }

        public void remove() {
            cursor++;
            elementData[cursor] = null;
        }
    };
    return iterator;
}



}
