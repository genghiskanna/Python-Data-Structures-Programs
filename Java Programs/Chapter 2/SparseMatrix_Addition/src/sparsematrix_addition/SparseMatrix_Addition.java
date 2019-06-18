
package sparsematrix_addition;

//Program to add two sparse matrices.
import java.util.*;

class  Node
{
	protected int rowNum;
	protected int columnNum;
	protected int value;
	protected Node nextRow;
	protected Node nextColumn;
	
	public Node()
	{
		rowNum=0;
		columnNum=0;
		value=0;
		nextRow=null;
		nextColumn=null;
	}

	public int getRowNum()
	{
		return rowNum;
	}
	public int getColumnNum()
	{
		return columnNum;
	}
	public Node getNextRow()
	{
		return nextRow;
	}
	public Node getNextColumn()
	{
		return nextColumn;
	}
	public int getValue()
	{
		return value;
	}
	
	
	public void setRowNum(int row)
	{
		rowNum=row;
	}
	public void setColumnNum(int column)
	{
		columnNum=column;
	}
	public void setNextRow(Node row)
	{
		nextRow=row;
	}
	public void setNextColumn(Node column)
	{
		nextColumn=column;
	}
	public void setValue(int val)
	{
		value=val;
	}	
}
class Create_SparseMatrix
{
	protected Node[] start_Row=new Node[50];
	protected Node[] start_Column=new Node[50];
	protected Node newNode,temp,previous;
	
	public void createRowHeader(int m)
	{
		for(int i=1;i<=m;i++)
		{
			newNode=new Node();
			start_Row[i]=newNode;
			start_Row[i].setRowNum(i);
			start_Row[i].setColumnNum(0);
			start_Row[i].setNextRow(start_Row[i]);
			start_Row[i].setNextColumn(null);
		}
	}
	public void createColumnHeader(int n)
	{
		for(int i=1;i<=n;i++)
		{
			newNode=new Node();
			start_Column[i]=newNode;
			start_Column[i].setRowNum(0);
			start_Column[i].setColumnNum(i);
			start_Column[i].setNextRow(null);
			start_Column[i].setNextColumn(start_Column[i]);
		}
	}
	public void ifInput(int row_Number,int column_Number,int input_value)
	{
			newNode=new Node();
			newNode.setRowNum(row_Number);
			newNode.setColumnNum(column_Number);
			newNode.setValue(input_value);
			
			temp=start_Row[row_Number].getNextRow();
			previous=start_Row[row_Number];
			while((temp!=start_Row[row_Number]) && (temp.getColumnNum()<column_Number))
			{
				previous=temp;
				temp=temp.getNextRow();
			}
			previous.setNextRow(newNode);
			newNode.setNextRow(temp);
			
			temp=start_Column[column_Number].getNextColumn();
			previous=start_Column[column_Number];
			while((temp!=start_Column[column_Number]) && (temp.getRowNum()<row_Number))
			{
				previous=temp;
				temp=temp.getNextColumn();
			}
			previous.setNextColumn(newNode);
			newNode.setNextColumn(temp);
			
	}
	public void displaySparse()
	{
		Node temp1;

		for(int i=1;i<=start_Row.length;i++)
		{
			if(start_Row[i]==null)
			{
				break;
			}
			temp1=start_Row[i].getNextRow();
			while(temp1!=start_Row[i]&&start_Row[1]!=null)
			{
				
				System.out.println("Row: "+temp1.getRowNum()+"	Column: "+temp1.getColumnNum()+"	Value: "+temp1.getValue());		
				temp1=temp1.getNextRow();
			}
		}
	}
	
}
class SparseAddition
{
	protected Create_SparseMatrix sparx1=new Create_SparseMatrix();
	protected Create_SparseMatrix sparx2=new Create_SparseMatrix();
	protected Create_SparseMatrix sparx3=new Create_SparseMatrix();
	Scanner oin=new Scanner(System.in);
	protected Node temp1,temp2;
	protected Node[] tempColumn=new Node[50];
	protected Node tempRow,newNode;
	
	public void getInput(int m,int n,Create_SparseMatrix sparx)
	{
		int dat;
		int col;
		int row;
		String s;
		
		while(true)
		{
			System.out.print("Row Number : ");
			row=Integer.parseInt(oin.nextLine());
			System.out.print("Column Number : ");
			col=Integer.parseInt(oin.nextLine());
			System.out.print("Value : ");
			dat=Integer.parseInt(oin.nextLine());
			if(row<=m&&col<=n)
			{
				sparx.ifInput(row,col,dat);
			}
			else
			{
				System.out.println("Invalid Row or Column Number");
			}
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

	}
	public void addSparse(int m,int n)
	{
		System.out.println("Enter the elements of Sparse Matrix1: ");
		sparx1.createRowHeader(m);
		sparx1.createColumnHeader(n);
		getInput(m,n,sparx1);
		System.out.println("------------------------------------");
		System.out.println("\nEnter the elements of Sparse Matrix2: ");
		sparx2.createRowHeader(m);
		sparx2.createColumnHeader(n);
		getInput(m,n,sparx2);
		System.out.println("------------------------------------");			
		sparx3.createRowHeader(m);
		sparx3.createColumnHeader(n);
		add(m,n);
		
		System.out.println("------------------------------------");
		System.out.println("Sparse Matrix 1:");
		System.out.println("----------------");
		sparx1.displaySparse();
		System.out.println("------------------------------------");
		System.out.println("Sparse Matrix 2:");
		System.out.println("----------------");
		sparx2.displaySparse();
		System.out.println("------------------------------------");
		System.out.println("Resultant Sparse Matrix:");
		System.out.println("------------------------");
		sparx3.displaySparse();
	}
	public void add(int m,int n)
	{
		for(int i=1;i<=m;i++)
		{
			temp1=sparx1.start_Row[i].getNextRow();
			temp2=sparx2.start_Row[i].getNextRow();
			tempRow=sparx3.start_Row[i];
			while((temp1!=sparx1.start_Row[i]) && (temp2!=sparx2.start_Row[i]))
			{
				newNode=new Node();
				newNode.setNextRow(sparx3.start_Row[i]);
				newNode.setNextColumn(sparx3.start_Column[i]);
				
				if((temp1.getColumnNum())==(temp2.getColumnNum()))
				{
					newNode.setValue(temp1.getValue()+temp2.getValue());
					newNode.setRowNum(temp1.getRowNum());
					newNode.setColumnNum(temp1.getColumnNum());
					temp1=temp1.getNextRow();
					temp2=temp2.getNextRow();
				}
				else if((temp1.getColumnNum())<(temp2.getColumnNum()))
				{
					newNode.setValue(temp1.getValue());
					newNode.setRowNum(temp1.getRowNum());
					newNode.setColumnNum(temp1.getColumnNum());
					temp1=temp1.getNextRow();
				}
				else
				{
					newNode.setValue(temp2.getValue());
					newNode.setRowNum(temp2.getRowNum());
					newNode.setColumnNum(temp2.getColumnNum());
					temp2=temp2.getNextRow();
				}
				tempRow.setNextRow(newNode);
				tempRow=tempRow.getNextRow();
				tempColumn[newNode.getColumnNum()]=new Node();
				tempColumn[newNode.getColumnNum()].setNextColumn(newNode);
				tempColumn[newNode.getColumnNum()]=tempColumn[newNode.getColumnNum()].getNextColumn();	
			}
			if(temp1!=sparx1.start_Row[i] && temp2==sparx2.start_Row[i])
			{
				while(temp1!=sparx1.start_Row[i])
				{
						newNode=new Node();
						newNode.setNextRow(sparx3.start_Row[i]);
						newNode.setNextColumn(sparx3.start_Column[i]);
						newNode.setValue(temp1.getValue());
						newNode.setRowNum(temp1.getRowNum());
						newNode.setColumnNum(temp1.getColumnNum());
						temp1=temp1.getNextRow();
						tempRow.setNextRow(newNode);
						tempRow=tempRow.getNextRow();
						tempColumn[newNode.getColumnNum()]=new Node();
						tempColumn[newNode.getColumnNum()].setNextColumn(newNode);
						tempColumn[newNode.getColumnNum()]=tempColumn[newNode.getColumnNum()].getNextColumn();
				}
			}
			else if(temp1==sparx1.start_Row[i] && temp2!=sparx2.start_Row[i])
			{
				while(temp2!=sparx2.start_Row[i])
				{
					newNode=new Node();
					newNode.setNextRow(sparx3.start_Row[i]);
					newNode.setNextColumn(sparx3.start_Column[i]);
					newNode.setValue(temp2.getValue());
					newNode.setRowNum(temp2.getRowNum());
					newNode.setColumnNum(temp2.getColumnNum());
					temp2=temp2.getNextRow();
					tempRow.setNextRow(newNode);
					tempRow=tempRow.getNextRow();
					tempColumn[newNode.getColumnNum()]=new Node();
					tempColumn[newNode.getColumnNum()].setNextColumn(newNode);
					tempColumn[newNode.getColumnNum()]=tempColumn[newNode.getColumnNum()].getNextColumn();
					
				}
			}
			
		}
		
		
	}
		
}
public class SparseMatrix_Addition
{
	public static void main(String args[])
	{
		int m,n;
		SparseAddition add=new SparseAddition();
		Scanner oin=new Scanner(System.in);
		
		System.out.print("Enter the number of rows in the sparse matrix: ");
		m=Integer.parseInt(oin.nextLine());
		
		System.out.print("Enter the number of columns in the sparse matrix: ");
		n=Integer.parseInt(oin.nextLine());
		add.addSparse(m,n);

	}
}



