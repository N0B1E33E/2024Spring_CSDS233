public class ArrayList {
    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    //constructor that initiates the arraylist at default capacity
    public ArrayList(){
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void ensureCapacity(){
        if (size == elements.length){
            int[] newElements = new int[elements.length * 2];
            for (int i = 0; i < elements.length; i++){
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public void add(int n){
        ensureCapacity();
        elements[size] = n;
        size++;
    }

    public void add(int n, int index){
        if(index < 0){
            throw new IllegalArgumentException("Index out of bound.");
        }
        ensureCapacity();
        // if index is larger than size, add to the end
        if (index >= size){
            add(n);
        } else {
            //shift array after index to the right to make space
            for (int i = size; i > index; i--){
                elements[i] = elements[i-1];
            }
            elements[index] = n;
            size ++;
        }
    }

    public int indexOf(int n) {
        //traverse through the array and find if there is designated number
        for (int i = 0; i < size; i++) {
            if (elements[i] == n) return i;
            
        }
        //return -1 if not found
        return -1;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bound.");
        }
        int removedElement = elements[index];
        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removedElement;
    }

    public void removeValue(int n) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == n) {
                remove(i);
                return;
            }
        }
    }

    public void removeAll(int n) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == n) {
                remove(i);
                i--; // Adjust index after removal
            }
        }
    }

    public double mean() {
        if (size == 0) return 0;
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += elements[i];
        }
        return sum / size;
    }

    public double variance() {
        double mean = mean();
        double temp = 0;
        for (int i = 0; i < size; i++) {
            temp += (elements[i] - mean) * (elements[i] - mean);
        }
        return temp / (size - 1);
    }

    public ArrayList sublist(int lower, int upper) {
        ArrayList sublist = new ArrayList();
        for (int i = 0; i < size; i++) {
            if (elements[i] >= lower && elements[i] <= upper) {
                sublist.add(elements[i]);
            }
        }
        return sublist;
    }

    public ArrayList removeNoise() {
        double mean = mean();
        double stdDev = Math.sqrt(variance());
        ArrayList cleanedList = new ArrayList();
        for (int i = 0; i < size; i++) {
            if (Math.abs(elements[i] - mean) <= 3 * stdDev) {
                cleanedList.add(elements[i]);
            }
        }
        return cleanedList;
    }
}
