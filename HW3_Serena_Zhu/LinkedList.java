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
            for(int i = 0; i < index - 1; i++) {
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
        if(index == 0) {
            save = firstNode.getData();
            firstNode = iterate.getNext();
            size--;
            return save;
        }
        else if(index >= size - 1) {
            while(iterate.getNext().getNext() != null) {
                iterate = iterate.getNext();
            }
            save = iterate.getNext().getData();
            iterate.setNext(null);
            size--;
            return save;
        }
        else {
            for(int i = 0; i < index - 1; i++) {
                iterate = iterate.getNext();
            }
            save = iterate.getNext().getData();
            iterate.setNext(iterate.getNext().getNext());
            size--;
            return save;
        }
    }

    public void removeValue(int n) {
        if(this.indexof(n) != -1) {
            remove(indexof(n));
        }
    }

    public void removeall(int n) {
        while(indexof(n) != -1) {
            remove(indexof(n));
        }
    }

    public double mean() {
        double sum = 0;
        Node iterate = firstNode;
        while(iterate != null) {
            sum += iterate.getData();
            iterate = iterate.getNext();
        }
        return sum /= size;
    }

    public double variance() {
        if(size == 0) {
            return Double.NaN;
        }
        else {
            double summation = 0;
            Node iterate = firstNode;
            while(iterate != null) {
                summation += ((iterate.getData() - this.mean()) * (iterate.getData() - this.mean()));
                iterate = iterate.getNext();
            }
            return summation /= (size - 1);
        }
    }

    public LinkedList sublist(int lower, int upper) {
        LinkedList temp = new LinkedList();
        Node iterate = firstNode;
        while(iterate != null) {
            int current = iterate.getData();
            if(current >= lower && current <= upper) {
                temp.add(current);
            }
            iterate = iterate.getNext();
        }
        return temp;
    }

    public LinkedList removeNoise() {
        LinkedList temp = new LinkedList();
        double stanDev = Math.sqrt(this.variance());
        Node iterate = firstNode;
        if(size <= 1) {
            return this;
        }
        else {
            while(iterate != null) {
                int current = iterate.getData();
                if(current >= (this.mean() - (3 * stanDev)) && current <= (this.mean() + (3 * stanDev))) {
                    temp.add(current);
                }
                iterate = iterate.getNext();
            }
            return temp;
        }
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

}
