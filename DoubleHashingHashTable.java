import java.util.Scanner;

class DataItem {
    int data;
    int key;

    public DataItem(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

public class DoubleHashingHashTable {
    private static final int SIZE = 10;  // Reduced size for shorter output
    private static final int R = 7;  // A prime number smaller than SIZE for second hash function
    private DataItem[] hashArray;
    private DataItem dummyItem;

    public DoubleHashingHashTable() {
        hashArray = new DataItem[SIZE];
        dummyItem = new DataItem(-1, -1); // Dummy item for deleted slots
    }

    // First hash function (Primary hash)
    private int hashCode(int key) {
        return key % SIZE;
    }

    // Second hash function (Secondary hash)
    private int hashCode2(int key) {
        return R - (key % R);
    }

    // Insert method to add a key-value pair
    public void insert(int key, int data) {
        DataItem item = new DataItem(key, data);
        int hashIndex = hashCode(key);
        int stepSize = hashCode2(key);
        int i = 0; // Collision counter

        while (hashArray[hashIndex] != null && hashArray[hashIndex].key != -1) {
            i++;
            hashIndex = (hashIndex + i * stepSize) % SIZE; // Double hashing formula
            if (i == SIZE) {
                System.out.println("Hash table is full. Couldn't insert " + key);
                return;
            }
        }

        hashArray[hashIndex] = item;
        System.out.println("Inserted " + key + " at index " + hashIndex);
    }

    // Search method to find a key
    public DataItem search(int key) {
        int hashIndex = hashCode(key);
        int stepSize = hashCode2(key);
        int i = 0; // Collision counter

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) {
                return hashArray[hashIndex];
            }
            i++;
            hashIndex = (hashIndex + i * stepSize) % SIZE; // Double hashing formula
            if (i == SIZE) break;
        }

        return null;
    }

    // Delete method to remove a key
    public DataItem delete(int key) {
        int hashIndex = hashCode(key);
        int stepSize = hashCode2(key);
        int i = 0; // Collision counter

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) {
                DataItem temp = hashArray[hashIndex];
                hashArray[hashIndex] = dummyItem; // Mark as deleted
                return temp;
            }
            i++;
            hashIndex = (hashIndex + i * stepSize) % SIZE; // Double hashing formula
            if (i == SIZE) break;
        }

        return null;
    }

    // Display method to show the contents of the table
    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < SIZE; i++) {
            if (hashArray[i] != null && hashArray[i] != dummyItem) {
                System.out.print("(" + hashArray[i].key + "," + hashArray[i].data + ") ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleHashingHashTable hashTable = new DoubleHashingHashTable();

        // Insert some values into the hash table
        hashTable.insert(1, 20);
        hashTable.insert(2, 70);
        hashTable.insert(42, 80);
        hashTable.insert(4, 25);
        hashTable.insert(12, 44);
        hashTable.insert(14, 32);
        hashTable.insert(17, 11);
        hashTable.insert(13, 78);
        hashTable.insert(37, 97);

        // Display the hash table contents after insertion
        hashTable.display();

        // Search for a key
        System.out.print("\nEnter value to search: ");
        int searchKey = scanner.nextInt();
        DataItem foundItem = hashTable.search(searchKey);
        if (foundItem != null) {
            System.out.println("Found " + foundItem.key + ": " + foundItem.data);
        } else {
            System.out.println("Not found");
        }

        // Delete a key
        System.out.print("\nEnter value to delete: ");
        int deleteKey = scanner.nextInt();
        DataItem deletedItem = hashTable.delete(deleteKey);
        if (deletedItem != null) {
            System.out.println("Deleted " + deletedItem.key + ": " + deletedItem.data);
        } else {
            System.out.println("Not found for deletion");
        }

        // Display the hash table contents after deletion
        hashTable.display();

        scanner.close();
    }
}
