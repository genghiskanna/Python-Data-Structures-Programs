package linearsearch;

//Program to search an element in an array using linear search.
//Maximum size of the array is 20.
//The elements can be of any data type.
//When there are duplicate elements the position of the first occurrence is displayed

import java.util.*;

public class LinearSearch
{
	public static int search(Object A[],Object element,int n)
	{
		int pos=-1;
		for(int i=1;i<=n;i++)
		{

			if((""+A[i]).equals(""+element))
			{
				pos=i;
				break;
			}
			
		}
		return pos;
	}
	public static void main(String args[])
	{
		Object[] A=new Object[20];
		int i,n,pos;
		Object element;
		Scanner oin=new Scanner(System.in);
		
		//Getting the elements in the array.
		System.out.println("Enter the number of elements in the array: ");
		n=Integer.parseInt(oin.nextLine());
			
		System.out.println("Enter the elements of the array:");
		for(i=1;i<=n;i++)
		{
			A[i]=(Object)oin.nextLine();
		}
		
		System.out.print("Enter the element to be found: ");
		element=(Object)oin.nextLine();
		pos=search(A,element,n);
		if(pos==-1)
		{
			System.out.println("The searched element is not found");
		}
		else
		{
			System.out.println("The element is found in position "+pos+" in the array.");
		}
		
	}
}