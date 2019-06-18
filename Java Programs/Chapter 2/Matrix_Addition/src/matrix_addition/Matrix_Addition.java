
package matrix_addition;

///Program to perform matrix addition.
//Matrix A and Matrix B has the dimensions nxm.
//Matrix C stores the resultant matrix.
//This program will throw exception if inputs other than integer is given.
import java.util.*;

class Matrix_Addition
{
	public static void main(String args[])
	{
		Scanner oin=new Scanner(System.in);
		
		int A[][]=new int[10][10];
		int B[][]=new int[10][10];
		int C[][]=new int[10][10];
		int m,n,i,j;
		
		System.out.println("Enter the number of rows in the matrix");
		n=Integer.parseInt(oin.nextLine());
		
		System.out.println("Enter the number of columns in the matrix");
		m=Integer.parseInt(oin.nextLine());
		
		System.out.println("Enter the elements in Matrix A");
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
					A[i][j]=Integer.parseInt(oin.nextLine());
			}
		}
		System.out.println("Enter the elements in Matrix B");
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
					B[i][j]=Integer.parseInt(oin.nextLine());
			}
		}
		System.out.println("\nMatrix A");
		System.out.println("--------\n");
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
					System.out.print(""+A[i][j]+"	");
			}
			System.out.println("\n");
		}
		System.out.println("\nMatrix B");
		System.out.println("--------\n");
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
					System.out.print(""+B[i][j]+"	");
			}
			System.out.println("\n");
		}
		System.out.println("\nMatrix C");
		System.out.println("--------\n");
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
					C[i][j]=A[i][j]+B[i][j];
					System.out.print(""+C[i][j]+"	");
			}
			System.out.println("\n");
		}
		
		
	}
}