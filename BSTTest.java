/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11;

/**
 *
 */
public class BSTTest {

    public static void main(String[] args){
        Set<Integer> values = new BSTSet();
        values.add(88);
        values.add(0);
        values.add(2);
        values.add(3);
        values.add(5);
        values.add(6);
        values.add(8);
        values.add(12);
        values.add(14);
        System.out.print(values);
        System.out.println("Size = " + values.getSize());

        
        values.remove(2);
        values.remove(100);
        values.remove(3);
        values.remove(14);
        values.remove(88);
        
            
        
        System.out.print(values);
        System.out.println("Size = " + values.getSize());
        
    }
}
