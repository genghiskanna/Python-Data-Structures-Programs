#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
//#include<conio.h>


struct node
{
 int data,height;
 struct node *lchild,*rchild;
};

struct node* GetNode(int);
int GetBalance(struct node*);
struct node* LeftRotate(struct node*);
struct node* RightRotate(struct node*);
int FindMaximum(int,int);
int FindHeight(struct node*);
void inorder(struct node *root);
struct node * Delete_LinkedList_BST(struct node *root,int element);


struct node* Insert(struct node* root, int element)
{
    if (root == NULL)
	return(GetNode(element));

    if (element < root->data)
	root->lchild  = Insert(root->lchild, element);
    else
	root->rchild  = Insert(root->rchild, element);

    //Update height of ancestor node
    root->height = FindMaximum(FindHeight(root->lchild),FindHeight(root->rchild) ) + 1;

    int balance = GetBalance(root);

    /**
     *   if the AVL tree is unbalanced , we check for 4 possible cases
     */

    // LL type rotation
    if (balance > 1 && element < root->lchild->data)
    {
	printf("\nLL type");
	return RightRotate(root);
    }

    // RR type rotation
    if (balance < -1 && element > root->rchild->data)
     {
	 printf("\nRR type");
	 return LeftRotate(root);
     }

    // LR type rotation
    if (balance > 1 && element > root->lchild->data)
    {
	printf("\nLR type");
	root->lchild =  LeftRotate(root->lchild);
	return RightRotate(root);
    }

    // RL type rotation
    if (balance < -1 && element < root->rchild->data)
    {
	printf("\nRL type");
	root->rchild = RightRotate(root->rchild);
	return LeftRotate(root);
    }
    return root;
}


struct node* GetNode(int element)
{
	struct node* temp = (struct node*)malloc(sizeof(struct node));
	temp->data = element;
	temp->height = 1;
	temp->lchild = NULL;
	temp->rchild = NULL;
	return(temp);
}



int FindMaximum(int node1_height,int node2_height)
{
	if(node1_height > node2_height)
		return(node1_height);
	else
		return(node2_height);
}


int GetBalance(struct node* node1)
{
	if(node1 == NULL)
		return(0);
	else
		return(FindHeight(node1->lchild) - FindHeight(node1->rchild));
}



struct node* LeftRotate(struct node *lchildRoot)
{
	struct node *temp1 = lchildRoot->rchild;
    struct node *temp2 = temp1->lchild;
    temp1->lchild = lchildRoot;
    lchildRoot->rchild = temp2;
    lchildRoot->height = FindMaximum(FindHeight(lchildRoot->lchild), FindHeight(lchildRoot->rchild))+1;
    temp1->height = FindMaximum(FindHeight(temp1->lchild),FindHeight(temp1->rchild))+1;
    return temp1;
}


struct node* RightRotate(struct node *rightRoot)
{
	struct node *temp1 = rightRoot->lchild;
	struct node *temp2 = temp1->rchild;

    temp1->rchild = rightRoot;
    rightRoot->lchild = temp2;
    rightRoot->height = FindMaximum(FindHeight(rightRoot->lchild),FindHeight(rightRoot->rchild))+1;;
    temp1->height = FindMaximum(FindHeight(temp1->lchild),FindHeight(temp1->rchild))+1;;
    return temp1;
}


void inorder(struct node* root)
{
	if(root != NULL)
	{
	    inorder(root->lchild);
	printf("\n%d %d", root->data, root->height);
		inorder(root->rchild);
	}
}


int FindHeight(struct node* node1)
{
	if(node1 == NULL)
		return(0);
	else
		return(node1->height);
}

struct node * InorderSuccessor(struct node *inorder_N)
{
  while (inorder_N->lchild != NULL)
	      {
		      // struct node *parent_inorder_N = inorder_N;
		       inorder_N = inorder_N->lchild;
	      }
  return(inorder_N);

}

struct node* Delete_LinkedList_AVL(struct node* root, int element)
{
    struct node * temp;
    if (root == NULL)
	return root;

    if ( element < root->data ) // // Is the node the lchild or right child of the root
	root->lchild = Delete_LinkedList_AVL(root->lchild, element);

    else if( element > root->data)
	root->rchild = Delete_LinkedList_AVL(root->rchild, element);

    else // The element is found
    {
	// Case 1 - Delete leaf node or Case 2 - Delete node with one child
	if( (root->lchild == NULL) || (root->rchild == NULL) )
	{
			 if(root->lchild != NULL) // Is the child in the left of the root
			     temp = root->lchild;
			 else
			      temp = root->rchild;

	    if(temp == NULL) // Case 1 - Delete leaf node
	    {
		temp = root;
		root = NULL;
	    }
	    else // Case 2 - Delete node with one child
	     *root = *temp; // Copy the contents of the non-empty child

	    free(temp);
	}
	else
	{
	    //Case 3 - Delete node with 2 children
	    struct node* temp = InorderSuccessor(root->rchild);

	    // Copy the inorder successor's data to this node
	    root->data = temp->data;

	    // Delete the inorder successor
	    root->rchild = Delete_LinkedList_AVL(root->rchild, temp->data);
	}
    }

    // If the tree had only one node then return
    if (root == NULL)
      return root;

    //Update height of current node
    root->height = FindMaximum(FindHeight(root->lchild), FindHeight(root->rchild)) + 1;

    int balance = GetBalance(root);

    // If this node becomes unbalanced, then there are 4 cases, combining R0 and R1 and L0 nd L-1 respectively

    // R0 or R1 rotation
    if (balance > 1 && GetBalance(root->lchild) >= 0)
     {
	printf("Right Rotate");
        return RightRotate(root);
     }
    // R-1 Rotation
    if (balance > 1 && GetBalance(root->lchild) < 0)
    {
        printf("R-1 rotation");
        root->lchild =  LeftRotate(root->lchild);
        return RightRotate(root);
    }

    // L0 and L-1 Rotation
    if (balance < -1 && GetBalance(root->rchild) <= 0)
    {
	printf("Left Rotate");
	return LeftRotate(root);
    }

    // L1 Rotation
    if (balance < -1 && GetBalance(root->rchild) > 0)
    {
	printf("L1 rotation");
	root->rchild = RightRotate(root->rchild);
	return LeftRotate(root);
    }

    return root;
}


int main()
{
  char choice='n';
  struct node *root=NULL;
  int element,choice1;
  //clrscr();
  while(1)
  {
  printf("\n1. Insert\n2. Delete\n3. Inorder\nChoice : ");
  scanf("%d",&choice1);
  fflush(stdin);
  switch(choice1)
  {
  case 1 :
	printf("\nEnter your choice(y/n) : ");
	  while((choice = tolower(getchar())) == 'y')
	  {
	    printf("Enter element to insert : ");
	    scanf("%d",&element);
	    root = Insert(root,element);
	    inorder(root);
	    printf("\nEnter your choice(y/n) : ");
	    fflush(stdin);
	  }
	  break;
  case 2:
	    printf("Enter element to delete : ");
	    scanf("%d",&element);

	root = Delete_LinkedList_AVL(root,element);
	inorder(root);
	break;
  case 3:
	inorder(root);
	break;
  default:
	exit(0);
  }
  }
  //getch();
}
