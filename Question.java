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
    
    
    public void insertAtFirst(int data) {
        
        Node newNode = new Node(data);
        
    
        newNode.next = head;
        
   
        head = newNode;
    }
    
 
    public void deleteAtFirst() {
       
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }
        
       
        head = head.next;
    }
    
  
    public void deleteAtLast() {
        
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;
        }
        
       
        if (head.next == null) {
            head = null;
            return;
        }
        
   
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
       
        current.next = null;
    }
    
  
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


public class Question {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
       
        list.insertAtFirst(30);
        list.insertAtFirst(20);
        list.insertAtFirst(10);
        
        System.out.println("After insertions:");
        list.display(); 
        

        list.deleteAtFirst();
        System.out.println("After deleteAtFirst:");
        list.display();
        
       
        list.deleteAtLast();
        System.out.println("After deleteAtLast:");
        list.display(); i
}
}