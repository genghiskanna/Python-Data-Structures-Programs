
package deque_array;

//Program for EnqueueRight and DequeueRight operations of Deque.
//The element of the deque can be of any datatype.
import java.util.*;
class Deque_arr
{
	protected Object[] deque=new Object[10];
	protected int N;
	protected int left;
	protected int right;
	public Deque_arr()
	{
		N=5;
		left=0;
		right=0;
	}
	public void enqueueRight(Object element)
	{
		if(isOverflow())
		{
			System.out.println("Overflow");
		}
		else
		{
			if(left==0)
			{
				left=1;
				right=1;
			}
			else if(right==N)
			{
				right=1;
			}
			else
			{
				right=right+1;
			}
			deque[right]=element;
		}
		
	}
	public Object dequeueRight()
	{
		Object element;
		if(isUnderflow())
		{
			System.out.println("Underflow");
			element=null;
		}
		else
		{
			element=deque[right];
			if(right==left)
			{
				left=0;
				right=0;
			}
			else if(right==1)
			{
				right=N;
			}
			else
			{
				right=right-1;
			}
		}
		return element;
	}
        public void enqueueLeft(Object element)
	{
		if(isOverflow())
		{
			System.out.println("Overflow");
		}
		else
		{
			if(left==0)
			{
				left=1;
				right=1;
			}
			else if(left==1)
			{
				left=N;
			}
			else
			{
				left=left-1;
			}
			deque[left]=element;
		}
		
	}
	public Object dequeueLeft()
	{
		Object element;
		if(isUnderflow())
		{
			System.out.println("Underflow");
			element=null;
		}
		else
		{
			element=deque[right];
			if(right==left)
			{
				left=0;
				right=0;
			}
			else if(left==N)
			{
				left=1;
			}
			else
			{
				left=left+1;
			}
		}
		return element;
	}
	public boolean isOverflow()
	{
		if((left==1 && right==N) || right==left-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isUnderflow()
	{
		if(left==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void displayDeque()
	{
		System.out.print("Deque: ");
                if(left > right)
                {
                    for(int i=left;i<=N;i++)
                    {
			System.out.print(""+deque[i]+" | ");
                    }
                    for(int i=1;i<=right;i++)
                    {
			System.out.print(""+deque[i]+" | ");
                    }
                }
                else
                {
                    for(int i=left;i<=right;i++)
                    {
			System.out.print(""+deque[i]+" | ");
                    }
                }
	}
}
public class Deque_Array
{
	public static void main(String args[])
	{
		Scanner oin=new Scanner(System.in);
		Deque_arr que=new Deque_arr();
		Object element;
		int choice;
		
		while(true)
		{
			
			System.out.println("\n\nEnter the operation to be performed\n 1.EnqueueRight\n 2.DequeueRight\n 3.EnqueueLeft\n 4.DequeueLeft\n 5.Exit");
			System.out.print("Option: ");
			String s1=oin.nextLine();
			choice=Integer.parseInt(s1);
			if(choice==1)
			{
					System.out.print("Enter the element to be inserted: ");
					String s=oin.nextLine();
					element=(Object)s;
					que.enqueueRight(element);
					que.displayDeque();
			}
			else if(choice==2)
			{
				element=que.dequeueRight();
				if(element!=null)
				{
					System.out.println("Dequeued Element: "+element);
				}
				que.displayDeque();
			}
                        else if(choice==3)
			{
					System.out.print("Enter the element to be inserted: ");
					String s=oin.nextLine();
					element=(Object)s;
					que.enqueueLeft(element);
					que.displayDeque();
			}
			else if(choice==4)
			{
				element=que.dequeueLeft();
				if(element!=null)
				{
					System.out.println("Dequeued Element: "+element);
				}
				que.displayDeque();
			}
			else if(choice==5)
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
