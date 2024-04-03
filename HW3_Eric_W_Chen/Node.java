public class Node {
    private Node next;
    private int value;

    public Node(int value, Node next){
        this.next = next;
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public void setValue(int value){
        this.value = value;
    }
}
