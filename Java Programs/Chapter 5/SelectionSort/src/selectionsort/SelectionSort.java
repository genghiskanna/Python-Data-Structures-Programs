
package selectionsort;

import java.util.Scanner;


public class SelectionSort {

public static void Display(int A[], int n) // Helper Function to Display the
												// Array
	{
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + "\t");
		}
	}
public static void SelectionSort(int A[], int n) {
		int i, position, temp;
		for (i = 0; i < n; i++) {
                    System.out.println("\n\nPass : "+(i+1));
			position = FindMinimum(A, i, n);
			temp = A[position];
			A[position] = A[i];
			A[i] = temp;
                        Display(A, n);
		}
		
	}

	private static int FindMinimum(int[] A, int low, int n) {
		int position = low, j;
		for (j = low; j < n; j++) 
		{
			if (A[j] < A[position])
				position = j;
		}
		return position;
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
		SelectionSort(A, n);
		Display(A,n);
    }
}
