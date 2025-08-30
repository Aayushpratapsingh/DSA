class Node {
    int data;
    Node next;
    Node prev; // Used only in doubly linked mode

    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

public class CombinedLinkedList {
    private Node head;
    private boolean isDoubly; // Flag to switch between singly and doubly modes

    public CombinedLinkedList(boolean doublyMode) {
        head = null;
        isDoubly = doublyMode;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            if (isDoubly) {
                newNode.prev = temp;
            }
        }
    }

    public void delete(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            if (head != null && isDoubly) head.prev = null;
            System.out.println("Deleted " + data + " from the list.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                temp.prev.next = temp.next;
                if (isDoubly && temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                System.out.println("Deleted " + data + " from the list.");
                return;
            }
            temp = temp.next;
        }
    }

    public void display() {
        Node temp = head;
        System.out.print(isDoubly ? "Doubly Linked List: " : "Singly Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Singly Linked List
        System.out.println("Testing Singly Linked List:");
        CombinedLinkedList sll = new CombinedLinkedList(false);
        sll.insert(10);
        sll.insert(20);
        sll.insert(30);
        sll.display();
        sll.delete(20);
        sll.display();

        System.out.println("\nTesting Doubly Linked List:");
        // Test Doubly Linked List
        CombinedLinkedList dll = new CombinedLinkedList(true);
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.display();
        dll.delete(20);
        dll.display();
    }
}