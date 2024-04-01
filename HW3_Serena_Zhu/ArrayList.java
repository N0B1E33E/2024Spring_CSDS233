import java.lang.Math;

public class ArrayList {
    
    private int[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 1;

    public ArrayList() {
        list = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(int n) {
        ensureCapacity();
        list[size] = n;
        size++;
    }

    public void add(int n, int index) {
        if(index < 0) {
            throw new IllegalArgumentException();
        }
        ensureCapacity();
        if(index >= size) {
            add(n);
        }
        else {
            for(int i = size; i >= index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = n;
            size++;
        }
    }

    public int indexof(int n) {
        int index = -1;
        for(int i = 0; i < list.length; i++) {
            if(list[i] == n) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int remove(int index) {
        if(index < 0) {
            throw new IllegalArgumentException();
        }
        if(index > size - 1) {
            int save = list[size - 1];
            list[size - 1] = 0;
            size--;
            return save;
        }
        else {
            int save = list[index];
            for(int i = index; i < size; i++) {
                list[i] = list[i + 1];
            }
            size--;
            return save;
        }
    }

    public void removeValue(int n) {
        if(this.indexof(n) < size) {
            for(int i = indexof(n); i < size; i++) {
             list[i] = list[i + 1];
            }   
            size--;
        }
    }

    public void removeall(int n) {
        for(int i = 0; i < size; i++) {
            if(this.getValue(i) == n) {
                remove(i);
                i--;
            }
        }
    }

    public double mean() {
        double sum = 0;
        for(int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum /= size;
    }

    public double variance() {
        if(size == 0) {
            return Double.NaN;
        }
        else {
            double summation = 0;
            for(int i = 0; i < size; i++) {
               summation += (Math.pow((this.getValue(i)- this.mean()), 2.0));
            }
            return summation /= (size - 1);
        }
    }

    public ArrayList sublist(int lower, int upper) {
        int[] temp = new int[list.length];
        int count = 0;
        for(int i = lower; i <= upper; i++) {
            temp[count] = list[i];
            count++;
        }
        list = temp;
        return this;
    }

    public ArrayList removeNoise() {
        double stanDev = Math.sqrt(this.variance());
        double mean = this.mean();
        for(int i = 0; i < size; i++) {
            if(this.getValue(i) > (mean + (3 * stanDev)) || this.getValue(i) < (mean - (3 * stanDev))) {
                this.remove(i);
            }
        }
        return this;
    }

    private void ensureCapacity() {
        if((size + 1) == list.length) {
            int[] temp = new int[2 * list.length];
            for(int i = 0; i < size; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
    }

    public int getValue(int index) {
        return list[index];
    }

    public int[] getList() {
        return list;
    }

    public int getSize() {
        return size;
    }

}
