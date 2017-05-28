package week11;

/**
 * 
 * @param <T>
 */
public class BSTSet<T extends Comparable> implements Set<T>{
    
    private TreeNode<T> root;
    private int size;
    
    public BSTSet(){
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if (root == null){
            root = new TreeNode(value);
            size++;
        }
        else if (!contains(value)){
            addHelper(value, root);
            size++;
        }
        
    }
    
    private void addHelper(T value, TreeNode node){
        if(value.compareTo(node.getValue()) > 0 && node.getRight() == null){                       
            node.setRight(new TreeNode(value));                                  
        }                         
        else if(value.compareTo(node.getValue()) < 0 && node.getLeft() == null){
            node.setLeft(new TreeNode(value));                                      
        }
        else{            
            if(value.compareTo(node.getValue())>0){
                addHelper(value, node.getRight());
            }
            else{
                addHelper(value, node.getLeft());
            }       
        }
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(value, root);
    }
    
    private boolean containsHelper(T value, TreeNode node){
        if (node == null){
            return false;
        }
        else if (value.compareTo(node.getValue()) == 0){
            return true;
        }
        else {
            if (value.compareTo(node.getValue()) > 0){
                return containsHelper(value, node.getRight());
            }
            else{
                return containsHelper(value, node.getLeft());
            }
        }
    }
    
    @Override
    public boolean remove(T value) {
        TreeNode<T> node = root, parent = null;
        while (node != null) {
            if (value.compareTo(node.getValue()) == 0) {
                //If current node is leaf
                if (node.getLeft() == null && node.getRight() == null) {
                    if (node.getValue().compareTo(parent.getRight().getValue()) == 0) {
                        parent.setRight(null);
                    } else {
                        parent.setLeft(null);
                    }
                } //If current node has 1 child
                else if ((node.getLeft() != null && node.getRight() == null) || (node.getRight() != null && node.getLeft() == null)) {
                        if (node.getValue().compareTo(parent.getRight().getValue()) == 0) {
                            if (node.getRight() != null) {
                                parent.setRight(node.getRight());
                            } else {
                                parent.setRight(node.getLeft());
                            }
                        } else {
                            if (node.getRight() != null) {
                                parent.setLeft(node.getRight());
                            } else {
                                parent.setLeft(node.getLeft());
                            }
                        }
                }//If current node has 2 children
                else {
                    TreeNode<T> temp = node.getRight();
                    TreeNode<T> parenttemp = null;
                    while (temp.getLeft() != null) {
                        parenttemp = temp;
                        temp = temp.getLeft();
                    }
                    node.setValue(temp.getValue());
                    if (temp.getRight() != null) {
                        parenttemp.setLeft(temp.getRight());
                    } else {
                        parenttemp.setLeft(null);
                    }
                }
                size--;
                return true;
            } else if (value.compareTo(node.getValue()) > 0) {
                parent = node;
                node = node.getRight();
            } else {
                parent = node;
                node = node.getLeft();
            }
        }
        return false;
    }
    
        
    @Override
    public T removeAny() throws Exception {
        T temp = (T) root.getValue();
        remove((T) root.getValue());
        size--;
        return temp;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        return toStringHelper(root);
    }

    private String toStringHelper(TreeNode<T> node) {
        if (node == null) {
            return " ";
        }
        return toStringHelper(node.getLeft())
                + node.getValue()
                + toStringHelper(node.getRight());
    }
    
}
