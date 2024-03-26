public class LinkedList {

    private Node first = null;
    private LinkedList list = null;
    private int size = 0;
    /*
     * private helper method that get access to the head of the linked list
     */
    private Node getFirst(){
        return this.first;
    }

    /*
     * private helper method that set the head of the linked list
     */
    private void setFirst(Node n){
        this.first = n;
    }

    public void add(int n){
        Node ptr = list.getFirst();
        if(list == null){
            Node head = new Node(n,null);
            list.setFirst(head);
        }
        else{
            for(int i = 0; i < this.size; i ++){
                ptr = ptr.getNext();
            }
            ptr.setNext(new Node(n,null));
        }
        size ++;
    }

    public void add(int n, int index){
        Node ptr = list.getFirst();
        if(index < 0)
            throw new IllegalArgumentException();
        else if(index == 0)
            list.setFirst(new Node(n,list.getFirst()));
        else{
            if(index <= this.size){
                for(int i = 0; i < index; i ++){
                    ptr = ptr.getNext();
                }
                ptr.setNext(new Node(n,ptr.getNext()));
            }
            else{
                for(int i = 0; i < this.size; i++){
                    ptr = ptr.getNext();
                }
                ptr.setNext(new Node(n,ptr.getNext()));
            }
            size++;
        }
    }

    public int indexof(int n){
        Node ptr = list.getFirst();
        for(int i = 0; i < list.size; i++){
            if(ptr.getValue() == n)
                return i;
        }
        return -1;
    }

    public int remove(int index){
        Node ptr = list.getFirst().getNext();
        int temp;
        if(index < 0){
            throw new IllegalArgumentException();
        }
        else if(index == 0){
            temp = list.getFirst().getValue();
            list.setFirst(list.getFirst().getNext());
        }
        else if(index <= this.size){
            for(int i = 1; i < index - 1; i++){
                ptr = ptr.getNext();
            }
            temp = ptr.getNext().getValue();
            ptr.setNext(ptr.getNext().getNext());
        }
        else{
            for(int i = 1; i < this.size - 1; i++){
                ptr = ptr.getNext();
            }
            temp = ptr.getNext().getValue();
            ptr.setNext(null);
        } 
        return temp;
    }


    public void remove(int n){
        Node ptr = list.getFirst().getNext();
        if(list.getFirst().getValue() == n){
            list.setFirst(list.getFirst().getNext());
        }
        else{
            for(int i = 1; i < this.size - 1; i++){
                ptr = ptr.getNext();
                if(ptr.getNext().getValue() == n){
                    ptr.setNext(ptr.getNext().getNext());
                    return;
                }
            }
        }
    }

    public void removeall(int n){
        Node ptr = list.getFirst().getNext();
        if(list.getFirst().getValue() == n){
            list.setFirst(list.getFirst().getNext());
        }
        else{
            for(int i = 1; i < this.size - 1; i++){
                ptr = ptr.getNext();
                if(ptr.getNext().getValue() == n){
                    ptr.setNext(ptr.getNext().getNext());
                }
            }
        }
    }


    public double mean(){
        double sum =0.;
        Node ptr = list.getFirst();
        for(int i = 0; i < list.size; i++){
            sum += ptr.getValue();
            ptr = ptr.getNext();
        }
        return sum / list.size;
    }

    public double Variance(){
        double sum = 0.;
        Node ptr = list.getFirst();
        for(int i = 0; i < list.size; i++){
            sum += Math.pow(ptr.getValue() - list.mean(),2);
            ptr = ptr.getNext();
        }
        return sum/ (list.size - 1);
    }

    public LinkedList sublist(int lower, int upper){

    }



}
