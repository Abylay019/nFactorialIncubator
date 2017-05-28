/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11;

/**
 *
 * partner Yeltayev_Nurdaulet
 */
public class LinkedListDeque<T> implements Deque<T> {
    
    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    
    private int size;
    
    public LinkedListDeque(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void pushToFront(T value) {
         DoublyLinkedNode node = new DoublyLinkedNode(value);

        if (size == 0) {
            back = node;
        } else {
            front.setPrevious(node);
            front.getPrevious().setNext(front);
        }

        front = node;
        size++;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode node = new DoublyLinkedNode(value);

        if (size == 0) {
            front = node;
        } else {
            back.setNext(node);
            back.getNext().setPrevious(back);
        }

        back = node;
        size++;
    }

    @Override
    public T popFromFront() throws Exception {
        if (front == null) {
            throw new Exception("Queue is empty!");
        }

        T value = front.getValue();
        if(size == 1){
            front = null;
            back = null;
        } else {
            front = front.getNext();
            front.setPrevious(null);
        }
        size--;
        
        return value;
    }

    @Override
    public T popFromBack() throws Exception {
        if (back == null) {
            throw new Exception("Queue is empty!");
        }

        T value = back.getValue();
        if(size == 1){
            front = null;
            back = null;
        } else {
            back = back.getPrevious();
            back.setNext(null);
        }
        size--;
        
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        front = null;
        back = null;
    }
    
    @Override
    public String toString(){
        String res = "";
        DoublyLinkedNode<T> current = front;
        while (current != null){
            res = res + " " + current.getValue();
            current = current.getNext();
        }
        return res;
    }
}
