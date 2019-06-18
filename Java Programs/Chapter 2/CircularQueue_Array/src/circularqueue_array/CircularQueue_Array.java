
package circularqueue_array;

//Program to implement Enqueue and Dequeue operations in Circular Queue using Array.
//The elements that is enqueued or dequeued may be of any datatype.
import java.io.*;
import java.util.*;

class CircularQueue_arr
{
	protected int N;
	protected Object[] queue=new Object[10];
	protected int front;
	protected int rear;
	
	public CircularQueue_arr()
	{
		N=5;
		front=0;
		rear=0;
				
	}
	//Circular queue enqueue operation:
	public void enqueue(Object element)
	{
		if(isOverflow())
		{
			System.out.println("Queue Overflow");
		}
		else
		{
			if(front==0)
			{
				front=1;
				rear=1;
			}
			else if(rear==N)
			{
				rear=1;
			}
			else
			{
				rear=rear+1;
			}
			queue[rear]=element;
		}
		System.out.println("Rear: "+rear+" Front: "+front);
		
	}
	//Circular queue dequeue operation:
	public Object dequeue()
	{
		Object element;
		if(isUnderflow())
		{
			System.out.println("Queue Underflow");
			element=null;
		}
		else
		{
			element=queue[front];
			if(front==rear)
			{
				front=0;
				rear=0;
			}
			else if(front==N)
			{
				front=1;
			}
			else
			{
				front=front+1;
			}
		}
		System.out.println("Front: "+front+" Rear: "+rear);
		return element;	
	}
	
	//check overflow condition
	public boolean isOverflow()
	{
		if((rear==N && front==1) || rear==front-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//check underflow condition
	public boolean isUnderflow()
	{
		if(front==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//display circularQueue
	public void diplayCQueue()
	{
		int ft=front;
		int rer=rear;

		System.out.print("Cirucular Queue: ");
		while(ft!=rer)
		{
			System.out.print(""+queue[ft]+" | ");
			if(ft==N)
			{
				ft=1;
			}
			else
			{
				ft=ft+1;
			}
			
		}
		if(ft==rer&&ft!=0&&rer!=0)
		{
			System.out.print(""+queue[ft]+" | ");
		}
	}
	
}
public class CircularQueue_Array
{
	public static void main(String args[]) throws Exception
	{
		Scanner oin=new Scanner(System.in);
		CircularQueue_arr que=new CircularQueue_arr();
		Object element;
		int choice;
		
		while(true)
		{
			
			System.out.println("\n\nEnter the operation to be performed\n 1.Enqueue\n 2.Dequeue\n 3.Exit");
			System.out.print("Option :");
			String s1=oin.nextLine();
			choice=Integer.parseInt(s1);
			if(choice==1)
			{
					System.out.print("Enter the element to be inserted: ");
					String s=oin.nextLine();
					element=(Object)s;
					que.enqueue(element);
					que.diplayCQueue();
			}
			else if(choice==2)
			{
				element=que.dequeue();
				if(element!=null)
				{
					System.out.println("Dequeued Element: "+element);
				}
				que.diplayCQueue();
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