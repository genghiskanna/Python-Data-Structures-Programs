#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define TRUE 1
#define FALSE 0


#define BLACK 1
#define RED 2


struct Node
{
  int data;
  int nodeColor;
  struct Node *parent,*lchild,*rchild;
};

//function prototypes
void inorder(struct Node*);
struct Node* getGrandParent(struct Node *);
struct Node* getUncle(struct Node *);
struct Node* GetNode(int );
struct Node* Insert_BST(struct Node*,int);
struct Node* checkRedBlackProperties(struct Node *,struct Node *);
struct Node* rotateLeft(struct Node *,struct Node *);
struct Node* rotateRight(struct Node *,struct Node *);
struct Node * Delete_BST(struct Node *, int );
struct Node * Deletion_cases(struct Node *, struct Node *, struct Node *);
struct Node * replaceNode(struct Node *, struct Node *, struct Node *);


int main()
{
        int element,choice,exitFlag = FALSE;
        struct Node *root = NULL;
        //clrscr();
        do
        {
          printf("\n1. Insert\n2. Delete\n3. Inorder\n4. Exit\nChoice : ");
          scanf("%d",&choice);
          fflush(stdin);
          switch(choice)
          {
            case 1 :
                    printf("\nEnter your choice(y/n) : ");
                    while( tolower(getchar()) == 'y')
                    {
                        printf("Enter element to insert : ");
                        scanf("%d",&element);
                        root = Insert_BST(root,element);
                        inorder(root);
                        printf("\nEnter your choice(y/n) : ");
                        fflush(stdin);
                    }
                      break;
            case 2:
                    printf("Enter element to delete : ");
                    scanf("%d",&element);
                    root = Delete_BST(root,element);
                    inorder(root);
                    break;
            case 3:
                    inorder(root);
                    break;
            case 4:
                    exitFlag = TRUE;
                    break;
            default:
                    printf("Invalid option");
          }
        }while(exitFlag == FALSE);
    return 0;
}


void inorder(struct Node* root)
{
	if(root != NULL)
	{
	    inorder(root->lchild);
	    printf("\n%d %d", root->data,root->nodeColor);
	    inorder(root->rchild);
	}
}


struct Node *getGrandParent(struct Node *N)
{
    if ((N != NULL) && (N->parent != NULL))
        return N->parent->parent;
    else
        return NULL;
}

struct Node *getUncle(struct Node *N)
{
    struct Node *G = getGrandParent(N);

    // No grandparent means No uncle
    if (G == NULL)
        return NULL;

    if (N->parent == G->lchild)
        return G->rchild;
    else
        return G->lchild;
}

struct Node* GetNode(int element)
{
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	temp->data = element;
	temp->nodeColor = RED;
	temp->lchild = NULL;
	temp->rchild = NULL;
	temp->parent = NULL;
	return(temp);
}


//BST insertion is performed
struct Node* Insert_BST(struct Node *root,int element)
{
    struct Node *currentNode = root;
    struct Node *parentNode;

    if(root == NULL)
    {
        currentNode = root = GetNode(element);
    }
    else
    {
        while(currentNode != NULL)
        {
            parentNode = currentNode;
            if( element < currentNode->data )
                currentNode = currentNode->lchild;
            else
                currentNode = currentNode->rchild;
        }
        currentNode = GetNode(element);
        if(currentNode->data < parentNode->data)
            parentNode->lchild = currentNode;
        else
            parentNode->rchild = currentNode;
        currentNode->parent = parentNode;
    }
    root = checkRedBlackProperties(root,currentNode);
    return root;
}


struct Node * checkRedBlackProperties(struct Node *root,struct Node *n)
{
    if(n == root)
    {
        //case 1 root node should always be black
        n->nodeColor = BLACK;
        return root;
    }

    if(n->parent->nodeColor == BLACK)
    {
        //case 2: no violation
        return root;
    }
    else
    {
        //case 3: newly inserted node's parent is red ->property 4 violated
        while (n != root && n->parent->nodeColor == RED)
        {
            struct Node *uncle = getUncle(n);
            struct Node *grandParent = getGrandParent(n);
        if (grandParent !=NULL)
        {
            //case 3.1
            if (uncle != NULL && uncle->nodeColor == RED)
            {
                //uncle is RED
                n->parent->nodeColor = BLACK;
                uncle->nodeColor = BLACK;
                grandParent->nodeColor = RED;
                n = grandParent;
            }
            else
            {
                //uncle is BLACK
                if(n->parent == grandParent->lchild)
                {
                    if (n == n->parent->rchild)
                    {
                        //case 3.2:
                        // parent is the left child of granfparent
                        //current node is right child of parent
                        n = n->parent;
                        root = rotateLeft(root,n);
                    }

                    //Case 3.3 :
                    //Parent(P) is the left child of its parent(G).
                    //The current node(N) is the left child of the parent(P) and the uncle(U) is black.

                    n->parent->nodeColor = BLACK;
                    getGrandParent(n)->nodeColor = RED;
                    root = rotateRight(root,getGrandParent(n));
                }
                else
                {
                    //current node's parent is right child of grand parent
                    if (n == n->parent->lchild)
                    {
                        //Case 3.4:
                        //Parent(P) is the right child of its parent(G).
                        //The current node(N) is the left child of the parent(P) and the uncle(U) is black.

                        n = n->parent;
                        root = rotateRight(root,n);
                    }
                    //case 3.5
                    //Parent(P) is the right child of its parent(G).
                    //The current node(N) is the right child of the parent(P) and the uncle(U) is black.

                    n->parent->nodeColor = BLACK;
                    getGrandParent(n)->nodeColor = RED;
                    root = rotateLeft(root,getGrandParent(n));
                }
            }
        }
        }
    }
    root->nodeColor = BLACK;
    return root;
}


struct Node * rotateLeft(struct Node *root,struct Node *nodeToBeRotated)
{
    struct Node *child = nodeToBeRotated->rchild;
    nodeToBeRotated->rchild = child->lchild;
    if (child->lchild != NULL)
        child->lchild->parent = nodeToBeRotated;

    //if (child != NULL)
        child->parent = nodeToBeRotated->parent;

    if (nodeToBeRotated->parent)
    {
        if (nodeToBeRotated == nodeToBeRotated->parent->lchild)
            nodeToBeRotated->parent->lchild = child;
        else
            nodeToBeRotated->parent->rchild = child;
    }
    else
    {
        root = child;
    }

    child->lchild = nodeToBeRotated;
    if (nodeToBeRotated != NULL)
        nodeToBeRotated->parent = child;

    return root;
}


struct Node * rotateRight(struct Node *root,struct Node *nodeToBeRotated)
{
    struct Node *child = nodeToBeRotated->lchild;
    nodeToBeRotated->lchild = child->rchild;
    if (child->rchild != NULL)
        child->rchild->parent = nodeToBeRotated;
    //if (child != NULL)
        child->parent = nodeToBeRotated->parent;
    if (nodeToBeRotated->parent)
    {
        if (nodeToBeRotated == nodeToBeRotated->parent->rchild)
            nodeToBeRotated->parent->rchild = child;
        else
            nodeToBeRotated->parent->lchild = child;
    }
    else
    {
        root = child;
    }
    child->rchild = nodeToBeRotated;
    if (nodeToBeRotated != NULL)
        nodeToBeRotated->parent = child;

    return root;
}



struct Node * Delete_BST(struct Node * root, int key)
{
    // nodes and their roles played
    struct Node *nodeToBeDeleted = root;    //N in algorithm
    struct Node *successor = NULL;     // I and D in algorithm
    struct Node *child = NULL;         // C in algorithm

    //find the node to be deleted
    while(nodeToBeDeleted != NULL)
    {
        if(nodeToBeDeleted->data == key)
            break;
        else
        {
                if(nodeToBeDeleted->data > key)
                    nodeToBeDeleted = nodeToBeDeleted->lchild;
                else
                    nodeToBeDeleted = nodeToBeDeleted->rchild;
        }
    }
    if ( nodeToBeDeleted == NULL)
    {
        printf("Node not found");
        return root;
    }


    //finding the replacement node for the node to be deleted
    if (nodeToBeDeleted->lchild == NULL || nodeToBeDeleted->rchild == NULL)
    {
        // successor has a NULL(BLACK) node as a child
        successor = nodeToBeDeleted;
    }
    else
    {
        // find the inorder successor with a NULL(BLACK) node as a child
        successor = nodeToBeDeleted->rchild;
          while (successor->lchild != NULL)
            successor = successor->lchild;
    }

    // child is successor's only child
    if (successor->lchild != NULL)
        child = successor->lchild;
    else if (successor->rchild != NULL)
        child = successor->rchild;


    if (successor != nodeToBeDeleted)
    {
        //Copy the value of the inorder successor(I) in the node(N) to be deleted
        //Mark I as D and I’s child as C
        nodeToBeDeleted->data = successor->data;
    }

    //Proceed to the cases for deletion
    root = Deletion_cases(root,successor,child);

    //return new root
    return root;
}



struct Node * Deletion_cases(struct Node * root, struct Node * D, struct Node * C)
{
    //Case 1 : D is red
    if(D->nodeColor == RED && (C == NULL || C->nodeColor == BLACK))
    {
        root = replaceNode(root,D,C);
        return root;
    }


    //Case 2 : D is black and C is red
    if(D->nodeColor == BLACK && (C != NULL && C->nodeColor == RED))
    {
        // D is replaced with C
        //Repaint C black
        root = replaceNode(root, D ,C);
        C->nodeColor = BLACK;
        return root;
    }


    //Case 3 : D and C are black
    if(D->nodeColor == BLACK && (C == NULL || C->nodeColor == BLACK))
    {
        struct Node *parent = D->parent;
        root = replaceNode(root,D,C);
        if(C != NULL)
        {
            parent = C->parent;
        }

        if(C == root)
        {
            //Sub Case 3.1 : C is the new root
            return root;
        }

        while (C != root && (C == NULL || C->nodeColor == BLACK))
        {
            //Sub Case 3.2 :  C is the left child of P
            //                Sibling(S) of C is red
            if(parent->lchild == C && (parent->rchild != NULL && parent->rchild->nodeColor == RED ))
            {

                parent->rchild->nodeColor = BLACK;
                parent->nodeColor = RED;
                root = rotateLeft (root,parent);
            }

            //Sub Case 3.3 :  i) C is the left child of P
            //               ii) P, S and S’s children are black
            if(parent->lchild == C && parent->nodeColor == BLACK)
            {
                    struct Node *sibling = parent->rchild;
                    if(sibling != NULL && sibling->nodeColor == BLACK)
                    {
                        if((sibling->lchild == NULL || sibling->lchild->nodeColor == BLACK) && (sibling->rchild == NULL || sibling->rchild->nodeColor == BLACK))
                        {
                            //Repaint S red
                            sibling->nodeColor = RED;
                            C = parent;
                            parent = C->parent;
                        }
                    }
            }


            //Sub Case 3.4 :  i) C is the left child of P
            //               ii) S and S's children are black, but P is red
            if(parent->lchild == C && parent->nodeColor == RED)
            {
                struct Node *sibling = parent->rchild;
                if(sibling != NULL && sibling->nodeColor == BLACK)
                {
                    if((sibling->lchild == NULL || sibling->lchild->nodeColor == BLACK) && (sibling->rchild == NULL || sibling->rchild->nodeColor == BLACK))
                    {
                        //Swap the colours of Sibling and Parent
                        int temp = sibling->nodeColor;
                        sibling->nodeColor  = parent->nodeColor;
                        parent->nodeColor = temp;
                    }
                }
            }

            //Sub Case 3.5 : i) C is the left child of P
            //              ii) S is black, S's left child is red, S's right child is black
            if(parent->lchild == C)
            {
                struct Node *sibling = parent->rchild;
                if(sibling != NULL && sibling->nodeColor == BLACK)
                {
                    if((sibling->lchild != NULL && sibling->lchild->nodeColor == RED) && (sibling->rchild == NULL || sibling->rchild->nodeColor == BLACK))
                    {
                        int temp;
                        root = rotateRight (root , sibling);
                        temp = sibling->nodeColor;
                        sibling->nodeColor  = sibling->parent->nodeColor;
                        sibling->parent->nodeColor = temp;
                    }
                }
            }

            //Sub Case 3.6 : i) C is the left child of P
            //              ii) S is black, S's right child is red
            if(parent->lchild == C)
            {
                struct Node *sibling = parent->rchild;
                if(sibling != NULL && sibling->nodeColor == BLACK)
                {
                    if(sibling->rchild != NULL && sibling->rchild->nodeColor == RED)
                    {
                        int temp;
                        root = rotateLeft(root , parent);
                        temp = sibling->nodeColor;
                        sibling->nodeColor  = parent->nodeColor;
                        parent->nodeColor = temp;
                        sibling->rchild->nodeColor = BLACK;
                    }
                }
            }

            /***************************************************************************/
            /***************************************************************************/
            //Sub Case 3.7 :  C is the right child of P
            //                Sibling(S) of C is red
            if(parent->rchild == C && (parent->lchild != NULL && parent->lchild->nodeColor == RED ))
            {
                parent->rchild->nodeColor = BLACK;
                parent->nodeColor = RED;
                root = rotateRight(root,parent);
            }

            //Sub Case 3.8 :  i) C is the right child of P
            //               ii) P, S and S’s children are black
            if(parent->rchild == C && parent->nodeColor == BLACK)
            {
                    struct Node *sibling = parent->lchild;
                    if(sibling != NULL && sibling->nodeColor == BLACK)
                    {
                        if((sibling->lchild == NULL || sibling->lchild->nodeColor == BLACK) && (sibling->rchild == NULL || sibling->rchild->nodeColor == BLACK))
                        {
                            //Repaint S red
                            sibling->nodeColor = RED;
                            C = parent;
                            parent = C->parent;
                        }
                    }
            }


            //Sub Case 3.9 :  i) C is the right child of P
            //               ii) S and S's children are black, but P is red
            if(parent->rchild == C && parent->nodeColor == RED)
            {
                struct Node *sibling = parent->lchild;
                if(sibling != NULL && sibling->nodeColor == BLACK)
                {
                    if((sibling->lchild == NULL || sibling->lchild->nodeColor == BLACK) && (sibling->rchild == NULL || sibling->rchild->nodeColor == BLACK))
                    {
                        //Swap the colours of Sibling and Parent
                        int temp = sibling->nodeColor;
                        sibling->nodeColor  = parent->nodeColor;
                        parent->nodeColor = temp;
                    }
                }
            }

            //Sub Case 3.10 : i) C is the right child of P
            //              ii) S is black, S's right child is red, S's left child is black
            if(parent->rchild == C)
            {
                struct Node *sibling = parent->lchild;
                if(sibling != NULL && sibling->nodeColor == BLACK)
                {
                    if((sibling->rchild != NULL && sibling->rchild->nodeColor == RED) && (sibling->lchild == NULL || sibling->lchild->nodeColor == BLACK))
                    {
                        int temp;
                        root = rotateLeft(root , sibling);
                        temp = sibling->nodeColor;
                        sibling->nodeColor  = sibling->parent->nodeColor;
                        sibling->parent->nodeColor = temp;
                    }
                }
            }

            //Sub Case 3.11 : i) C is the right child of P
            //              ii) S is black, S's left child is red
            if(parent->rchild == C)
            {
                struct Node *sibling = parent->lchild;
                if(sibling != NULL && sibling->nodeColor == BLACK)
                {
                    if(sibling->lchild != NULL && sibling->lchild->nodeColor == RED)
                    {
                        int temp;
                        root = rotateRight(root , parent);
                        temp = sibling->nodeColor;
                        sibling->nodeColor  = parent->nodeColor;
                        parent->nodeColor = temp;
                        sibling->lchild->nodeColor = BLACK;
                    }
                }
            }
        } //while ends
    }
        C->nodeColor = BLACK;
        return root;
}


struct Node * replaceNode(struct Node * root, struct Node * D, struct Node *C)
{
        // remove D and replace with C
            if (D->parent == NULL)
            {
                // D is the root node
                root = C;
                C->parent = NULL;
                free(D);
                return root;
            }
            if(C != NULL)
            {
                C->parent = D->parent;
            }
            if (D == D->parent->lchild)
                D->parent->lchild = C;
            else
                D->parent->rchild = C;
            free(D);
            return root;
}
