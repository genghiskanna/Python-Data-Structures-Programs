
package stack_linkedlist;

//Program to implement stack using array.
//Maximum size of the stack is 20.
//Elements of any datatype can be inserted into the stack.
import java.util.*;

//Program to implement Stack using linkedlist.
//This program will not work if inputs are not given properly.
//The data to be pushed or popped into and out of the stack may be of any datatype.
import java.io.*;
import java.util.*;
class Node
{
	protected Object value;
	protected Node next_address;
	public Node()
	{
		value=null;
		next_address=null;
	}
	public Node(Object element,Node top)
	{
		value=element;
		next_address=top;
	}
	public Object getValue()
	{
		return value;
	}
	public Node getNext_address()
	{
		return next_address;
	}

}
class Stack_link
{
	protected Node top;
	protected Node newNode;
	public Stack_link()
	{
		top=null;
	}
	public void push(Object element)
	{
		newNode=new Node(element,top);
		if(newNode==null)
		{
			System.out.println("Sufficient Memory Not Available to Create Nodes");
		}
		else
		{
			top=newNode;
		}
	}
	public Object pop()
	{
		Object element;
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			element=null;
		
		}
		else
		{
			
			element=top.getValue();
			top=top.getNext_address();
		}
		return element;
	}
	public boolean isEmpty()
	{
		if(top==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void displayStack()
	{
		Node temp=top;
		System.out.print("Stack: ");
		while(temp!=null)
		{
			System.out.print(temp.getValue()+" |");
			temp=temp.getNext_address();
		}
	}
	
}
public class Stack_LinkedList
{
	public static void main(String args[]) throws Exception
	{
		Scanner oin=new Scanner(System.in);
		Stack_link stk=new Stack_link();
		Object element;
		int choice;
		
		while(true)
		{
			
			System.out.println("\n\nEnter the operation to be performed\n 1.Push\n 2.Pop\n 3.Exit");
			System.out.print("Option: ");
			String s1=oin.nextLine();
			choice=Integer.parseInt(s1);
			if(choice==1)
			{
					System.out.print("Enter the element to be pushed: ");
					String s=oin.nextLine();
					Object data=(Object)s;
					stk.push(data);
					stk.displayStack();
			}
			else if(choice==2)
			{
				element= stk.pop();
				if(element!=null)
				{
					System.out.println("Poppped Element: "+element);
				}
				stk.displayStack();
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