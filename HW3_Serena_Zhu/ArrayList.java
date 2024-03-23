public class ArrayList {
    
    int[] a;
    int size;
    MAX_CAPACITY = 10000;

    public ArrayList() {
        a = new int[MAX_CAPACITY];
        size = 0;
    }

    public void add(int n) {
        a[size] = n;
        size++;
    }

    public void add(int n, int index) {
        if(index < 0) {
            throw new IllegalArgumentException();
        }
        if(index > size) {
            a[size] = n;
            size++;
        }
        else {
            for()
        }
    }

    public int indexof(int n) {

    }

    public int remove(int index) {

    }

    public void removeValue(int n) {

    }

    public void removeall(int n) {

    }

    public double mean() {

    }

    public double variance() {

    }

    public ArrayList sublist(int lower, int upper) {

    }

    public ArrayList removeNoise() {

    }

}
