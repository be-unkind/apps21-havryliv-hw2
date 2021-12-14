package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList linkedList;

    public Stack(){
        this.linkedList = new ImmutableLinkedList();
    }

    public void push(Object e) {
        this.linkedList = linkedList.addFirst(e);
    }

    public Object pop() {
        Object result = peek();
        this.linkedList = linkedList.removeFirst();
        return result;
    }

    public Object peek() {
        return linkedList.getFirst();
    }
}
