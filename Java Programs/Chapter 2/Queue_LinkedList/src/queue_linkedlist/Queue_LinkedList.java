
package queue_linkedlist;

//Program to implement Queue using linked list.
//Elements of any data type can be inserted into the queue.

import java.util.*;

//Node operations
class Node
{
	protected Object value;
	protected Node next;
	public Node()
	{
		value=null;
		next=null;
	}
	public Node(Object element)
	{
		value=element;
		next=null;
	}
	public Object getValue()
	{
		return value;
	}
	public Node getNext()
	{
		return next;
	}
	public void setNext(Node nxt)
	{
		next=nxt;
	}

}
//Queue operation
class Queue_link
{
	protected Node newNode;
	protected Node front;
	protected Node rear;
	
	public Queue_link()
	{
		front=null;
		rear=null;		
	}
	//Enqueue operation
	public void enqueue(Object element)
	{
		newNode=new Node(element);
		if(newNode==null)
		{
			System.out.println("Sufficient Memory not available to create node");
		}
		else
		{
			if(rear==null)
			{
				rear=newNode;
				front=newNode;
			}
			else
			{
				rear.setNext(newNode);
				rear=newNode;
			}
		}
		
	}
	//Dequeue operation
	public Object dequeue()
	{
		Object element;
		if(front==null)
		{
			System.out.println("Queue Underflow");
			element=null;
		}
		else
		{
			element=front.getValue();
			front=front.getNext();
			if(front==null)
			{
				rear=null;
			}
			
		}
		return element;
	}
	//Display queue
	public void displayQueue()
	{
		Node temp=front;
		System.out.print("Queue: ");
		while(temp!=null)
		{
			System.out.print(""+temp.getValue()+" | ");
			temp=temp.getNext();
		}
	}
	
}
public class Queue_LinkedList
{
	public static void main(String args[]) throws Exception
	{
		Scanner oin=new Scanner(System.in);
		Queue_link que=new Queue_link();
		Object element;
		int choice;
		
		while(true)
		{
			
			System.out.println("\n\nEnter the operation to be performed\n 1.Enqueue\n 2.Dequeue\n 3.Exit");
			System.out.print("Option: ");
			String s1=oin.nextLine();
			choice=Integer.parseInt(s1);
			if(choice==1)
			{
					System.out.print("Enter the element to be inserted: ");
					String s=oin.nextLine();
					element=(Object)s;
					que.enqueue(element);
					que.displayQueue();
			}
			else if(choice==2)
			{
				element=que.dequeue();
				if(element!=null)
				{
					System.out.println("Dequeued Element: "+element);
				}
				que.displayQueue();
			}
			else if(choice==3)
			{
				break;
			}
			else
			{
				System.out.println("Invalid Choice");
			}
				
		}
	}
	
}