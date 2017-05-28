package week11;



public class ArrayIntStack implements IntStack{
    
    private int[] values;
    private int size;
    
    public ArrayIntStack(){
        values = new int[10];
        size = 0;
    }
    
    @Override
    public void push(int value) {
        values[size] = value;
        size++;
    }

    @Override
    public int pop() throws Exception {
        int result = values[size - 1];
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
    }
    
    public int peak(){
        int result = values[size - 1];
        return result;
    }
    
   
    
    @Override
    public String toString(){
        String A = "";
        
        for (int i = 0; i < size; i++){
            A = A + " " + values[i];
        }
        
        return A;
    }
    
}
