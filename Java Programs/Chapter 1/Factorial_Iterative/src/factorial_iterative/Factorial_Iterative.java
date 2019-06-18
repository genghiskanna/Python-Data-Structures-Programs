
package factorial_iterative;

//Program to find the factorial of a number with value within the range of a long integer using iterative method.
import java.util.*;

public class Factorial_Iterative
{
	public static void findFactorial(int n)
	{
		long factorial=1;
		for(int i=2;i<=n;i++)
		{
			factorial=factorial*i;
		}
		System.out.print("Factorial of "+n+": "+factorial);
	}
	public static void main(String args[])
	{
		Scanner oin=new Scanner(System.in);
		System.out.print("Enter the number for finding factorial: ");
		int n=Integer.parseInt(oin.nextLine());
		findFactorial(n);
	}
}