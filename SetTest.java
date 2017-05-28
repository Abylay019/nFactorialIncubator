package week11;

/**
 *
 * @author user
 */
public class SetTest {
    public static void main(String[] args) throws Exception{         
        TreeNode<Integer> node = new TreeNode(12);
        
        node.setLeft(new TreeNode(25));
        node.setRight(new TreeNode(17));
        
        node.getLeft().setLeft(new TreeNode(85));
        node.getRight().setLeft(new TreeNode(-46));
        node.getRight().setRight(new TreeNode(15));
        
       printTree(node);

    }
    
    public static void printTree(TreeNode<Integer> node){
        
        if (node == null)
            return;
        
        printTree(node.getLeft());
        printTree(node.getRight());
        System.out.println(node.getValue() + " ");
    }
}
