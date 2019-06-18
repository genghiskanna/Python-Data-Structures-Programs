
package expressiontree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

class nodeexpr {
	int value;
	boolean val;
	char opr;
	nodeexpr lchild, rchild;
	nodeexpr(int x, boolean y) {
		if (y == true)
			value = x;
		else
			opr = (char) x;
		val = y;
	}
}

public class ExpressionTree {
    static int val[]=new int[100];
	static HashMap<String, Integer> SymbolTable = new HashMap<String, Integer>();
	static HashMap<String, Integer> OprTable = new HashMap<String, Integer>();
	static String opr = "+-*/%";

	public static nodeexpr ConstructExpressionTree(String postfix, int n) {
		Stack<nodeexpr> Stk = new Stack<nodeexpr>();
		nodeexpr node = null, n1 = null, n2 = null;
                for(int i=0;i<n;i++)
                {
                    String s = ""+(char)('a'+i);
                    System.out.println(s);
                    SymbolTable.put(s, val[i]);
                }
             for(int i=0;i<n;i++)
                {
                    String s = ""+(char)('a'+i);
                    System.out.println(s);
                    System.out.println("Val : "+SymbolTable.get(s));
                 }
		

		char token[] = postfix.toCharArray(), next;
		int i;
		for (i = 0; i < postfix.length(); i++) {
			next = token[i];
                        if (opr.contains(next + "") == false) { // Operand
				node = new nodeexpr(next, true);
				node.lchild = null;
				node.rchild = new nodeexpr(SymbolTable.get(next + ""), true);
				Stk.push(node);
			} else {
				node = new nodeexpr(next, false);
				n1 = Stk.pop();
				n2 = Stk.pop();
				node.lchild = n2;
				node.rchild = n1;
				Stk.push(node);
			}
		}

		return Stk.pop();
	}

	public static int EvaluateExpressionTree(nodeexpr root) {
		int op1, op2, x;
                if (root.val == true) {
                    int s = SymbolTable.get((char) root.value + "");
                    return s;
		} else {
			char opr = root.opr;
			op1 = EvaluateExpressionTree(root.lchild);
			op2 = EvaluateExpressionTree(root.rchild);
			if (opr == '+')
				return op1 + op2;
			else if (opr == '-')
				return op1 - op2;
			else if (opr == '*')
				return op1 * op2;
			else if (opr == '/')
				return op1 / op2;
			else
				return op1 % op2;
		}
	}

	public static void main(String args[]) {
		String postfix="";
                int n,i;
		Scanner sc=new Scanner(System.in);
                System.out.println("Enter the number of variables");
                n=Integer.valueOf(sc.nextInt());
                System.out.println(n);
                for(i=0;i<n;i++)
                {
                System.out.println("Enter the value for "+ (char)('a'+i));
                val[i]=sc.nextInt();
                }
                System.out.print("Enter the Postfix Expression(wihout space in between characters):");
		nodeexpr root = ConstructExpressionTree(sc.next(),n);
		System.out.println(EvaluateExpressionTree(root));
	}
}

