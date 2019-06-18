
package polynomialaddition;

//Program to add two polynomials
//The exponents are given in increasing order in each polynomial
import java.util.*;

class  Node
{
	protected int coefficient;
	protected int exponent;
	protected Node next_address;
	
	public Node()
	{
		coefficient=0;
		exponent=0;
		next_address=null;
	}
	public Node(int coef,int exp)
	{
		coefficient=coef;
		exponent=exp;
		next_address=null;
		
	}
	public int getCoefficient()
	{
		return coefficient;
	}
	public int getExponent()
	{
		return exponent;
	}
	public void setNext_address(Node newNode)
	{
		next_address=newNode;
		
	}
	public Node getNext_address()
	{
		return next_address;
	}
	
}
class List
{
	protected Node startNode;
	protected Node newNode;
	protected Node temp;
	public List()
	{
		startNode=null;
		temp=null;
	}
	public void getNode(int coeff,int expo)
	{
		newNode=new Node(coeff,expo);
		
		if(startNode==null)
		{
			startNode=newNode;
			
		}
		else
		{
			temp=startNode;
			while(temp.getNext_address()!=null)
			{
					temp=temp.getNext_address();
					
			}
			temp.setNext_address(newNode);
		}
		
	}
	public Node getStart()
	{
		return startNode;
	}
	public void traverseList()
	{
		
		if(startNode!=null)
		{
			temp=startNode;	
			int i=0;
			while(temp!=null)
			{
					
					if(i==0||temp.getCoefficient()<0)
					{
					
						System.out.print(""+temp.getCoefficient()+"x^"+temp.getExponent());
					}
					else
					{
						System.out.print("+"+temp.getCoefficient()+"x^"+temp.getExponent());
					}					
					i++;
					temp=temp.getNext_address();
			}
		}
	}
}
class Polynomials
{
	protected Node start1;
	protected Node start2;
	protected Node start;
	protected Node temp1;
	protected Node temp2;
	protected Node newNode;
	
	
	public Polynomials()
	{
		start1=null;
		start2=null;
		start=null;
		temp1=null;
		temp2=null;
	}
	public void setPolynomial1(Node strt)
	{
		start1=strt;
	}
	public void setPolynomial2(Node strt)
	{
		start2=strt;
	}
	public void setResultPolynomial(Node strt)
	{
		start=strt;
	}
	public void addition(List lst)
	{
		temp1=start1;
		temp2=start2;
		while(temp1!=null && temp2 !=null)
		{
			if(temp1.getExponent()>temp2.getExponent())
			{
				lst.getNode(temp1.getCoefficient(),temp1.getExponent());
				temp1=temp1.getNext_address();
				
			}
			else if(temp1.getExponent()<temp2.getExponent())
			{
				lst.getNode(temp2.getCoefficient(),temp2.getExponent());
				temp2=temp2.getNext_address();
			}
			else if(temp1.getExponent()==temp2.getExponent())
			{
				lst.getNode((temp1.getCoefficient()+temp2.getCoefficient()),temp1.getExponent());
				temp1=temp1.getNext_address();
				temp2=temp2.getNext_address();
			}
		}
		while(temp1!=null && temp2==null)
		{
				lst.getNode(temp1.getCoefficient(),temp1.getExponent());
				temp1=temp1.getNext_address();
		}
		while(temp2!=null && temp1==null)
		{
				lst.getNode(temp2.getCoefficient(),temp2.getExponent());
				temp2=temp2.getNext_address();
		}
		
	}	
	
}
public class PolynomialAddition
{
	public static void main(String args[])
	{
		int coeff,expo;
		String s;
	
		Scanner oin=new Scanner(System.in);
		List lst1=new List();
		List lst2=new List();
		List lst=new List();
		
		Node nd=new Node();
		Polynomials poly=new Polynomials();
		
		System.out.println("Enter the first polynomial\n");
		while(true)
		{
			System.out.print("Coefficient: ");
			s=oin.nextLine();
			
			coeff=Integer.parseInt(s);
			
			System.out.print("Exponent: ");
			s=oin.nextLine();
			expo=Integer.parseInt(s);
			
			
			lst1.getNode(coeff,expo);
			
			System.out.print("\nDo you want to enter more?(y/n): ");
			s=oin.nextLine();
			if(s.equals("n"))
			{
				break;
			}
			else if(!s.equals("y")&&!s.equals("n"))
			{
				System.out.println("Invalid Choice");
				while(true)
				{
					System.out.print("\nDo you want to enter more?(y/n): ");
					s=oin.nextLine();
					if(s.equals("n")||s.equals("y"))
					{
						break;
					}
				}
				if(s.equals("n"))
				{
					break;
				}
			}
			
			
		}
		nd=lst1.getStart();
		poly.setPolynomial1(nd);
		
		System.out.println("\n====================================================\n");
		System.out.println("Enter the second polynomial\n");
		while(true)
		{
			System.out.print("Coefficient: ");
			s=oin.nextLine();
			
			coeff=Integer.parseInt(s);
			
			System.out.print("Exponent: ");
			s=oin.nextLine();
			expo=Integer.parseInt(s);

			lst2.getNode(coeff,expo);
			
			System.out.print("\nDo you want to enter more?(y/n): ");
			s=oin.nextLine();
			if(s.equals("n"))
			{
				break;
			}
			else if(!s.equals("y"))
			{
				System.out.println("Invalid Choice");
				while(true)
				{
					System.out.print("\nDo you want to enter more?(y/n): ");
					s=oin.nextLine();
					if(s.equals("n")||s.equals("y"))
					{
						break;
					}
				}	
			}
			
		}
		nd=lst2.getStart();
		poly.setPolynomial2(nd);
		
		System.out.println("\n===========================	POLYNOMIALS =========================\n");
		System.out.println("\nPolynomial 1:");
		lst1.traverseList();
		System.out.println("\n\nPolynomial 2:");
		lst2.traverseList();
		System.out.println("\n===========================	RESULT POLYNOMIAL =========================\n");
		poly.addition(lst);
		nd=lst.getStart();
		poly.setResultPolynomial(nd);
		lst.traverseList();
		
	}
}
