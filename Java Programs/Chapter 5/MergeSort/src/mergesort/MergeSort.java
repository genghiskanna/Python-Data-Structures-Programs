
package mergesort;

import java.util.Scanner;

public class MergeSort {

public static void Display(int A[], int n) // Helper Function to Display the
												// Array
	{
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + "\t");
		}
	}
public static void MergeSort(int A[], int low, int high) {
	int mid;
        System.out.println("\nlow = "+low+", high = "+high);
    	if (low < high)
        {
            mid = (high + low)/2;
            System.out.println("\nmid = "+mid+ ", Call Merge_Sort(A, "+low+","+mid+")");
            MergeSort(A, low, mid);
            System.out.println("\nmid = "+mid+ ", Call Merge_Sort(A, "+(mid+1)+","+high+")");
            MergeSort(A, mid + 1, high);
            System.out.println("\nmid = "+mid+", Call Merge(A,"+low+","+mid+","+high+")");
            Merge(A, low, mid, high);
            System.out.println("\nend Merge(A,"+low+","+mid+","+high+")");
        }
	//Display(A, n);
	}

	public static void Merge(int a[], int low, int mid, int high)
	{
	    int temp[]=new int[100];
	    int subarray1 = low;
	    int subarray2 = mid + 1;
	    int temparray = low;
	    int i;


	   	while (subarray1 <= mid && subarray2 <= high)
		{
	        if (a[subarray1] < a[subarray2])
	        {
	    		temp[temparray] = a[subarray1];
				subarray1++;
			}
	        else
			{
	    		temp[temparray] = a[subarray2];
				subarray2++;
			}
			temparray++;

	    }


		if(subarray1 > mid)
		{
		    while (subarray2 <= high)
	     	{
				temp[temparray++] = a[subarray2++];
	  		}
		}
		else
		{
			while (subarray1 <= mid)
			{
	        	temp[temparray++] = a[subarray1++];
	  		}
		}

	   	for(i=low;i<=high;i++)
		{
			a[i] = temp[i];
		}
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
		MergeSort(A,0, n-1);
		Display(A,n);
    }
}
