package week11;


/**
 *
 * @author Yeltayev_Nurdaulet
 */
public class ArrayIntQueue implements IntQueue {
    
    private int[] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayIntQueue(){
        values = new int[5];
        size = 0;
        front = 0;
        back = 0;
    }
    @Override
    public void enqueue(int value) {
        if (size == values.length) {
            int[] newVals = new int[values.length * 2];
            for (int j = 0, k = front;
                    j < size;
                    j++, k = (k + 1) % values.length) {

                newVals[j] = values[k];
            }
            values = newVals;
            front = 0;
            back = size;
        }
        values[back] = value;
        back = (back + 1) % values.length;
        size++;
    }

    @Override
    public int dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty");
        }
        int result = values[front];
        front = (front + 1) % values.length;
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        front = 0;
        back = 0;
    }
    
    @Override
    public String toString(){
         String result = "[";
        for (int j = 0, k = front;
                j < size;
                j++, k = (k + 1) % values.length) {

            result += values[k] + " ";
        }

        return result + "]";
    }
}
