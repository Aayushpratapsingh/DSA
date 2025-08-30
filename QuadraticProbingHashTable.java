import java.util.Scanner;

class DataItem {
    int key;
    int data;

    public DataItem(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

public class QuadraticProbingHashTable {
    private static final int SIZE = 20;
    private DataItem[] hashArray;
    private final DataItem dummyItem;

    public QuadraticProbingHashTable() {
        hashArray = new DataItem[SIZE];
        dummyItem = new DataItem(-1, -1);
    }

    private int hashCode(int key) {
        return key % SIZE;
    }

    public void insert(int key, int data) {
        DataItem item = new DataItem(key, data);
        int hashIndex = hashCode(key);
        int i = 0;

        while (hashArray[hashIndex] != null && hashArray[hashIndex].key != -1) {
            i++;
            hashIndex = (hashIndex + i * i) % SIZE;
            if (i == SIZE) {
                System.out.println("Table full! Couldn't insert " + key);
                return;
            }
        }
        hashArray[hashIndex] = item;
        System.out.println("Inserted " + key + " at index " + hashIndex);
    }

    public DataItem search(int key) {
        int hashIndex = hashCode(key);
        int i = 0;
        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) return hashArray[hashIndex];
            i++;
            hashIndex = (hashIndex + i * i) % SIZE;
        }
        return null;
    }

    public DataItem delete(int key) {
        int hashIndex = hashCode(key);
        int i = 0;
        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) {
                DataItem temp = hashArray[hashIndex];
                hashArray[hashIndex] = dummyItem;
                return temp;
            }
            i++;
            hashIndex = (hashIndex + i * i) % SIZE;
        }
        return null;
    }

    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < 10; i++) { // Limit display to first 10 entries
            if (hashArray[i] == null)
                System.out.println("Index " + i + ": Empty");
            else if (hashArray[i] == dummyItem)
                System.out.println("Index " + i + ": Deleted");
            else
                System.out.println("Index " + i + ": " + hashArray[i].key);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable();

        // Inserting values
        hashTable.insert(1, 20);
        hashTable.insert(2, 70);
        hashTable.insert(42, 80);
        hashTable.insert(4, 25);
       
        // Display after insertion
        hashTable.display();

        // Search
        System.out.print("Enter key to search: ");
        int searchKey = scanner.nextInt();
        DataItem foundItem = hashTable.search(searchKey);
        System.out.println(foundItem != null ? "Found " + foundItem.key : "Not found");

        // Delete
        System.out.print("Enter key to delete: ");
        int deleteKey = scanner.nextInt();
        DataItem deletedItem = hashTable.delete(deleteKey);
        System.out.println(deletedItem != null ? "Deleted " + deletedItem.key : "Not found");

        // Display after deletion
        hashTable.display();

        scanner.close();
    }
}
