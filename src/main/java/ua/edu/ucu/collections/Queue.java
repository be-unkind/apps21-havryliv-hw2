package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedlist;

    public Queue(){
        this.linkedlist = new ImmutableLinkedList();
    }
    public Object peek() {
        return linkedlist.getFirst();
    }

    public Object dequeue() {
        Object result = peek();
        this.linkedlist = linkedlist.removeFirst();
        return result;
    }

    public void enqueue(Object e) {
        this.linkedlist = linkedlist.addLast(e);
    }
}
