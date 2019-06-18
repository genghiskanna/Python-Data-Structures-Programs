
package matrix_multiplication;

//Program to perform Matrix Multiplication.
//Matrix A is of dimension nxm and Matrix B is of dimension mxr.
//The resultant matrix is stored is Matrix C which is of dimension nxr.
//This program will throw exception if inputs other than integer is given.
import java.util.*;

class Matrix_Multiplication
{
	public static void main(String args[])
	{
		Scanner oin=new Scanner(System.in);
		
		int A[][]=new int[10][10];
		int B[][]=new int[10][10];
		int C[][]=new int[10][10];
		int m,n,r,i,j,k;
		
		System.out.print("Enter the number of rows in the matrix A: ");
		n=Integer.parseInt(oin.nextLine());
		
		System.out.print("\nEnter the number of columns in the matrix A: ");
		m=Integer.parseInt(oin.nextLine());
		
		System.out.println("\nEnter the elements in Matrix A:");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=m;j++)
			{
					A[i][j]=Integer.parseInt(oin.nextLine());
			}
		}
		
		System.out.println("\nNumber of rows in Matrix B: "+m);
		System.out.print("\nEnter the number of columns in the matrix B: ");
		r=Integer.parseInt(oin.nextLine());

		System.out.println("\nEnter the elements in Matrix B:");
		for(i=1;i<=m;i++)
		{
			for(j=1;j<=r;j++)
			{
					B[i][j]=Integer.parseInt(oin.nextLine());
			}
		}
		System.out.println("\nMatrix A");
		System.out.println("--------");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=m;j++)
			{
					System.out.print(""+A[i][j]+"	");
			}
			System.out.println("\n");
		}
		System.out.println("\nMatrix B");
		System.out.println("--------");
		for(i=1;i<=m;i++)
		{
			for(j=1;j<=r;j++)
			{
					System.out.print(""+B[i][j]+"	");
			}
			System.out.println("\n");
		}
		System.out.println("\nMatrix C");
		System.out.println("--------");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=r;j++)
			{
				C[i][j]=0;
				for(k=1;k<=m;k++)
				{
					C[i][j]=C[i][j]+A[i][k]*B[k][j];
						
				}
				System.out.print(""+C[i][j]+"	");
			}
			System.out.println("\n");
		}
					
		
	}
}