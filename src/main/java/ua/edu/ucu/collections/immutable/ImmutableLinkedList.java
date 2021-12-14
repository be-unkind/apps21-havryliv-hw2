package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableLinkedList implements ImmutableList {

    private int length;
    private Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        this.head = null;
        this.tail = null;
        this.length = 0;
        Node currentNode = null;
        for (Object element: elements){
            Node newNode = new Node();
            newNode.setValue(element);
            if (currentNode != null){
                currentNode.setNext(newNode);
            }
            newNode.setPrevious(currentNode);
            currentNode = newNode;
            if (this.length == 0){
                this.head = newNode;
            }
            if (this.length == elements.length - 1){
                this.tail = newNode;
            }
            this.length++;
        }
    }

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return this.addAll(this.length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return this.addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(this.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] ourList = Arrays.copyOf(this.toArray(), this.length);
        Object[] finalArray = new Object[this.length + c.length];
        for (int i = 0; i < finalArray.length; i++) {
            if (i < index) {
                finalArray[i] = ourList[i];
            } else if (i < index + c.length) {
                finalArray[i] = c[i - index];
            } else {
                finalArray[i] = ourList[i - c.length];
            }
        }
        return new ImmutableLinkedList(finalArray);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = this.head;
        int currentIdx = 0;
        while (currentNode != null) {
            if (currentIdx == index) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
            currentIdx++;
        }
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] currentList = Arrays.copyOf(this.toArray(), this.length);
        Object[] newList = new Object[this.length - 1];
        int count = 0;
        for (int i = 0; i < this.length; i++) {
            if (i == index) {
                continue;
            }
            newList[count++] = currentList[i];
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList linkedList = this.remove(index);
        return linkedList.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node currentNode = this.head;
        int count = 0;
        while (currentNode != null) {
            if (currentNode.getValue() == e) {
                return count;
            }
            count++;
            currentNode = currentNode.getNext();
        }
        throw new InputMismatchException();
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        Object[] resultList = new Object[this.length];
        return new ImmutableLinkedList(resultList);
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] resultList = new Object[this.length];
        Node currentNode = this.head;
        int count = 0;
        while (currentNode != null) {
            resultList[count++] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return resultList;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] currentList = Arrays.copyOf(this.toArray(), this.length);
        Object[] newList = new Object[this.length + 1];
        newList[0] = e;
        for (int i = 1; i <= this.length; ++i) {
            newList[i] = currentList[i-1];
        }
        return new ImmutableLinkedList(newList);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] currentList = Arrays.copyOf(this.toArray(), this.length);
        Object[] newList = new Object[this.length + 1];
        newList[this.length] = e;
        for (int i = 0; i < this.length; ++i) {
            newList[i] = currentList[i];
        }
        return new ImmutableLinkedList(newList);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        if (this.head != null) {
            return head.getValue();
        }
        throw new InputMismatchException();
    }

    public Object getLast() {
        if (this.tail != null) {
            return tail.getValue();
        }
        throw new InputMismatchException();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) this.remove(this.length-1);
    }
}
