
package stack_array;

//Program to implement stack using array.
//Maximum size of the stack is 20.
//Elements of any datatype can be inserted into the stack.
import java.io.*;
import java.util.*;

class Stack_arr
{
	protected int N;
	protected Object[] stack=new Object[20];
	protected int top;
	
	public Stack_arr()
	{
		N=15;
		top=0;
		
	}
	//Push operation
	public void push(Object element)
	{
		if(top==N)
		{
			System.out.println("Stack Overflow");
		}
		else
		{
			top=top+1;
			stack[top]=element;
			
		}
		
	}
	//Pop operation
	public Object pop()
	{
		Object element;
		if(top==0)
		{
			System.out.println("Underflow");
			element=null;
		}
		else
		{
			element=stack[top];
			top=top-1;	
		}
		return element;
	}
	//Display stack
	public void displayStack()
	{
		System.out.print("Stack: ");
		for(int i=top;i>0;i--)
		{
			System.out.print(""+stack[i]+" | ");
		}
	}
	
}
class Stack_Array
{
	public static void main(String args[]) throws Exception
	{
		Scanner oin=new Scanner(System.in);
		Stack_arr stk=new Stack_arr();
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
