/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11;


public class LinkedListStack<T> implements Stack<T> {
    
    private Node<T> top;
    private int size;
    
    public LinkedListStack (){
        top = null;
        size = 0;
    }
    
    public boolean isEmpty() { 
        return top == null; 
    } 

    @Override
    public void push(T value) {
        
        Node node =  new Node(value);
        if (top == null)
            top = node;
        else
        {
            node.setLink(top);
            top = node;
        }
        size++ ;
        
    }
    

    @Override
    public T pop() throws Exception {
        
        if(isEmpty()){
            throw new Exception("It is Exmpty");
        }
        Node newnode = top;
        top = newnode.getLink();
        size --;
        return (T) newnode.getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }
    
    public String toString1(){
        
        String res = "";
        Node node1 = top;

        while (node1 != null)
        {
            res += node1.getValue()+ " ";
            node1 = node1.getLink();
        }
        
        return res;
    
    }

    @Override
    public T peak() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
