package week11;


public class LLQHashTableSet1<T> implements HashTableSet<T> {

    private Queue<T>[] buckets;
    private int size;

    public LLQHashTableSet1(int n) {
        buckets = new LinkedListQueue[n];
        size = 0;
    }

    @Override
    public void add(T value) {
        int hashIndex = Math.abs(value.hashCode()) % buckets.length;
        if (buckets[hashIndex] == null) {
            buckets[hashIndex] = new LinkedListQueue();
            buckets[hashIndex].enqueue(value);
            size++;
        } else {
            T tempValue;
            int tempSize = size;
            boolean check = true;
            while (tempSize-- > 0) {
                try {
                    tempValue = buckets[hashIndex].dequeue();
                    if (tempValue.equals(value))
                        check = false;
                    buckets[hashIndex].enqueue(tempValue);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (check) {
                buckets[hashIndex].enqueue(value);
                size = getSize() + 1;
            }
        }
    }

    @Override
    public boolean contains(T value) {
        int hashIndex = Math.abs(value.hashCode()) % buckets.length;
        if (buckets[hashIndex] == null) {
            return false;
        }
        boolean check = false;
        int tempSize = getSize();
        T tempValue;
        while (tempSize-- > 0) {
            try {
                tempValue = buckets[hashIndex].dequeue();
                buckets[hashIndex].enqueue(tempValue);
                if (tempValue.equals(value)) {
                    check = true;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return check;
    }

    @Override
    public boolean remove(T value) {
        if (size == 0) {
            return false;
        }
        int hashIndex = Math.abs(value.hashCode()) % buckets.length;
        boolean check = false;
        T tempValue;
        int tempSize = getSize();
        while (tempSize-- > 0) {
            try {
                tempValue = buckets[hashIndex].dequeue();
                if (tempValue.equals(value)) {
                    size--;
                    check = true;
                } else {
                    buckets[hashIndex].enqueue(tempValue);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return check;
    }

    @Override
    public T removeAny() throws Exception {
        if (size == 0) {
            throw new Exception("Sorry, the HASHTABLE SET is empty");
        }
        T tempV = null;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].getSize() != 0) {
                size--;
                return buckets[i].dequeue();
            }
        }
        return tempV;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new LinkedListQueue[buckets.length];
        size = 0;
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (index > buckets.length || index < 0) {
            throw new Exception("Sorry, the invalid index");
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
        int count = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null)
                meanX += buckets[i].getSize();
            else
                meanX += 0;
        }
        meanX = meanX / buckets.length;
        for (int j = 0; j < buckets.length; j++) {
            if (buckets[j] != null)
                stdev += (buckets[j].getSize() - meanX) * (buckets[j].getSize() - meanX);
        }
        stdev = Math.sqrt(stdev / (buckets.length - 1));
        return stdev;
    }

    @Override
    public String bucketsToString() {
        System.out.println("Number of entries in hashTable: " + getNumberOfBuckets());
        System.out.println("Load factor of a hashTable is: " + getLoadFactor());
        System.out.println("Standard deviation is : " + getBucketSizeStandardDev());
        String st = "";
        if (size == 0) {
            return "Nothing to print out: It is empty";
        }
        for (int i = 0; i < buckets.length; i++) {
            st += i + "th bucket: " + (buckets[i] == null ? "\n" : buckets[i] + "\n");
        }
        return st + " ";
    }

    @Override
    public String toString() {
        String st = "";
        if (size == 0) {
            return "Nothing to print out: It is empty";
        }
        for (int i = 0; i < buckets.length; i++) {
            st += i + "th bucket: " + (buckets[i] == null ? " " : buckets[i] + " ");
        }
        return st + " ";
    }
}