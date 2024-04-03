public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
    }

    public void add(int n) {
        if(size != 0) {
            Node iterate = head;
            while(iterate.getNext() != null) {
                iterate = iterate.getNext();
            }
            iterate.setNext(new Node(n, null));
            size++;
        }
        else {
            head = new Node(n, null);
            size++;
        }
    }

    public void add(int n, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index out of bound.");
        }
        Node newNode = new Node(n, null);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.getNext();
            }
            if (current == null) {
                add(n); // If index is greater than the length, add to the end
            } else {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
            }
        }
    }

    public int indexOf(int n) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.getValue() == n) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1; // Element not found
    }

    public int remove(int index) {
        if (index < 0 || head == null) {
            throw new IllegalArgumentException("Index out of bound.");
        }
        if (index == 0) {
            int data = head.getValue();
            head = head.getNext();
            return data;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current.getNext() != null; i++) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            throw new IllegalArgumentException("Index out of bound.");
        }
        int data = current.getNext().getValue();
        current.setNext(current.getNext().getNext());
        return data;
    }

    public void removeValue(int n) {
        if (head == null) return;
        if (head.getValue() == n) {
            head = head.getNext();
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue() == n) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }
    public void removeAll(int n) {
        while (head != null && head.getValue() == n) {
            head = head.getNext(); // Remove head nodes that match the value
        }
        Node current = head;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getValue() == n) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    public double mean() {
        if (head == null) return 0;
        int sum = 0, count = 0;
        Node current = head;
        while (current != null) {
            sum += current.getValue();
            current = current.getNext();
            count++;
        }
        return (double)sum / count;
    }

    public double variance() {
        double mean = mean();
        if (head == null) return 0;
        double varianceSum = 0;
        int count = 0;
        Node current = head;
        while (current != null) {
            varianceSum += Math.pow(current.getValue() - mean, 2);
            current = current.getNext();
            count++;
        }
        return varianceSum / (count - 1);
    }

    public LinkedList sublist(int lower, int upper) {
        LinkedList sublist = new LinkedList();
        Node current = head;
        while (current != null) {
            if (current.getValue() >= lower && current.getValue() <= upper) {
                sublist.add(current.getValue());
            }
            current = current.getNext();
        }
        return sublist;
    }

    public LinkedList removeNoise() {
        double mean = mean();
        double stdDev = Math.sqrt(variance());
        LinkedList filteredList = new LinkedList();
        Node current = head;
        while (current != null) {
            if (Math.abs(current.getValue() - mean) <= 3 * stdDev) {
                filteredList.add(current.getValue());
            }
            current = current.getNext();
        }
        return filteredList;
    }
}
