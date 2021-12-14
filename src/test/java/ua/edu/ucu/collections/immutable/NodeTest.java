package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class NodeTest extends TestCase {

    private Node node1;
    private Node node2;

    public void setUp() throws Exception {
        super.setUp();
        node1 = new Node();
        node2 = new Node();
        this.node1.setValue(3);
        this.node2.setValue(5);
    }

    public void testTestToString() {
        assertEquals("5", node2.toString());
    }

    public void testGetPrevious() {
        node2.setPrevious(node1);
        assertEquals(node2.getPrevious().getValue(), node1.getValue());
    }

    public void testSetPrevious() {
        node2.setPrevious(node1);
        assertEquals(node2.getPrevious().getValue(), node1.getValue());
    }

    public void testGetValue() {
        assertEquals(3, node1.getValue());
    }

    public void testSetValue() {
        node1.setValue(1);
        assertEquals(1, node1.getValue());
    }

    public void testGetNext() {
        node1.setNext(node2);
        assertEquals(node2.getValue(), node1.getNext().getValue());
    }

    public void testSetNext() {
        node1.setNext(node2);
        assertEquals(node2.getValue(), node1.getNext().getValue());
    }
}