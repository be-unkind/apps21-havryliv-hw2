package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {

    private Object[] elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    public ImmutableArrayList() {
        this.elements = new Object[] {};
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(elements.length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(elements.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] resultList = new Object[elements.length + c.length];
        for (int i = 0; i < resultList.length; ++i) {
            if (i < index) {
                resultList[i] = elements[i];
            } else if (i < index + c.length) {
                resultList[i] = c[i - index];
            } else {
                resultList[i] = elements[i - c.length];
            }
        }
        return new ImmutableArrayList(resultList);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] res = new Object[elements.length-1];
        int count = 0;
        for (int i = 0; i < elements.length; ++i) {
            if (i == index) {
                continue;
            }
            res[count++] = elements[i];
        }
        return new ImmutableArrayList(res);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList arrayList = remove(index);
        return arrayList.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == e) {
                return i;
            }
        }
        throw new InputMismatchException();
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableList clear() {
        Object[] clearList = new Object[elements.length];
        return new ImmutableArrayList(clearList);
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }
}
