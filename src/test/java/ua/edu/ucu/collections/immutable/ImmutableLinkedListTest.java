package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class ImmutableLinkedListTest extends TestCase {

    private ImmutableLinkedList linkedList;
    private ImmutableList newLinkedList;

    public void setUp() throws Exception {
        super.setUp();
        this.linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
    }

    public void testAdd() {
        newLinkedList = linkedList.add(4);
        Object[] actual = newLinkedList.toArray();
        Object[] expected = {1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testTestAdd() {
        newLinkedList = linkedList.add(1,4);
        Object[] actual = newLinkedList.toArray();
        Object[] expected = {1, 4, 2, 3};
        for (int i = 0; i < 4; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testGet() {
        assertEquals(1, linkedList.get(0));
    }

    public void testIndexOf() {
        assertEquals(0, linkedList.indexOf(1));
    }

    public void testSize() {
        assertEquals(3, linkedList.size());
    }

    public void testClear() {
        newLinkedList = linkedList.clear();
        Object[] actual = newLinkedList.toArray();
        for (int i =0; i < 3; i++) {
            assertNull(actual[i]);
        }
    }

    public void testIsEmpty() {
        assertFalse(linkedList.isEmpty());
    }

    public void testGetHead() {
        assertEquals("1", linkedList.getHead().toString());
    }

    public void testGetTail() {
        assertEquals("3", linkedList.getTail().toString());
    }

    public void testGetFirst() {
        assertEquals("1", linkedList.getFirst().toString());
    }

    public void testGetLast() {
        assertEquals("3", linkedList.getLast().toString());
    }
}