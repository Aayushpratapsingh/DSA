class Node {
    int data;
    Node next;
}

class LinkedList {
    Node head;

   
    public void insertAtLast(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

   
    public void print() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No elements in the linked list.");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println();

     
        linkedList.insertAtLast(10);
        linkedList.insertAtLast(20);
        linkedList.insertAtLast(30);

       
        linkedList.print();
    }
}
