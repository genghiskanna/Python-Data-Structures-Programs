
package rbt;

import java.util.Scanner;

class Node
{
int data;
  int nodeColor;
  Node parent,lchild,rchild;
};

//function prototypes
public class RBT
{
	  private static final int BLACK = 1;
	  private static final int RED = 2;
	  private static final int FALSE = 0;
	  private static final int TRUE=1;
	  public static void inorder(Node  root)
           {
            if(root != null)
            {
	    inorder(root.lchild);
	    System.out.println("Data : "+root.data+", Color(Black : 1/Red : 2) : "+root.nodeColor);
	    inorder(root.rchild);
            }
           }

	public static Node getGrandParent(Node N)
{
    if ((N != null) && (N.parent != null))
        return N.parent.parent;
    else
        return null;
}

	public static Node getUncle(Node N)
{
    Node G = getGrandParent(N);
    // No grandparent means No uncle
    if (G == null)
        return null;
    if (N.parent == G.lchild)
        return G.rchild;
    else
        return G.lchild;
}

	public static Node  GetNode(int element)
{
	Node  temp = new Node();
	temp.data = element;
	temp.nodeColor = RED;
	temp.lchild = null;
	temp.rchild = null;
	temp.parent = null;
	return(temp);
}

//BST insertion is performed
	public static Node  Insert_BST(Node root,int element)
{
    Node currentNode = root;
    Node parentNode=null;
    if(root == null)
    {
        currentNode = root = GetNode(element);
    }
    else
    {
        while(currentNode != null)
        {
            parentNode = currentNode;
            if( element < currentNode.data )
                currentNode = currentNode.lchild;
            else
                currentNode = currentNode.rchild;
        }
        currentNode = GetNode(element);
        if(currentNode.data < parentNode.data)
            parentNode.lchild = currentNode;
        else
            parentNode.rchild = currentNode;
        currentNode.parent = parentNode;
    }
    root = checkRedBlackProperties(root,currentNode);
    return root;
}

	public static Node checkRedBlackProperties(Node root,Node n)
{
    while (n != root && n.parent.nodeColor == RED)    //parent is red
    {
        Node uncle = getUncle(n);
        Node grandParent = getGrandParent(n);
        if (grandParent !=null)
        {
            if (uncle != null && uncle.nodeColor == RED)
            {
                //uncle is RED
                n.parent.nodeColor = BLACK;
                uncle.nodeColor = BLACK;
                grandParent.nodeColor = RED;
                n = grandParent;
            }
            else
            {
                //uncle is BLACK
                if(n.parent == grandParent.lchild)
                {
                    if (n == n.parent.rchild)
                    {
                        //case LR
                        n = n.parent;
                        root = rotateLeft(root,n);
                    }
                        // case LL
                    n.parent.nodeColor = BLACK;
                    getGrandParent(n).nodeColor = RED;
                    root = rotateRight(root,getGrandParent(n));
                }
                else
                {
                    //n's parent is right child of grand parent
                    if (n == n.parent.lchild)
                    {
                        //case RL
                        n = n.parent;
                        root = rotateRight(root,n);
                    }
                    //case RR
                    n.parent.nodeColor = BLACK;
                    getGrandParent(n).nodeColor = RED;
                    root = rotateLeft(root,getGrandParent(n));
                }
            }
        }
    }
    root.nodeColor = BLACK;
    return root;
}

static Node rotateLeft(Node root,Node nodeToBeRotated)
{
    Node child = nodeToBeRotated.rchild;
    nodeToBeRotated.rchild = child.lchild;
    if (child.lchild != null)
        child.lchild.parent = nodeToBeRotated;
    if (child != null)
        child.parent = nodeToBeRotated.parent;
    if (nodeToBeRotated.parent != null)
    {
        if (nodeToBeRotated == nodeToBeRotated.parent.lchild)
            nodeToBeRotated.parent.lchild = child;
        else
            nodeToBeRotated.parent.rchild = child;
    }
    else
    {
        root = child;
    }
    child.lchild = nodeToBeRotated;
    if (nodeToBeRotated != null)
        nodeToBeRotated.parent = child;
    return root;
}

static Node rotateRight(Node root,Node nodeToBeRotated)
{
    Node child = nodeToBeRotated.lchild;
    nodeToBeRotated.lchild = child.rchild;
    if (child.rchild != null)
        child.rchild.parent = nodeToBeRotated;
    if (child != null)
        child.parent = nodeToBeRotated.parent;
    if (nodeToBeRotated.parent != null)
    {
        if (nodeToBeRotated == nodeToBeRotated.parent.rchild)
            nodeToBeRotated.parent.rchild = child;
        else
            nodeToBeRotated.parent.lchild = child;
    }
    else
    {
        root = child;
    }
    child.rchild = nodeToBeRotated;
    if (nodeToBeRotated != null)
        nodeToBeRotated.parent = child;
    return root;
}
static Node Delete_BST(Node  root, int key)
{
    // nodes and their roles played
    Node nodeToBeDeleted = root;    //N in algorithm
    Node successor = null;     // I and D in algorithm
    Node child = null;         // C in algorithm

    //find the node to be deleted
    while(nodeToBeDeleted != null)
    {
        if(nodeToBeDeleted.data == key)
            break;
        else
        {
                if(nodeToBeDeleted.data > key)
                    nodeToBeDeleted = nodeToBeDeleted.lchild;
                else
                    nodeToBeDeleted = nodeToBeDeleted.rchild;
        }
    }
    if ( nodeToBeDeleted == null)
    {
        System.out.println("Node not found");
        return root;
    }


    //finding the replacement node for the node to be deleted
    if (nodeToBeDeleted.lchild == null || nodeToBeDeleted.rchild == null)
    {
        // successor has a null(BLACK) node as a child
        successor = nodeToBeDeleted;
    }
    else
    {
        // find the inorder successor with a null(BLACK) node as a child
        successor = nodeToBeDeleted.rchild;
        while (successor.lchild != null)
            successor = successor.lchild;
    }

    // child is successor's only child
    if (successor.lchild != null)
        child = successor.lchild;
    else if (successor.rchild != null)
        child = successor.rchild;


    if (successor != nodeToBeDeleted)
    {
        //Copy the value of the inorder successor(I) in the node(N) to be deleted
        //Mark I as D and I’s child as C
        nodeToBeDeleted.data = successor.data;
    }

    //Proceed to the cases for deletion
    root = Deletion_cases(root,successor,child);

    //return new root
    return root;
}

static Node replaceNode(Node  root, Node  D, Node C)
{
        // remove D and replace with C
            if (D.parent == null)
            {
                // D is the root node
                root = C;
                C.parent = null;
                return root;
            }
            if(C != null)
            {
                C.parent = D.parent;
            }
            if (D == D.parent.lchild)
                D.parent.lchild = C;
            else
                D.parent.rchild = C;
            
            return root;
}


static Node  Deletion_cases(Node  root, Node  D, Node  C)
{
    //Case 1 : D is red
    if(D.nodeColor == RED && (C == null || C.nodeColor == BLACK))
    {
        root = replaceNode(root,D,C);
        return root;
    }


    //Case 2 : D is black and C is red
    if(D.nodeColor == BLACK && (C != null && C.nodeColor == RED))
    {
        // D is replaced with C
        //Repaint C black
        root = replaceNode(root, D ,C);
        C.nodeColor = BLACK;
        return root;
    }


    //Case 3 : D and C are black
    if(D.nodeColor == BLACK && (C == null || C.nodeColor == BLACK))
    {
        Node parent = D.parent;
        root = replaceNode(root,D,C);
        if(C != null)
        {
            parent = C.parent;
        }

        if(C == root)
        {
            //Sub Case 3.1 : C is the new root
            return root;
        }

        while (C != root && (C == null || C.nodeColor == BLACK))
        {
            //Sub Case 3.2 :  C is the left child of P
            //                Sibling(S) of C is red
            if(parent.lchild == C && (parent.rchild != null && parent.rchild.nodeColor == RED ))
            {

                parent.rchild.nodeColor = BLACK;
                parent.nodeColor = RED;
                root = rotateLeft (root,parent);
            }

            //Sub Case 3.3 :  i) C is the left child of P
            //               ii) P, S and S’s children are black
            if(parent.lchild == C && parent.nodeColor == BLACK)
            {
                    Node sibling = parent.rchild;
                    if(sibling != null && sibling.nodeColor == BLACK)
                    {
                        if((sibling.lchild == null || sibling.lchild.nodeColor == BLACK) && (sibling.rchild == null || sibling.rchild.nodeColor == BLACK))
                        {
                            //Repaint S red
                            sibling.nodeColor = RED;
                            C = parent;
                            parent = C.parent;
                        }
                    }
            }


            //Sub Case 3.4 :  i) C is the left child of P
            //               ii) S and S's children are black, but P is red
            if(parent.lchild == C && parent.nodeColor == RED)
            {
                Node sibling = parent.rchild;
                if(sibling != null && sibling.nodeColor == BLACK)
                {
                    if((sibling.lchild == null || sibling.lchild.nodeColor == BLACK) && (sibling.rchild == null || sibling.rchild.nodeColor == BLACK))
                    {
                        //Swap the colours of Sibling and Parent
                        int temp = sibling.nodeColor;
                        sibling.nodeColor  = parent.nodeColor;
                        parent.nodeColor = temp;
                    }
                }
            }

            //Sub Case 3.5 : i) C is the left child of P
            //              ii) S is black, S's left child is red, S's right child is black
            if(parent.lchild == C)
            {
                Node sibling = parent.rchild;
                if(sibling != null && sibling.nodeColor == BLACK)
                {
                    if((sibling.lchild != null && sibling.lchild.nodeColor == RED) && (sibling.rchild == null || sibling.rchild.nodeColor == BLACK))
                    {
                        int temp;
                        root = rotateRight (root , sibling);
                        temp = sibling.nodeColor;
                        sibling.nodeColor  = sibling.parent.nodeColor;
                        sibling.parent.nodeColor = temp;
                    }
                }
            }

            //Sub Case 3.6 : i) C is the left child of P
            //              ii) S is black, S's right child is red
            if(parent.lchild == C)
            {
                Node sibling = parent.rchild;
                if(sibling != null && sibling.nodeColor == BLACK)
                {
                    if(sibling.rchild != null && sibling.rchild.nodeColor == RED)
                    {
                        int temp;
                        root = rotateLeft(root , parent);
                        temp = sibling.nodeColor;
                        sibling.nodeColor  = parent.nodeColor;
                        parent.nodeColor = temp;
                        sibling.rchild.nodeColor = BLACK;
                    }
                }
            }

            /***************************************************************************/
            /***************************************************************************/
            //Sub Case 3.7 :  C is the right child of P
            //                Sibling(S) of C is red
            if(parent.rchild == C && (parent.lchild != null && parent.lchild.nodeColor == RED ))
            {
                parent.rchild.nodeColor = BLACK;
                parent.nodeColor = RED;
                root = rotateRight(root,parent);
            }

            //Sub Case 3.8 :  i) C is the right child of P
            //               ii) P, S and S’s children are black
            if(parent.rchild == C && parent.nodeColor == BLACK)
            {
                    Node sibling = parent.lchild;
                    if(sibling != null && sibling.nodeColor == BLACK)
                    {
                        if((sibling.lchild == null || sibling.lchild.nodeColor == BLACK) && (sibling.rchild == null || sibling.rchild.nodeColor == BLACK))
                        {
                            //Repaint S red
                            sibling.nodeColor = RED;
                            C = parent;
                            parent = C.parent;
                        }
                    }
            }


            //Sub Case 3.9 :  i) C is the right child of P
            //               ii) S and S's children are black, but P is red
            if(parent.rchild == C && parent.nodeColor == RED)
            {
                Node sibling = parent.lchild;
                if(sibling != null && sibling.nodeColor == BLACK)
                {
                    if((sibling.lchild == null || sibling.lchild.nodeColor == BLACK) && (sibling.rchild == null || sibling.rchild.nodeColor == BLACK))
                    {
                        //Swap the colours of Sibling and Parent
                        int temp = sibling.nodeColor;
                        sibling.nodeColor  = parent.nodeColor;
                        parent.nodeColor = temp;
                    }
                }
            }

            //Sub Case 3.10 : i) C is the right child of P
            //              ii) S is black, S's right child is red, S's left child is black
            if(parent.rchild == C)
            {
                Node sibling = parent.lchild;
                if(sibling != null && sibling.nodeColor == BLACK)
                {
                    if((sibling.rchild != null && sibling.rchild.nodeColor == RED) && (sibling.lchild == null || sibling.lchild.nodeColor == BLACK))
                    {
                        int temp;
                        root = rotateLeft(root , sibling);
                        temp = sibling.nodeColor;
                        sibling.nodeColor  = sibling.parent.nodeColor;
                        sibling.parent.nodeColor = temp;
                    }
                }
            }

            //Sub Case 3.11 : i) C is the right child of P
            //              ii) S is black, S's left child is red
            if(parent.rchild == C)
            {
                Node sibling = parent.lchild;
                if(sibling != null && sibling.nodeColor == BLACK)
                {
                    if(sibling.lchild != null && sibling.lchild.nodeColor == RED)
                    {
                        int temp;
                        root = rotateRight(root , parent);
                        temp = sibling.nodeColor;
                        sibling.nodeColor  = parent.nodeColor;
                        parent.nodeColor = temp;
                        sibling.lchild.nodeColor = BLACK;
                    }
                }
            }
        } //while ends
    }
        C.nodeColor = BLACK;
        return root;
}
public static void main(String args[])
	{
             Node root = null;
        Scanner sc = new Scanner(System.in);
        int choice, elt;
        do {
            System.out.println("1.Insert an element\n2.Delete an Element\n3.InOrder Traversal ");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    root=Insert_BST(root, elt);
                    break;
                case 2:
                	System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    root=Delete_BST(root, elt);
                    break;
                case 3:
                    inorder(root);
            }
        } while (choice <= 3);
	}

}