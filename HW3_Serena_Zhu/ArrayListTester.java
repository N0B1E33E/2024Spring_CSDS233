import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Double;

public class ArrayListTester {
    
    @Test 
    public void testAdd() {
        ArrayList a = new ArrayList();

        // simple case - 
        a.add(1);
        assertEquals(1, a.getValue(0));
        assertEquals(1, a.getSize());

        // complicated case
        a.add(2);
        a.add(3);
        assertEquals(2, a.getValue(1));
        assertEquals(3, a.getValue(2));
        assertEquals(3, a.getSize());

        // edge case
        a.add(0);
        assertEquals(0, a.getValue(3));
        assertEquals(4, a.getSize());
    }

    @Test 
    public void testAddAtIndex() {
        // simple case - index > size, adding to end of list
        ArrayList a1 = new ArrayList();
        a1.add(1);
        a1.add(6, 4);
        assertEquals(6, a1.getValue(1));

        // complicated case - index < size, adding to middle of list
        ArrayList a2 = new ArrayList();
        a2.add(1);
        a2.add(2);
        a2.add(3);
        a2.add(6, 1);
        assertEquals(1, a2.getValue(0));
        assertEquals(6, a2.getValue(1));
        assertEquals(2, a2.getValue(2));
        assertEquals(3, a2.getValue(3));

        // edge case - the following line throws an IllegalArgumentException because index is < 0
        //a2.add(0, -1);
    }

    @Test
    public void testIndexof() {
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        
        // simple case - getting index of elements with one occurrence
        assertEquals(0, a.indexof(1));
        assertEquals(1, a.indexof(2));

        // complicated case - getting index of elements with multiple occurrences
        assertEquals(2, a.indexof(3));

        // edge case - getting index of element that does not exist
        assertEquals(-1, a.indexof(4));
    }

    @Test 
    public void testRemove() {
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);

        // simple case - index < size, removing element at input
        assertEquals(1, a.getValue(0));
        assertEquals(1, a.remove(0));
        assertEquals(2, a.getValue(0));

        // complicated case - index > size, removing element at end of list
        assertEquals(3, a.getValue(1));
        assertEquals(3, a.remove(6));
        assertEquals(0, a.getValue(1));

        // edge case - the following line throws an IllegalArgumentException because index is < 0
        //a.remove(-1);
    }

    @Test 
    public void testRemoveValue() {
        // simple case
        ArrayList a1 = new ArrayList();
        a1.add(1);
        a1.add(2);
        a1.add(2);
        a1.add(3);
        assertEquals(2, a1.getValue(1));
        a1.removeValue(2);
        assertEquals(2, a1.getValue(1));
        assertEquals(3, a1.getValue(2));

        // complicated case
        ArrayList a2 = new ArrayList();
        a2.add(1);
        a2.add(2);
        for(int i = 0; i < 998; i++) {
            a2.add(3);
        }
        assertEquals(2, a2.getValue(1));
        a2.removeValue(2);
        assertEquals(3, a2.getValue(1));
        assertEquals(999, a2.getSize());

        // edge case - removing a nonexisting element does not affect list
        a1.removeValue(0);
        assertEquals(3, a1.getSize());
    }

    @Test
    public void testRemoveall() {
        // simple case
        ArrayList a1 = new ArrayList();
        a1.add(1);
        a1.add(2);
        a1.add(2);
        a1.add(3);
        assertEquals(4, a1.getSize());
        a1.removeall(2);
        assertEquals(2, a1.getSize());
        assertEquals(3, a1.getValue(1));

        // complicated case
        ArrayList a2 = new ArrayList();
        a2.add(1);
        for(int i = 0; i < 499; i++) {
            a2.add(2);
        }
        a2.add(3);
        for(int i = 0; i < 499; i++) {
            a2.add(2);
        }
        assertEquals(1, a2.getValue(0));
        assertEquals(3, a2.getValue(500));
        a2.removeall(2);
        assertEquals(3, a2.getValue(1));

        assertEquals(2, a2.getSize());

        // edge case - removing a nonexisting element does not affect list
        a2.removeall(0);
        //assertEquals(2, a2.getSize());
        assertEquals(1, a2.getValue(0));
        assertEquals(3, a2.getValue(1));
    }

    @Test 
    public void testMean() {
        // simple case
        ArrayList a1 = new ArrayList();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        assertEquals(2.0, a1.mean(), 0.0);

        // complicated case
        ArrayList a2 = new ArrayList();
        for(int i = 1; i < 1000; i++) {
            a2.add(i);
        }
        assertEquals(500.0, a2.mean(), 0.0);

        // edge case
        ArrayList a3 = new ArrayList();
        assertEquals(Double.NaN, a3.mean(), 0.0);
    }

    @Test 
    public void testVariance() {
        // simple case
        ArrayList a1 = new ArrayList();
        a1.add(3);
        a1.add(4);
        a1.add(6);
        a1.add(7);
        a1.add(7);
        a1.add(9);
        a1.add(13);
        assertEquals(11.0, a1.variance(), 0.0);

        // complicated case
        ArrayList a2 = new ArrayList();
        for(int i = 1; i < 1000; i++) {
            a2.add(i);
        }
        assertEquals(83250.0, a2.variance(), 0.0);

        // edge case
        ArrayList a3 = new ArrayList();
        assertEquals(Double.NaN, a3.variance(), 0.0);
    }

    @Test 
    public void testSublist() {
        // simple case
        ArrayList a1 = new ArrayList();
        for(int i = 1; i <= 4; i++) {
            a1.add(i);
        }
        a1 = a1.sublist(1, 2);
        assertEquals(2, a1.getValue(0));
        assertEquals(3, a1.getValue(1));

        // complicated case
        ArrayList a2 = new ArrayList();
        for(int i = 1; i < 1000; i++) {
            a2.add(i);
        }
        a2 = a2.sublist(249, 749);
        assertEquals(250, a2.getValue(0));
        assertEquals(750, a2.getValue(500));

        // edge case - sublisting the entire list and sublisting empty list
        ArrayList a3 = new ArrayList();
        for(int i = 1; i <= 4; i++) {
            a3.add(i);
        }
        a3 = a3.sublist(0, 3);
        assertEquals(4, a3.getSize());
        a3 = a3.sublist(0, 0);
        assertEquals(1, a3.getValue(0));
    }

    @Test 
    public void testRemoveNoise() {
        // simple case
        ArrayList a1 = new ArrayList();
        a1.add(4);
        for(int i = 0; i < 49; i++) {
            a1.add(5);
        }
        assertEquals(50, a1.getSize());
        assertEquals(4, a1.getValue(0));
        a1 = a1.removeNoise();
        assertEquals(49, a1.getSize());
        assertEquals(5, a1.getValue(0));

        // complicated case
        ArrayList a2 = new ArrayList();
        for(int i = 0; i < 499; i++) {
            a2.add(5);
        }
        a2.add(4);
        for(int i = 0; i < 499; i++) {
            a2.add(5);
        }
        a2.add(4);
        assertEquals(1000, a2.getSize());
        assertEquals(4, a2.getValue(499));
        assertEquals(4, a2.getValue(999));
        a2 = a2.removeNoise();
        assertEquals(998, a2.getSize());

        // edge case - a3 empty list, a4 no change to list
        ArrayList a3 = new ArrayList();
        assertEquals(0, a3.getSize());
        a3.removeNoise();
        assertEquals(0, a3.getSize());

        ArrayList a4 = new ArrayList();
        a4.add(1);
        assertEquals(1, a4.getValue(0));
        a4 = a4.removeNoise();
        assertEquals(1, a4.getValue(0));
    }

}
