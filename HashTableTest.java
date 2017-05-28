package week11;

/**
 *
 * @author user
 */
public class HashTableTest {
    
    public static void main(String[] args) {  
        Set<Integer> set = new LLQHashTableSet(10);
        
        set.add(10);
        set.add(11);
        set.add(13);
        System.out.println(set);
    }
}
