/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

import java.util.Scanner;


public class InsertionSort {
   
    public static void Display(int A[], int n) // Helper Function to Display the
												// Array
	{
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + "\t");
		}
	}

    public static void InsertionSort(int A[], int n) {
		int i, temp, j;
		for (i = 1; i < n; i++) {
                        System.out.println("\n\nPass : "+i);
			temp = A[i];
			for (j = i - 1; j >= 0; j--) {
				if (temp < A[j])
					A[j + 1] = A[j];
				else
					break;
                         Display(A,n);
			}
			A[j + 1] = temp;
                        Display(A,n);
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
		InsertionSort(A, n);
		Display(A,n);
    }
}
