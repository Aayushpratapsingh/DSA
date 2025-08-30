class Queuee {
    int front;
    int rear;
    int[] Queue;

    Queuee(int queueSize) {
        this.Queue = new int[queueSize];
        this.front = 0;
        this.rear = 0;
    }

    public void enQueue(int data) {
        if (rear == Queue.length) {
            System.out.println();
            System.out.println("Queue is full");
            return;
        }
        Queue[rear++] = data;
    }

    public int deQueue() throws Exception {
        if (front == rear) {
            System.out.println("Queue is empty");
            throw new Exception("Queue is empty");
        }
        int data = Queue[front++];
        return data;
    }

   
    public void printQueue() {
        for (int i = front; i < rear; i++) {  
            System.out.print(Queue[i] + " ");  
        }
        System.out.println();  
    }
}

public class QueueExample {
    public static void main(String[] args) {
        Queuee queue = new Queuee(5);
        
       
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        
       
        System.out.print("Queue contents: ");
        queue.printQueue();
        
        try {
         
            System.out.println("Dequeued: " + queue.deQueue());
            // System.out.print("Queue contents after dequeue: ");
            // queue.printQueue();
            
            System.out.println("Dequeued: " + queue.deQueue());
            System.out.println("Dequeued: " + queue.deQueue());
            
          
            System.out.println("Dequeued: " + queue.deQueue());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}