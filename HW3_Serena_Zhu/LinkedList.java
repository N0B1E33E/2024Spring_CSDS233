import java.lang.Math;

public class LinkedList {

    private Node firstNode;
    private int size;

    public LinkedList() {
        firstNode = null;
        size = 0;
    }

    public void add(int n) {
        if(size != 0) {
            Node iterate = firstNode;
            while(iterate.getNext() != null) {
                iterate = iterate.getNext();
            }
            iterate.setNext(new Node(n));
            size++;
        }
        else {
            firstNode = new Node(n, null);
            size++;
        }
    }

    public void add(int n, int index) {
        if(index < 0) {
            throw new IllegalArgumentException();
        }
        if(index >= size) {
            add(n);
        }
        else {
            Node iterate = firstNode;
            for(int i = 0; i < index; i++) {
                iterate = iterate.getNext();
            }
            Node save = iterate.getNext();
            iterate.setNext(new Node(n, save));
        }
    }

    public int indexof(int n) {
        int index = -1;
        int count = 0;
        Node iterate = firstNode;
        while(iterate.getNext() != null && index == -1) {
            if(iterate.getData() == n) {
                index = count;
            }
            iterate = iterate.getNext();
            count++;
        }
        return index;
    }

    public int remove(int index) {
        if(index < 0) {
            throw new IllegalArgumentException();
        }
        Node iterate = firstNode;
        int save;
        if(index > size - 1) {
            while(iterate.getNext().getNext() != null) {
                iterate = iterate.getNext();
            }
            save = iterate.getNext().getData();
            iterate.setNext(null);
            size--;
            return save;
        }
        else {
            for(int i = 0; i < index; i++) {
                iterate = iterate.getNext();
            }
            save = iterate.getNext().getData();
            iterate.setNext(iterate.getNext().getNext());
            size--;
            return save;
        }
    }

    public void removeValue(int n) {
        int index = indexof(n);
        remove(index);
    }

    public void removeall(int n) {
        int index = indexof(n);
        while(indexof(n) != -1) {
            remove(index);
            index = indexof(n);
        }
    }

    public double mean() {
        double sum = 0;
        Node iterate = firstNode;
        while(iterate.getNext() != null) {
            sum += iterate.getData();
            iterate = iterate.getNext();
        }
        return sum /= size;
    }

    public double variance() {
        double summation = 0;
        Node iterate = firstNode;
        while(iterate.getNext() != null) {
            summation += ((iterate.getData() - this.mean()) * (iterate.getData() - this.mean()));
            iterate = iterate.getNext();
        }
        return summation /= (size - 1);
    }

    public LinkedList sublist(int lower, int upper) {
        Node iterate = firstNode;
        for(int i = 0; i < lower; i++) {
            iterate = iterate.getNext();
        }
        firstNode = iterate.getNext();
        for(int i = lower; i <= upper; i++) {
            iterate = iterate.getNext();
        }
        iterate.setNext(null);
        return this;
    }

    public LinkedList removeNoise() {
        double stanDev = Math.sqrt(this.variance());
        Node iterate = firstNode;
        while(iterate.getNext() != null) {
            if(iterate.getData() > (this.mean() + (3 * stanDev)) || iterate.getData() < (this.mean() - (3 * stanDev))) {
                remove(iterate.getData());
            }
        }
        return this;
    }
    
    public Node getFirstNode() {
        return firstNode;
    }

    public int getValue(int index) {
        Node iterate = firstNode;
        for(int i = 0; i < index; i++) {
            iterate = iterate.getNext();
        }
        return iterate.getData();
    }

    public int getSize() {
        return size;
    }

    private class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this(data, null);
        }

        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        private int getData() {
            return this.data;
        }

        private Node getNext() {
            return this.next;
        }

        private void setNext(Node next) {
            this.next = next;
        }
    }

}
