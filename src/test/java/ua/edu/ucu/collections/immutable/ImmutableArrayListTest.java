package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class ImmutableArrayListTest extends TestCase {

    private ImmutableArrayList arrayList;
    private ImmutableList newArrayList;

    public void setUp() throws Exception {
        super.setUp();
        this.arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
    }

    public void testAdd() {
        newArrayList = arrayList.add(4);
        Object[] expected = new Object[] {1, 2, 3, 4};
        Object[] actual = newArrayList.toArray();
        for (int i =0; i < 4; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    public void testTestAdd() {
        newArrayList = arrayList.add(1, 4);
        Object[] expected = new Object[] {1, 4, 2, 3};
        Object[] actual = newArrayList.toArray();
        for (int i =0; i < 4; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    public void testGet() {
        assertEquals(1, arrayList.get(0));
    }

    public void testIndexOf() {
        assertEquals(0, arrayList.indexOf(1));
    }

    public void testSize() {
        assertEquals(3, arrayList.size());
    }

    public void testClear() {
        newArrayList = arrayList.clear();
        Object[] actual = newArrayList.toArray();
        for (int i =0; i < 3; i++) {
            assertNull(actual[i]);
        }
    }

    public void testIsEmpty() {
        assertFalse(arrayList.isEmpty());
    }
}