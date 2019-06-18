
package evaluatepostfix_stacks;

//Program for the evaluation of postfix expression.
//This program will not work if the paranthesis in the infix expression is not balanced.
//This program will work correctly only if the following operators are used: +,-,*,/,%,^.
//The input(Infix expression) is given as a single string of integers.
import java.util.*;

class Stack_arr
{
	protected int N;
	protected String[] stack=new String[16];
	protected int top;
	
	public Stack_arr()
	{
		N=15;
		top=0;
		
	}
	public void push(String element)
	{
		if(top==N)
		{
			System.out.println("Stack Overflow");
		}
		else
		{
			top=top+1;
			stack[top]=element;
			
		}
		System.out.println("	Pushed: "+element);
		displayStack();
		
	}
	public String pop()
	{
		String element;
		if(top==0)
		{
			System.out.println("System Underflow");
			element="";
		}
		else
		{
			element=stack[top];
			top=top-1;	
		}
		System.out.println("	Popped: "+element);
		displayStack();
		return element;
	}
	public void displayStack()
	{
		int tmp=top;
		System.out.print(" Stack :: ");
		for(int i=tmp;i>0;i--)
		{
				System.out.print(stack[i]+" | ");
		}
		System.out.print("\n");
	}
	
}
class ToPostfix
{
	protected String postfixExp;
	protected String postfx[]=new String[20];
	protected int ct=0;
	protected Stack_arr stk=new Stack_arr();

	public ToPostfix()
	{
		postfixExp="";
	}
	public String[] toArray(String strng)
	{	

		String str="";
		int i=0,j=0;
		String[] st1=new String[20];
		char arr[]=strng.toCharArray();

		while(i<arr.length)
		{

			if(arr[i]=='('||arr[i]==')'||arr[i]=='+'||arr[i]=='-'||arr[i]=='*'||arr[i]=='/'||arr[i]=='%'||arr[i]=='^')
			{
				if(j==0&&str.equals(""))
				{
					st1[j]=""+arr[i];
					j++;
				}
				else if(j==0&&!str.equals(""))
				{
					if(!str.equals(""))
					{
						st1[j]=str;
						j++;
						str="";
					}
					st1[j]=""+arr[i];
					j++;					
				}
				else
				{
					if(!str.equals(""))
					{	
						st1[j]=str;
						j++;
						str="";
					}
					st1[j]=""+arr[i];
					j++;
				}
			}
			else
			{
				str=str+arr[i];
				if(i==arr.length-1)
				{
					st1[j]=str;
				}
			}
			
			i++;
		}
		
		return st1;
	}
	public void convertToPostfix(String infixExp)
	{
			
		String tos;
		String element;
		String symbol;		
		
		int i=0;
		String[] infx=toArray(infixExp);
		while(i<infx.length&&infx[i]!=null)
		{
			System.out.println("------------------------------------");
			System.out.println("	Parsed Element: "+infx[i]);
			symbol=infx[i];
			if(symbol.matches("\\+|\\-|\\*|\\/|\\%|\\^"))
			{
				if(stk.top==0)
				{
					stk.push(symbol);
				}
				else
				{
					tos=stk.stack[stk.top];
					if(tos.equals("("))
					{
						stk.push(symbol);
					}
					else
					{
						
						while(true)
						{
							if(stk.top==0)
							{
								stk.push(symbol);
								break;
							}
							else
							{
								tos=stk.stack[stk.top];
							}
							if((tos.matches("\\^|\\*|\\/|\\%"))&&(symbol.matches("\\+|\\-")))
							{								
								element=stk.pop();
								write(element);
							}
							else if(symbol.equals("^")&& !tos.equals("^"))
							{
								stk.push(symbol);
								break;
							}
							else if(tos.equals("^")&&symbol.equals("^"))
							{
								element=stk.pop();
								write(element);
							}
							else if(tos.equals("^"))
							{
								element=stk.pop();
								write(element);
							}
							else if((tos.matches("\\*|\\/|\\%"))&&(symbol.matches("\\*|\\/|\\%")))
							{
								element=stk.pop();
								write(element);	
							}
							else if((tos.matches("\\+|\\-"))&&(symbol.matches("\\+|\\-")))
							{
								element=stk.pop();
								write(element);	
							}
														
							else 
							{
								stk.push(symbol);
								break;
							}
						
						}
						
					}
				}
				
			}
			else if(symbol.equals("("))
			{
				stk.push(symbol);
			}
			else if(symbol.equals(")"))
			{
				
				while(true)
				{
						element=stk.pop();
						if(element.equals("("))
						{
							break;
						}
						write(element);
				}
			}
			else
			{
				write(symbol);				
			}
			
			i++;
		}
		System.out.println("------------------------------------");
		while(stk.top!=0)
		{
			tos=stk.pop();
			write(tos);
			
		}
	}
	public void write(String symb)
	{
		
		postfixExp=""+postfixExp+symb;
		postfx[ct]=symb;
		ct++;
	}	
}
class EvaluatePostfix
{
	protected String postExp;
	protected Stack_arr stk1=new Stack_arr();
	protected int i;
	protected String symbol;
	protected int result,operand1,operand2,element;
	
	public void evaluate(String[] postfx)
	{

		int i=0;
		
		while(i<postfx.length&&postfx[i]!=null)
		{
			symbol=postfx[i];
			System.out.println("	Parsed Element: "+symbol);
			if(symbol.matches("\\+|\\-|\\*|\\/|\\%|\\^"))//symbol is operator
			{	
				operand1=Integer.parseInt(stk1.pop());
				operand2=Integer.parseInt(stk1.pop());
				result=evaluateOperation(symbol,operand1,operand2);
				stk1.push(""+result);
				
			}
			else//symbol is operand
			{
				stk1.push(symbol);
			}
			i++;
			
		}
	
		result=Integer.parseInt(stk1.pop());
		System.out.println("Final Result :"+result);
		
	}
	public int evaluateOperation(String symbol,int operand1,int operand2)
	{
		if(symbol.equals("+"))
		{
			return (operand2+operand1);
		}
		else if(symbol.equals("-"))
		{
			return (operand2-operand1);
		}
		else if(symbol.equals("*"))
		{
			return (operand2*operand1);
		}
		else if(symbol.equals("/"))
		{
			return (operand2/operand1);
		}
		else if(symbol.equals("%"))
		{
			return (operand2%operand1);
		}
		else
		{
			return (operand2^operand1);
		}
		
	}
	
}
class EvaluatePostfix_Stacks
{
	public static void main(String args[]) throws Exception
	{
		Scanner oin=new Scanner(System.in);
		String infix;
		String postfix[];
		String postfxExp;
		ToPostfix post=new ToPostfix();
		EvaluatePostfix eval=new EvaluatePostfix();
			
		System.out.println("Enter the infix Expression with values.(Eg.2+3)");
		infix=oin.nextLine();
		System.out.println("Infix Expression: "+infix);
	
		post.convertToPostfix(infix);
		postfix=post.postfx;
		postfxExp=post.postfixExp;
		System.out.println("\n Complete Postfix Expression: "+postfxExp);
		System.out.println("=========================================================");
		System.out.println("\n Postfix Expression Evaluation ");
		System.out.println("------------------------------");
		eval.evaluate(postfix);
		
		
		
		
	
	}
}
