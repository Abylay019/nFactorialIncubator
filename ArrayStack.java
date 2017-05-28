package week11;


/**
 *
 * author Yeltayev_Nurdaulet
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T>{
    
    private T[] values;
    private int size;
    
    public ArrayStack(){
        values = (T[])new Object[10];
        size = 0;
    }
    
    @Override
    public void push(T value) {
        values[size] = value;
        size++;
    }

    @Override
    public T pop() throws Exception {
        T result = values[size - 1];
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
    
    /**
     *
     * @return peak
     */
    @Override
    public T peak(){
        T result = values[size - 1];
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
