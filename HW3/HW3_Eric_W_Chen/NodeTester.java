import static org.junit.Assert.*;
import org.junit.Test;

public class NodeTester {

    @Test
    public void testNodeCreation() {
        Node node = new Node(5, null);
        assertEquals("The value should be 5", 5, node.getValue());
        assertNull("Next should be null", node.getNext());
    }

    @Test
    public void testSetValue() {
        Node node = new Node(5, null);
        node.setValue(10);
        assertEquals("The value should be updated to 10", 10, node.getValue());
    }

    @Test
    public void testSetNext() {
        Node firstNode = new Node(5, null);
        Node secondNode = new Node(10, null);
        firstNode.setNext(secondNode);
        assertEquals("Next node should be the second node", secondNode, firstNode.getNext());
    }

    @Test
    public void testNodeChain() {
        Node thirdNode = new Node(15, null);
        Node secondNode = new Node(10, thirdNode);
        Node firstNode = new Node(5, secondNode);
        
        assertEquals("First node should point to the second node", secondNode, firstNode.getNext());
        assertEquals("Second node should point to the third node", thirdNode, secondNode.getNext());
        assertNull("Third node's next should be null", thirdNode.getNext());
    }

    @Test
    public void testLargeValue() {
        Node node = new Node(Integer.MAX_VALUE, null);
        assertEquals("Node value should handle Integer.MAX_VALUE", Integer.MAX_VALUE, node.getValue());
    }

    @Test
    public void testNegativeValue() {
        Node node = new Node(-1, null);
        assertEquals("Node value should handle negative values", -1, node.getValue());
    }

    @Test
    public void testNullNextNode() {
        Node node = new Node(5, null);
        node.setNext(null);
        assertNull("Next node should be able to be set to null", node.getNext());
    }
}
