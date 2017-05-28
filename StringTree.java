/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11;

/**
 *
 * @author Zhanbek_Abylay
 */
public class StringTree {
    
    private String root;
    Queue<StringTree> children;
    
    public StringTree(String a){
        root = a;
        children = new LinkedListQueue<>();
    }
    
    public StringTree(String a, Queue<StringTree> b){
        root = a;
        children = b;
    }
    
    public String leafString() throws Exception{
        String res = leafStringHelper();
        res = res.trim() + ".";
        return res;
    }
    private String leafStringHelper()throws Exception{
        
        String res = "";
        if (root == null){
            throw new Exception("There is no tree!!!");
        }
        else{
            if (children.getSize() == 0){
                return root;
            }
            else{
                
                for (int i = 0; i < children.getSize(); i++){
                    StringTree temp = children.dequeue();
                    children.enqueue(temp);
                    if (temp.children.getSize() != 0){
                        res = res + temp.leafStringHelper();
                        
                    }
                    else{
                        res = res + temp.root + " ";
                        
                    }
                    
                }
                
            }
        }
        return res;
    }
    
}
