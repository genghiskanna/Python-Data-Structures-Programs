
package bubblesort;

//Program to sort the elements using bubble sort.

import java.io.*;
import java.util.*;

public class BubbleSort
{
	public static void main(String args[])
	{
		int n,temp,i,pass;
		int A[]=new int[20];
		Scanner oin=new Scanner(System.in);
		
		//Getting the elements in the array.
		System.out.print("Enter the number of elements in the array: ");
		n=Integer.parseInt(oin.nextLine());
			
		System.out.println("Enter the elements of the array:");
		for(i=1;i<=n;i++)
		{
			A[i]=Integer.parseInt(oin.nextLine());
		}
		
		//sort
		for(pass=1;pass<=n;pass++)
		{
			for(i=1;i<=(n-pass);i++)
			{
				if(A[i]>A[i+1])
				{
					temp=A[i];
					A[i]=A[i+1];
					A[i+1]=temp;
				}
			}
		}
		System.out.print("Sorted Array: ");
		for(i=1;i<=n;i++)
		{
			System.out.print(""+A[i]+" ");
		}
	}
}