
package array_insertion;

//Program to insert an element in an array.
//The elements of the array maybe of any datatype.
import java.util.*;

public class Array_Insertion
{
	public static void main(String args[])
	{
		int n=10;
		Object[] A=new Object[n];
		Object element;
		int pos,noElements,i;
		
		Scanner oin=new Scanner(System.in);
		System.out.println("Enter the number of elements in the array");
		noElements=Integer.parseInt(oin.nextLine());
			
		System.out.println("Enter the elements of the array:");
		for(i=1;i<=noElements;i++)
		{
			A[i]=(Object)oin.nextLine();
		}	

		for(i=1;i<=noElements;i++)
		{
			System.out.print(""+A[i]+"	");
		}
		System.out.print("\nEnter the element to be inserted :");
		element=(Object)oin.nextLine();
		System.out.print("\nEnter the position where the element is to be inserted :");
		pos=Integer.parseInt(oin.nextLine());
		
		if(noElements==n || (pos>noElements+1))
		{
			System.out.println("Element cannot be inserted");
		}
		else
		{
			for(i=noElements;i>=pos;i--)
			{
				A[i+1]=A[i];
			}
			A[pos]=element;
			noElements=noElements+1;
		}
		System.out.println("\nNew Array");
		
		for(i=1;i<=noElements;i++)
		{
			System.out.print(""+A[i]+" | ");
		}
		
	}
}