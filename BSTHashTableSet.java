package week11;


public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T> {

    private int size;
    private BSTSet<T>[] buckets;

    public BSTHashTableSet(int n) {
        buckets = new BSTSet[n];
        size = 0;
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (index < 0 || index > buckets.length) {
            throw new Exception("Sorry, BSTHASHTABLE SET is empty");
        }
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return size / buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
        double stdev = 0;
        double meanX = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null)
            {
                meanX += buckets[i].getSize();
            }
            else
                meanX += 0;
        }
        meanX = meanX / buckets.length;
        for (int j = 0; j < buckets.length; j++) {
            if (buckets[j] != null)
                stdev += (buckets[j].getSize() - meanX) * (buckets[j].getSize() - meanX);
        }
        return Math.sqrt(stdev / (buckets.length));
    }

    @Override
    public String bucketsToString() {
        System.out.println("Number of entries in hashTable: " + getNumberOfBuckets());
        System.out.println("Load factor of a hashTable is: " + getLoadFactor());
        System.out.println("Standard deviation is : " + getBucketSizeStandardDev());
        String st = "";
        if (size == 0) {
            return "Sorry, this BST HASHTABLE SET Is empty";
        }
        for (int i = 0; i < buckets.length; i++) {
            st += i + "th bucket: " + (buckets[i] == null ? "\n" : buckets[i] + "\n");
        }
        return st + " ";
    }

    @Override
    public void add(T value) {
        int hashIndex = Math.abs(value.hashCode()) % buckets.length;
        if (buckets[hashIndex] == null) {
            buckets[hashIndex] = new BSTSet();
            buckets[hashIndex].add(value);
            size++;
        } else {
            size -= buckets[hashIndex].getSize();
            buckets[hashIndex].add(value);
            size += buckets[hashIndex].getSize();
        }
    }

    @Override
    public boolean contains(T value) {
        int hashIndex = Math.abs(value.hashCode()) % buckets.length;
        if (buckets[hashIndex] == null) {
            return false;
        }
        return buckets[hashIndex].contains(value);
    }


    @Override
    public boolean remove(T value) {
        if (size == 0) {
            return false;
        }
        int hashIndex = Math.abs(value.hashCode()) % buckets.length;
        boolean check = false;
        if (buckets[hashIndex] == null) {
            return false;
        }
        if (buckets[hashIndex].contains(value)) {
            buckets[hashIndex].remove(value);
            size--;
            check = true;
        }
        return check;
    }

    @Override
    public T removeAny() throws Exception {
        if (size == 0) {
            throw new Exception("Sorry, the BSTHASHTABLE SET is empty");
        }
        T tempV;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                tempV = buckets[i].removeAny();
                size--;
                if (buckets[i].getSize() == 0) {
                    buckets[i] = null;
                }
                return tempV;
            }
        }
        throw new Exception("Sorry, it is empty");
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new BSTSet[buckets.length];
        size = 0;
    }

    @Override
    public String toString() {
        String st = "";
        if (size == 0) {
            return "Sorry, this BST HASHTABLE SET Is empty";
        }
        for (int i = 0; i < buckets.length; i++) {
            st += i + "th bucket: " + (buckets[i] == null ? " " : buckets[i] + " ");
        }
        return st + " ";
    }
}