
package radixsort;

import java.util.Scanner;
import java.util.Vector;

class Bucket{
	Vector<Integer> list=new Vector<Integer>();
	public void add(int x)
	{
		list.add(x);
	}
	public void clear()
	{
		list.clear();
	}
}

public class RadixSort {

public static void Display(int A[], int n) // Helper Function to Display the
												// Array
	{
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + "\t");
		}
	}
    public static void RadixSort(int A[], int length, int max)
	{
            Bucket[] bucket=new Bucket[10];
	    int temp[]=new int[length];
	    int i,pass=1;
	    for(i=0;i<10;i++)
	    {
	    	bucket[i]=new Bucket();
	    }
	    for(i=0;i<length;i++)
	        temp[i]=A[i];
	    for (int n=1; max >= n; n *= 10)
	    {
                System.out.println("\n\nPass : "+(pass++));
	        for (i=0; i<length; i++)
	            bucket[(A[i]/n)%10].add(A[i]);
	        for (int k=i=0; i<10; bucket[i++].clear())
	        {
	            for(int j=0;j<bucket[i].list.size();j++)
	                A[k++]=bucket[i].list.get(j);
	        }
                Display(A,length);
	    }
	}


	public static int FindMax(int nums[], int length) {
		int max = nums[0];
		for (int i = 0; i < length; i++)
			if (nums[i] > max)
				max = nums[i];
		return max;
	}
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of elements :");
        int n = sc.nextInt();
		int A[] = new int[n];
                System.out.println("Enter the elements :");

		for (int i = 0; i < n; i++)
			A[i] = sc.nextInt();
                System.out.println("Input Array : ");
		Display(A,n);
		RadixSort(A, n, FindMax(A, n));
		Display(A,n);
    }
}
