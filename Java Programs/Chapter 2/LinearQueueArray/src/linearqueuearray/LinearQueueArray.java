
package linearqueuearray;

import java.util.Scanner;

class Queue {

    protected int front;
    protected int rear;
    protected int size_of_array;
    protected int []q;

    public Queue(int size_of_array) {
        this.front = 0;
        this.rear = 0;
        this.q = new int[size_of_array+1];
        this.size_of_array=size_of_array;
    }
    protected int element;

    public void Enqueue(int element) {
        if(rear==size_of_array){
            System.out.println("Overflow..Queue is full");
            return;
        }
        if(front==0){
            front=1;
        }
        rear=rear+1;
        q[rear]=element;
    }
    
    public int Dequeue(){
        if(front ==0){
            System.out.println("Underflow..No ELements in Queue");
            return -1;
        }
        element=q[front];
        if(front==rear){
            front=rear=0;
        }
        else{
            front=front+1;
        }
        return element;
    }
    
    public void printelements(){
        
        if(front==0 && rear==0){
            System.out.println("empty queue..");
        }
        else{
            System.out.println("Elements in queue");
        for(int i=front;i<=rear;i++){
            System.out.print(" "+q[i]);
        }
        }
    }
    
}

public class LinearQueueArray {

    public static void main(String args[]) {
        int element;
        System.out.println("Enter the Queue size");
        Scanner sc = new Scanner(System.in);
        int size_of_queue = sc.nextInt();
        Queue q = new Queue(size_of_queue);
        while(true){
        System.out.println("\nChoice: \n 1. Enqueue \n 2. Dequeue \n 3. Exit");
        System.out.println("Enter Choice:");
        int Choice = sc.nextInt();
        if (Choice == 1) {
            System.out.println("Enter the element to be inserted");
            element = sc.nextInt();
            q.Enqueue(element);
            q.printelements();

        }
        else if (Choice == 2) {
           element= q.Dequeue();
           if(element != -1){
               System.out.println("Element deleted:"+element);
           }
           q.printelements();
        }
        else if (Choice == 3) {
            break;
        }
        else{
            System.out.println("Invalid Choice");
        }
        
        }

    }

}
