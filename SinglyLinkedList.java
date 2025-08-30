class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    void deleteFromFirst() {
        if (head == null) {
            System.out.println("List is empty!!");
            return;
        }
        System.out.println("Deleted element: " + head.data);
        head = head.next;
    }

    void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void deleteFromLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted element: " + head.data);
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println("Deleted element: " + temp.next.data);
        temp.next = null;
    }

    void insertAtNPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        int counter = 0;
        while (temp != null && counter < position - 1) {
            temp = temp.next;
            counter++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds!!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteFromNPosition(int position) {
        if (head == null) {
            System.out.println("List is empty!!");
            return;
        }
        if (position == 0) {
            System.out.println("Deleted element: " + head.data);
            head = head.next;
            return;
        }
        Node temp = head;
        int counter = 0;
        while (temp != null && counter < position - 1) {
            temp = temp.next;
            counter++;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds!!");
            return;
        }
        System.out.println("Deleted element: " + temp.next.data);
        temp.next = temp.next.next;
    }

    void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data);
            if (currentNode.next != null) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    void printHeading(String heading) {
       System.out.println();
        System.out.println(heading);
        System.out.println("=============================");
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.printHeading("Inserting at Last");
        list.insertAtLast(50);
        list.insertAtLast(25);
        list.insertAtLast(30);
        list.print();

        list.printHeading("Inserting at First");
        list.insertAtFirst(5);
        list.insertAtFirst(12);
        list.insertAtFirst(18);
        list.print();

        list.printHeading("Inserting at Nth Position");
        list.insertAtNPosition(99, 2);
        list.insertAtNPosition(44, 4);
        list.print();

        list.printHeading("Deleting from Last");
        list.deleteFromLast();
        list.print();

        list.printHeading("Deleting from First");
        list.deleteFromFirst();
        list.print();

        list.printHeading("Deleting from Nth Position");
        list.deleteFromNPosition(3);
        list.print();
    }
}
