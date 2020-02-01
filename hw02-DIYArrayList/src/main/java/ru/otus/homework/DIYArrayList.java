package ru.otus.homework;

import java.util.*;

public class DIYArrayList<T> implements List<T> {
    private Object[] array;
    private int index;

    public DIYArrayList() {
        this.array = new Object[10];
        this.index = 0;

    }

    public DIYArrayList(Object[] array) {
        this.array = array;
        this.index = array.length;
    }

    public DIYArrayList(int index) {
        this.array = new Object[index];
        this.index = 0;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr(this);
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[index];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        if (index >= array.length) {
            Object[] newArray = new Object[(int) (array.length * 1.5 + 1)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[index] = t;
        index++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> iterator = c.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();

    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();

    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListItr(this);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                builder.append(array[i]);
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private class Itr implements Iterator<T> {

        private DIYArrayList<T> diyArrayList;
        private int index;

        public Itr(DIYArrayList<T> diyArrayList) {
            this.diyArrayList = diyArrayList;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < diyArrayList.size();
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) diyArrayList.array[index++];
        }
    }

    private class ListItr extends Itr implements ListIterator<T> {
        public ListItr(DIYArrayList<T> diyArrayList) {
            super(diyArrayList);
        }

        @Override
        public boolean hasPrevious() {
            return index != 0;
        }

        @Override
        public T previous() {
            throw new UnsupportedOperationException();

        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();

        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }

        @Override
        public void set(T t) {
            super.diyArrayList.index++;
            super.diyArrayList.array[super.index - 1] = t;
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();

        }

        private class DIYComparator implements Comparator<T> {
            @Override
            public int compare(T o1, T o2) {
                if (o1.hashCode() > o2.hashCode()) {
                    return 1;
                } else if (o1.hashCode() < o2.hashCode()) {
                    return -1;
                }
                return 0;
            }
        }
    }
}
