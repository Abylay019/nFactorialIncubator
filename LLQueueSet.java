package week11;

/**
 *
 * @author user
 * @param <T>
 */
public class LLQueueSet<T> implements Set<T>{

    private LinkedListQueue<T> queue;
    
    public LLQueueSet(){
        queue = new LinkedListQueue<>();
    }
    

    @Override
    public void add(T value) {
        
        if (!contains(value)){
            queue.enqueue(value);    
        }
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < queue.getSize(); i++)
            try {
                T x = queue.dequeue();
                queue.enqueue(x);
                
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
        if (contains(value)){
            for (int j = 0; j < queue.getSize() - 1; j++){
                try {
                    T x = queue.dequeue();
                    queue.enqueue(x);
                } catch (Exception ex) {
                    // Nothing
                }
            }
            try {
                queue.dequeue();
                return true;
            } catch (Exception ex) {
                // Nothing
            }
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if (queue.getSize() != 0){
            return queue.dequeue();
        }
        else{
            throw new Exception("FAIL!!! Nothing in the set!!!");
        }
            
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue.clear();
    }
    
    @Override
    public String toString(){
        return queue.toString();
    }
    


}
