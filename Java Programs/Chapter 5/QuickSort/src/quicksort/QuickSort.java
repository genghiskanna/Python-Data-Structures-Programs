
package quicksort;

import java.util.Scanner;


public class QuickSort {

public static void Display(int A[], int n) // Helper Function to Display the
												// Array
	{
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + "\t");
		}
	}
public static void QuickSort(int A[],int low,int high,int n)
	{
	        int pivot,j,i;
                System.out.println("\nCall QuickSort(A,"+low+","+high+")");
	     	if(low < high)
		    {
                 //Then make pivot the first element
	         pivot=A[low];
                 System.out.println("Pivot : "+pivot);
	         i=low;
	         j=high;
                 System.out.println("i = "+i+", j = "+j);
	         while(i < j)
	            {
	                while( pivot >= A[i] && i<high)
	                {
	                    i++;
                            System.out.println("pivot = "+pivot+" i = "+i+" A[i] = "+A[i]);
	                }
                        System.out.println("pivot = "+pivot+" j = "+j+" A[j] = "+A[j]);
	                while(pivot < A[j] && j>=low)
	                {
	                    j--;
                            System.out.println("pivot = "+pivot+" j = "+j+" A[j] = "+A[j]);
	                }                        

	                if( i < j)
	                {
                            System.out.println("i = "+i+" j = "+j); 
                            System.out.println("Swap :  A[i] = "+A[i]+" A[j] = "+A[j]);                            
                            
	                    swap(A,i,j);
	             	}
	             }
                 System.out.println("low = "+low+" j = "+j); 
	         System.out.println("Swap :  A[low] = "+A[low]+" A[j] = "+A[j]);                            
                 if(A[low]>=A[j])
                    swap(A,low,j);
                 Display(A,n);
	        QuickSort(A,low,j-1,n);
	        QuickSort(A,j+1,high,n);
	    }                
            System.out.println("\nend QuickSort(A,"+low+","+high+")");
	    }
	public static void swap(int A[],int i,int j)
	{
	    int temp;
	    temp=A[i];
	    A[i]=A[j];
	    A[j]=temp;
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
	QuickSort(A,0, n-1,n);
	Display(A,n);
    }
}
