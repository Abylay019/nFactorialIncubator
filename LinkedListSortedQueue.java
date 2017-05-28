package week11;

public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T>{
 
    private Node<T> front;
    private int size;
   
    public LinkedListSortedQueue(){
        front = null;
        size = 0;
    }
   
    @Override
    public void insert(T value) {
        Node<T> newNode = new Node (value);
       
        if (size == 0){
            front = newNode;
        }
        else if(size == 1){
                front.setLink(newNode);
            }
        else{
            if (value.compareTo(front.getValue()) <= 0){
                newNode.setLink(front);
                front = newNode;  
            }
           
            else{
                Node<T> temp1 = front;
                Node<T> temp2 = front.getLink();
                for (int i = 0; i < size; i++){
                    if(temp2 == null){
                        temp1.setLink(newNode);
                        break;
                    }
                    else if (value.compareTo(temp2.getValue()) <= 0){
                        temp1.setLink(newNode);
                        newNode.setLink(temp2);
                        break;
                    }
                   
                    temp1 = temp2;
                    temp2 = temp2.getLink();
                }
               
               
            }
        }
        size++;  
    }
 
    @Override
    public T dequeue() throws Exception{
        if (size == 0){
            throw new Exception("There is no any value!");
        }
        T temp = front.getValue();
        front = front.getLink();
        size--;
        return temp;
    }
 
    @Override
    public int getSize() {
        return size;
    }
 
    @Override
    public void clear() {
        size = 0;
        front = null;
    }
    @Override
    public String toString(){
        String res = "";
        Node<T> current = front;
        while (current != null){
            res = res + " " + current.getValue();
            current = current.getLink();
        }
        return res;
    }
   
}
