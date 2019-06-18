
package singlylinkedlist;

//Program to implement Singly linkedlist.
//Elements of any datatype could be inserted into the linked list.
import java.util.*;

class Node
{
	protected Object value;
	protected Node next_address;

	public void getNode()
	{
		value=null;
		next_address=null;
	}
	public Object getValue()
	{
		return value;
	}
	public Node getNext_address()
	{
		return next_address;
	}
	public void setValue(Object item)
	{
		value=item;
	}
	public void setNext_address(Node next)
	{
		next_address=next;
	}
}
class SinglyLinkedList_Operations
{
	protected Node start;
	protected Node current;
	protected Node newNode;
	protected Node previous;
	protected Node temp;
	
	public SinglyLinkedList_Operations()
	{
		start=null;
	}
	public void create_LinkedList(Object item)
	{
		newNode=new Node();
		newNode.setValue(item);
		
		if(start==null)
		{
			start=newNode;
			
		}
		else
		{
			temp=start;
			while(temp.getNext_address()!=null)
			{
					temp=temp.getNext_address();
					
			}
			temp.setNext_address(newNode);
		}
	}
	public void insertion_LinkedList(Object item,Object data)
	{
			newNode=new Node();
			newNode.getNode();
			newNode.setValue(item);
			if(start==null)
			{
				start=newNode;
			}
			else
			{
				current=start;
				while(current.getNext_address()!=null)
				{
					if((""+current.getValue()).equals(""+data))
					{
						newNode.setNext_address(current.getNext_address());
						current.setNext_address(newNode);
						break;
					}
					else
					{
						current=current.getNext_address();
					}
				}
				current.setNext_address(newNode);
			}
	}
	public void deletion_LinkedList(Object data)
	{
            boolean flag=false;
		if(start==null)
		{
			System.out.println("No Element to delete");
		}
		else
		{
			current=start;
			previous=start;
			while(current.getNext_address()!=null)
			{
				if((""+current.getValue()).equals(""+data))
				{
                                    flag=true;
					if(current==start)
					{
						start=current.getNext_address();
					}
					else
					{
						previous.setNext_address(current.getNext_address());
					}
					break;
				}
				else
				{
					previous=current;
					current=current.getNext_address();
				}
			}
			
		}
                if(flag == false)
                {
                    System.out.println("Element is not found");
                }
	}
	public void traversal_Linkedlist()
	{
		current=start;
		System.out.print("Linked List: ");
		while(current!=null)
		{
			System.out.print(""+current.getValue()+" | ");
			current=current.getNext_address();
		}
	}
}
public class SinglyLinkedList
{
	public static void main(String args[])
	{
		int choice,noitems,i;		
		Object item,data;
		
		Scanner oin=new Scanner(System.in);
		SinglyLinkedList_Operations lst=new SinglyLinkedList_Operations();
		
		//Generating initial list of items.
		System.out.println("Enter the number of items to be inserted in the link list: ");
		noitems=Integer.parseInt(oin.nextLine());
		
		System.out.println("Enter the items to be inserted in the link list:");
		for(i=0;i<noitems;i++)
		{
				System.out.print("Item"+(i+1)+": ");
				item=(Object)oin.nextLine();
				lst.create_LinkedList(item);
				System.out.println(" ");
		}
		
		while(true)
		{
			System.out.println("\n\nEnter the choice of operation:\n 1. Insert\n 2. Delete\n 3. Traverse\n 4. Exit");
			System.out.print("Option: ");
			choice=Integer.parseInt(oin.nextLine());

			if(choice==1)
			{
				System.out.print("Enter an item to be inserted in the linked list: ");
				item=(Object)oin.nextLine();
				System.out.print("Enter an item after which the new item must be inserted: ");
				data=(Object)oin.nextLine();
				
				lst.insertion_LinkedList(item,data);
				lst.traversal_Linkedlist();
					
			}
			else if(choice==2)
			{
				System.out.print("Enter an item to be deleted from the linked list: ");
				item=(Object)oin.nextLine();
				lst.deletion_LinkedList(item);
				lst.traversal_Linkedlist();
			}
			else if(choice==3)
			{
				lst.traversal_Linkedlist();
			}
			else if(choice==4)
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






