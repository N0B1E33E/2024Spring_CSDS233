import java.util.Arrays;
public class ArrayList {
    private static final int DEFAULT_CAPACITY = 1;
    private int[] list;
    private int size;

    public ArrayList(){
        this.list = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(int n){
        if(size == list.length){
            this.increaseLength();
        }
        list[size++] = n;
    }
    
    public void add(int n, int index){
        if(index >= list.length){
            throw new IllegalArgumentException();
        }
        else{
            list[index] = n;
            size++;
        }
    }

    private void increaseLength(){
        list = Arrays.copyOf(list, list.length * 2);
    }

    public int indexof(int n){
        for(int i = 0; i < list.length; i++){
            if(list[i] == n)
                return i;
        }
        return -1;
    }

    public int remove(int index){
        if(index >= list.length){
            throw new IllegalArgumentException();
        }
        int temp = list[index];
        list[index] = 0;
        size--;
        return temp;
    }

    public void removeall(int n){
        for(int i = 0; i < list.length; i++){
            if(list[i] == n)
                list[i] = 0;
                size--;
        }
    }

    public double mean(){
        double sum = 0.0;
        for(int i = 0; i < list.length; i++){
            if(list[i] != 0){
                sum += list[i];
            }
        }
        return sum/size;
    }

    public double variance(){
        double mean = this.mean();
        double sum = 0.0;
        for(int i = 0; i < list.length; i++){
            if(list[i] != 0){
                sum += Math.pow(list[i] - mean, 2.0);
            }
        }
        return sum/(size - 1);
    }

    /*public LinkedList sublist(int lower, int upper){

    } */


/*public LinkedList removeNoise(){

} */
    
}
