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
interface HashTableSet<T> {
    
    public void add (T value);
    
    public boolean contains (T value);
    
    public boolean remove (T value);
    
    public T removeAny() throws Exception;
    
    public int getSize();
    
    public void clear();
    
    public int getNumberOfBuckets();
    
    public int getBucketSize(int index) throws Exception;
    
    public double getLoadFactor();
    
    public double getBucketSizeStandardDev();
    
    public String bucketsToString();
    
    public String toString();
            
            
}
