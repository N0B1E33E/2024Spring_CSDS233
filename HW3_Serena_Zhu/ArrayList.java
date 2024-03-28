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
        if(index > size) {
            list[size] = n;
            size++;
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
            return save;
        }
        else {
            int save = list[index];
            for(int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            return save;
        }
    }

    public void removeValue(int n) {
        for(int i = indexof(n); i < size - 1; i++) {
            list[i] = list[i + 1];
        }
    }

    public void removeall(int n) {
        for(int number : list) {
            if(number == n) {
                removeValue(n);
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
        double summation = 0;
        for(int number : list) {
            summation = (number - this.mean()) * (number - this.mean());
        }
        return summation /= (size - 1);
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
        for(int number : list) {
            if(number > (this.mean() + (3 * stanDev)) || number < (this.mean() - (3 * stanDev))) {
                this.remove(number);
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

}
