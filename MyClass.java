/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11;

/**
 *
 * @author Абылай
 */
public class MyClass {
    public static void main(String[] args) throws Exception{
        IntStack stack = new ArrayIntStack();
        
        try{
            stack.push(12);;
            stack.pop();
            stack.pop();
            stack.push(333);
            
        }catch(Exception ex){
            stack.push(999);
        }
        System.out.println(stack.pop());
        
    }
}
