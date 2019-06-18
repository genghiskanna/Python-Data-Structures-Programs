
package binarysearch;

//Program to search an element in an array using binary search.
//Array A must be in sorted order and its maximum size is 20.
import java.util.*;

public class BinarySearch
{
	public static int BinarySearch(int A[],int low,int high,int e)
	{
		
		 int mid;
                 if(low>high)
                 {
                    System.out.println("Element is not found");
                    return -1;
                 }
                mid=(low+high)/2;
                if(A[mid]==e)
                {
                    System.out.println("Element found in Position:"+mid);
                    return mid;
                }
                if(A[mid]>e)
                {
                    return BinarySearch(A,low,mid-1,e);
                }
                else
                {
                    return BinarySearch(A,mid+1,high,e);
                }
               
	}
	public static void main(String args[])
	{
		int[] A=new int[20];
		int i,n,pos,low,high;
		int e;
		Scanner oin=new Scanner(System.in);
		
		//Getting the elements in the array.
		System.out.print("Enter the number of elements in the array: ");
		n=Integer.parseInt(oin.nextLine());
			
		System.out.println("Enter the elements of the array:");
		for(i=1;i<=n;i++)
		{
			A[i]=Integer.parseInt(oin.nextLine());
		}
		
		System.out.println("Enter the element to search:");
		e=Integer.parseInt(oin.nextLine());
		
		low=1;
		high=n;
		pos=BinarySearch(A,low,high,e);
		
	}
}