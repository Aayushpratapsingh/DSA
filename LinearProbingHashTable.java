
import java.util.Scanner;
public class LinearProbingHashTable {
    private static final int SIZE = 20;
    private DataItem[] hashArray;
    private DataItem dummyItem;

    public LinearProbingHashTable() {
        hashArray = new DataItem[SIZE];
        dummyItem = new DataItem(-1, -1); // Dummy item for deleted slots
    }

    private int hashCode(int key) {
        return key % SIZE;
    }

    // Insert method
    public void insert(int key, int data) {
        DataItem item = new DataItem(key, data);
        int hashIndex = hashCode(key);
        int startIndex = hashIndex;

        while (hashArray[hashIndex] != null && hashArray[hashIndex].key != -1) {
            hashIndex = (hashIndex + 1) % SIZE;
            if (hashIndex == startIndex) return;
        }

        hashArray[hashIndex] = item;
    }

    // Search method
    public DataItem search(int key) {
        int hashIndex = hashCode(key);
        int startIndex = hashIndex;

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) {
                return hashArray[hashIndex];
            }
            hashIndex = (hashIndex + 1) % SIZE;
            if (hashIndex == startIndex) break;
        }

        return null;
    }

    // Delete method
    public DataItem delete(int key) {
        int hashIndex = hashCode(key);
        int startIndex = hashIndex;

        while (hashArray[hashIndex] != null) {
            if (hashArray[hashIndex].key == key) {
                DataItem temp = hashArray[hashIndex];
                hashArray[hashIndex] = dummyItem; // Mark as deleted
                return temp;
            }
            hashIndex = (hashIndex + 1) % SIZE;
            if (hashIndex == startIndex) break;
        }

        return null;
    }

    // Display method to show the contents of the table (only first 10 indices)
    public void display() {
        System.out.println("\nHash Table (first 10 indices):");
        for (int i = 0; i < 10; i++) {
            if (hashArray[i] == null) {
                System.out.println("Index " + i + ": Empty");
            } else if (hashArray[i] == dummyItem) {
                System.out.println("Index " + i + ": Deleted");
            } else {
                System.out.println("Index " + i + ": (" + hashArray[i].key + ", " + hashArray[i].data + ")");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinearProbingHashTable hashTable = new LinearProbingHashTable();

        // Insert some values
        hashTable.insert(1, 20);
        hashTable.insert(2, 70);
        hashTable.insert(42, 80);
        hashTable.insert(4, 25);
        hashTable.insert(12, 44);
        hashTable.insert(14, 32);
        hashTable.insert(17, 11);
        hashTable.insert(13, 78);
        hashTable.insert(37, 97);

        // Display after insertion
        hashTable.display();

        // Search
        System.out.print("\nEnter key to search: ");
        int searchKey = scanner.nextInt();
        DataItem foundItem = hashTable.search(searchKey);
        System.out.println(foundItem != null
            ? "Found: " + foundItem.data
            : "Not found");

        // Delete
        System.out.print("\nEnter key to delete: ");
        int deleteKey = scanner.nextInt();
        DataItem deletedItem = hashTable.delete(deleteKey);
        System.out.println(deletedItem != null
            ? "Deleted: " + deletedItem.data
            : "Not found");

        // Display after deletion
        hashTable.display();

        scanner.close();
    }
}
