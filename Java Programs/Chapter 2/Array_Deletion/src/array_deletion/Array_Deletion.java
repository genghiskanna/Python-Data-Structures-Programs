
package array_deletion;

//Program to delete a particular element in an array.
//The elements of the array maybe of any datatype.
//When there are duplicates only the first instance is deleted
import java.util.*;

public class Array_Deletion
{
	public static void main(String args[])
	{
		int n=10;
                boolean flag = false;
		Object[] A=new Object[n];
		Object element;
		int noElements,i,j;
		Scanner oin=new Scanner(System.in);
		
		//Getting the elements in the array.
		System.out.println("Enter the number of elements in the array:");
		noElements=Integer.parseInt(oin.nextLine());
			
		System.out.println("Enter the elements of the array:");
		for(i=1;i<=noElements;i++)
		{
			A[i]=(Object)oin.nextLine();
		}	
		
		//Displaying the elements of the array.
		System.out.println("\nArray");
		System.out.println("------");
		for(i=1;i<=noElements;i++)
		{
			System.out.print(""+A[i]+"	");
		}
		
		//Getting the element to be deleted from the array.
		System.out.print("\nEnter the element to be deleted :");
		element=(Object)oin.nextLine();
		
		//Performing deletion operation.
		for(i=1;i<=noElements;i++)
		{
                    
				if((""+A[i]).equals(""+element))
				{
					for(j=i;j<=noElements-1;j++)
					{
						A[j]=A[j+1];
					}
					noElements=noElements-1;
                                        flag=true;
					break;
				}
		}
		
		//Displaying the new array after deleting the element.
                if(flag == false)
                    System.out.println("\nElement is not found");
		System.out.println("\nArray");
		System.out.println("------");
		for(i=1;i<=noElements;i++)
		{
			System.out.print(""+A[i]+"	");
		}
	}
}









