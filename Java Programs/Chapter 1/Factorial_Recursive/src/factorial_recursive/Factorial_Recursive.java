
package factorial_recursive;

//Program to find the factorial of a number the range of a long integer using recursive method.

import java.io.*;
import java.util.*;

public class Factorial_Recursive
{
	public static long findFactorial(int n)
	{
		if(n==1)
		{
			return 1;
		}
		else
		{
			return n*findFactorial(n-1);
		}
		
	}
	public static void main(String args[])
	{
		Scanner oin=new Scanner(System.in);
		System.out.print("Enter the number for finding factorial: ");
		int n=Integer.parseInt(oin.nextLine());
		long fact=findFactorial(n);
		System.out.print("Factorial of "+n+": "+fact);
	}
}