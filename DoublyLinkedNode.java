package week11;

/**
 *
 * @author Nurdaulet Yeltayev   
 * @param <T>   
 */
public class DoublyLinkedNode<T> {
  
    private T value;
    
    private DoublyLinkedNode<T> previous;
    private DoublyLinkedNode<T> next;
    
    public DoublyLinkedNode(T val){
        value = val;
        previous = null;
        next = null;        
    }   

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the previous
     */
    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    /**
     * @return the next
     */
    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }
    
    public String toString(){
        return value.toString();
    }
    
    
}