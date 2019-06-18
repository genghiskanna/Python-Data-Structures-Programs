package shellsort;

import java.util.LinkedList;
import java.util.Scanner;

public class ShellSort {

    public static void Display(int A[], int n) // Helper Function to Display the
    // Array
    {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + "\t");
        }
    }

    public static void ShellSort(int a[], int n) {
        int i, j, increment, temp;
        for (increment = n / 2; increment > 0; increment /= 2) {
            System.out.println("\n\nIncrement : "+increment);
            //insertion sort
            for (i = increment; i < n; i++) {
                temp = a[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp < a[j - increment]) {
                        a[j] = a[j - increment];
                    } else {
                        break;
                    }
                }
                Display(a,n);
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements :");
        int n = sc.nextInt();
        int A[] = new int[n];
        System.out.println("Enter the elements :");

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("Input Array : ");
		
        Display(A, n);
        ShellSort(A, n);
        Display(A, n);
    }
}
