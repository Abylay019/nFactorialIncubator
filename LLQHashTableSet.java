package week11;

/**
 *
 * @author user
 * @param <T>
 */
public class LLQHashTableSet<T> implements Set<T>{
    
    private LinkedListQueue<T>[] buckets;
    private int size;
    private int length;

    public LLQHashTableSet(int length){
        buckets = (LinkedListQueue<T>[]) new Set[length];
//        for (int i = 0; i < length; i++)
//            buckets[i] = null;
        size = 0;
        
    }
    
    @Override
    public void add(T value) {
        if (!contains(value)){
            buckets[value.hashCode() % 10].enqueue(value);               
        }
    }

    @Override
    public boolean contains(T value) {
        for(int i = 0; i < buckets[value.hashCode() % 10].getSize(); i++)
            try {
                T x = buckets[value.hashCode() % 10].dequeue();
                buckets[value.hashCode() % 10].enqueue(x);
                
                if (x.equals(value)){
                    return true;
                }
            } catch (Exception ex) {
                // Nothing
            }
        return false;
    }

    @Override
    public boolean remove(T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeAny() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        for(int i = 0; i <= length; i++)
            return buckets[i].toString();
        return "";
    }   
    
}
