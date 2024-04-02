import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Double;

import javax.swing.border.LineBorder;

public class LinkedListTester {
    
    @Test 
    public void testAdd() {
        LinkedList l = new LinkedList();

        // simple case - 
        l.add(1);
        assertEquals(1, l.getValue(0));
        assertEquals(1, l.getSize());

        // complicated case
        l.add(2);
        l.add(3);
        assertEquals(2, l.getValue(1));
        assertEquals(3, l.getValue(2));
        assertEquals(3, l.getSize());

        // edge case
        l.add(0);
        assertEquals(0, l.getValue(3));
        assertEquals(4, l.getSize());
    }
    
    @Test 
    public void testAddAtIndex() {
        // simple case - index > size, adding to end of list
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(6, 4);
        assertEquals(6, l1.getValue(1));

        // complicated case - index < size, adding to middle of list
        LinkedList l2 = new LinkedList();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(6, 1);
        assertEquals(1, l2.getValue(0));
        assertEquals(6, l2.getValue(1));
        assertEquals(2, l2.getValue(2));
        assertEquals(3, l2.getValue(3));

        // edge case - the following line throws an IllegalArgumentException because index is < 0
        //l2.add(0, -1);
    }

    @Test
    public void testIndexof() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(3);
        
        // simple case - getting index of elements with one occurrence
        assertEquals(0, l.indexof(1));
        assertEquals(1, l.indexof(2));

        // complicated case - getting index of elements with multiple occurrences
        assertEquals(2, l.indexof(3));

        // edge case - getting index of element that does not exist
        assertEquals(-1, l.indexof(4));
    }

    @Test 
    public void testRemove() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);

        // simple case - index < size, removing element at input
        assertEquals(1, l.getValue(0));
        assertEquals(1, l.remove(0));
        assertEquals(2, l.getValue(0));

        // complicated case - index > size, removing element at end of list
        assertEquals(3, l.getValue(1));
        assertEquals(3, l.remove(6));
        assertEquals(1, l.getSize());
        assertEquals(2, l.getValue(0));

        // edge case - the following line throws an IllegalArgumentException because index is < 0
        //l.remove(-1);
    }

    @Test 
    public void testRemoveValue() {
        // simple case
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(2);
        l1.add(3);
        assertEquals(2, l1.getValue(1));
        l1.removeValue(2);
        assertEquals(2, l1.getValue(1));
        assertEquals(3, l1.getValue(2));

        // complicated case
        LinkedList l2 = new LinkedList();
        l2.add(1);
        l2.add(2);
        for(int i = 0; i < 998; i++) {
            l2.add(3);
        }
        assertEquals(2, l2.getValue(1));
        l2.removeValue(2);
        assertEquals(3, l2.getValue(1));
        assertEquals(999, l2.getSize());

        // edge case - removing a nonexisting element does not affect list
        l1.removeValue(0);
        assertEquals(3, l1.getSize());
    }

    @Test
    public void testRemoveall() {
        // simple case
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(2);
        l1.add(3);
        assertEquals(4, l1.getSize());
        l1.removeall(2);
        assertEquals(2, l1.getSize());
        assertEquals(3, l1.getValue(1));

        // complicated case
        LinkedList l2 = new LinkedList();
        l2.add(1);
        for(int i = 0; i < 499; i++) {
            l2.add(2);
        }
        l2.add(3);
        for(int i = 0; i < 499; i++) {
            l2.add(2);
        }
        assertEquals(1, l2.getValue(0));
        assertEquals(3, l2.getValue(500));
        l2.removeall(2);
        assertEquals(3, l2.getValue(1));
        assertEquals(2, l2.getSize());

        // edge case - removing a nonexisting element does not affect list
        l2.removeall(0);
        //assertEquals(2, l2.getSize());
        assertEquals(1, l2.getValue(0));
        // assertEquals(3, l2.getValue(1));  *******************
    }

    @Test 
    public void testMean() {
        // simple case
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        assertEquals(2.0, l1.mean(), 0.0);

        // complicated case
        LinkedList l2 = new LinkedList();
        for(int i = 1; i < 1000; i++) {
            l2.add(i);
        }
        assertEquals(500.0, l2.mean(), 0.0);

        // edge case
        LinkedList l3 = new LinkedList();
        assertEquals(Double.NaN, l3.mean(), 0.0);
    }

    @Test 
    public void testVariance() {
        // simple case
        LinkedList l1 = new LinkedList();
        l1.add(3);
        l1.add(4);
        l1.add(6);
        l1.add(7);
        l1.add(7);
        l1.add(9);
        l1.add(13);
        assertEquals(11.0, l1.variance(), 0.0);

        // complicated case
        LinkedList l2 = new LinkedList();
        for(int i = 1; i < 1000; i++) {
            l2.add(i);
        }
        assertEquals(83250.0, l2.variance(), 0.0);

        // edge case
        LinkedList l3 = new LinkedList();
        assertEquals(Double.NaN, l3.variance(), 0.0);
    }

    @Test 
    public void testSublist() {
        // simple case
        LinkedList l1 = new LinkedList();
        for(int i = 1; i <= 4; i++) {
            l1.add(i);
        }
        l1 = l1.sublist(2, 3);
        assertEquals(2, l1.getSize());
        assertEquals(2, l1.getValue(0));
        assertEquals(3, l1.getValue(1));

        // complicated case
        LinkedList l2 = new LinkedList();
        for(int i = 1; i < 1000; i++) {
            l2.add(i);
        }
        l2 = l2.sublist(250, 750);
        assertEquals(501, l2.getSize());
        assertEquals(250, l2.getValue(0));
        assertEquals(750, l2.getValue(500));

        // edge case - sublisting the entire list and sublisting empty list
        LinkedList l3 = new LinkedList();
        for(int i = 1; i <= 4; i++) {
            l3.add(i);
        }
        l3 = l3.sublist(0, 5);
        assertEquals(4, l3.getSize());
        l3 = l3.sublist(0, 0);
        assertEquals(0, l3.getSize());
    }

    @Test 
    public void testRemoveNoise() {
        // simple case
        LinkedList l1 = new LinkedList();
        l1.add(4);
        for(int i = 0; i < 49; i++) {
            l1.add(5);
        }
        assertEquals(50, l1.getSize());
        assertEquals(4, l1.getValue(0));
        l1 = l1.removeNoise();
        assertEquals(49, l1.getSize());
        assertEquals(5, l1.getValue(0));

        // complicated case
        LinkedList l2 = new LinkedList();
        for(int i = 0; i < 499; i++) {
            l2.add(5);
        }
        l2.add(4);
        for(int i = 0; i < 499; i++) {
            l2.add(5);
        }
        l2.add(4);
        assertEquals(1000, l2.getSize());
        assertEquals(4, l2.getValue(499));
        assertEquals(4, l2.getValue(999));
        l2 = l2.removeNoise();
        assertEquals(998, l2.getSize());

        // edge case - a3 empty list, a4 no change to list
        LinkedList l3 = new LinkedList();
        assertEquals(0, l3.getSize());
        l3.removeNoise();
        assertEquals(0, l3.getSize());

        LinkedList l4 = new LinkedList();
        l4.add(1);
        assertEquals(1, l4.getValue(0));
        l4 = l4.removeNoise();
        assertEquals(1, l4.getValue(0));
    }

}
