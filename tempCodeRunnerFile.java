class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Linked_list {
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
        System.out.println("Dequeued element :" + head.data);
        head = head.next;
    }

    void insertAtFirst(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void deleteFromLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("Dequeued element : " + head.data);
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println("Dequeued element : " + temp.next.data);
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
        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;

        } else {
            System.out.println("Position out of bounds!!");
        }

    }

    void deleteFromNPosition(int position) {
        if (head == null) {
            System.out.println("List is empty!!");
            return;
        }
        if (position == 0) {
            System.out.println("Dequeued element :" + head.data);
            head = head.next;
            return;
        }
        Node temp = head;
        int counter = 0;
        while (temp != null && counter < position - 1) {
            temp = temp.next;
            counter++;
        }

        if (temp != null && temp.next != null) {
            System.out.println("Dequeued element :" + temp.next.data);
            temp.next = temp.next.next;
        } else {
            System.out.println("Position out of bounds!!");
        }
    }

    void print() {

        System.out.println("Elements in list:");
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

}

public class Assignment1 {
    public static void main(String[] args) {
        Linked_list l1 = new Linked_list();

        l1.insertAtLast(10);
        l1.insertAtLast(15);
        l1.insertAtLast(20);
        l1.insertAtFirst(50);
        l1.deleteFromFirst();

        l1.insertAtLast(25);

        l1.insertAtFirst(100);
        l1.insertAtNPosition(12, 2);
        l1.deleteFromNPosition(2);

        l1.deleteFromLast();
        l1.deleteFromFirst();

        l1.print();
    }
}