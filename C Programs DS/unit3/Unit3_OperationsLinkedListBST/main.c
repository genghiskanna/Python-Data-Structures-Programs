// Program to insert and delete elements in a BST and to display the elements by iterative preorder traversal.

// root is a pointer to the root node of the linked list.
// data holds the data part of a node in the linked list.
// lchild stores the address of the left child in the node of the linked list.
// rchild stores the address of the right child in the node of the linked list.
// The current node being visited is stored in Node.
// STACK is a stack, represented using an array of size ‘n’ that stores addresses of the nodes.
// top holds the subscript of the top element of the stack.
// ‘element’ is the element to the inserted or deleted in the data part of the node.
// GetNode() is a function that creates a node with a data part and 2 address parts and assigns null in the address parts.
//  Node_inserted_flag stores the status of the insertion
// temp is used to find the address of the element (node) to be deleted.
// parent stores the address of the parent of the element (node) to be deleted.
// inorder_successor is the inorder successor of the node to be deleted.
// parent_inorder_successor  is the parent of the inorder successor.
// newNode is used to create a new node.

#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *lchild,*rchild;
};

void Preorder_iterative(struct node *);
int Insert_LinkedList_BST(struct node **,int);
void Delete_LinkedList_BST(struct node **,int);
void Push(struct node **,int,int *,struct node *);
struct node * Pop(struct node **,int,int *);
struct node * GetNode();

struct node * GetNode()
{
    struct node *newNode=(struct node *)malloc(sizeof(struct node));
    newNode->lchild=newNode->rchild=NULL;
    return newNode;
}

void Push(struct node **STACK,int n,int *top,struct node *root)
{
    (*top)++;
    if(*(top)>=n)
    {
        puts("\nOverflow");
        (*top)--;
        return;
    }
    *(STACK+*top)=(root);
}

struct node * Pop(struct node **STACK,int n,int *top)
{
    if(*top==-1)
    {
        puts("\nUnderflow");
        return NULL;
    }
    (*top)--;
    return *(STACK+*top+1);
}

void Preorder_iterative(struct node *root)
{
    struct node *STACK[50];//Declaration of stack of 50 elements
    int n=50,top;
    if (root==NULL)// Empty tree
    {
        return;
    }
    else
    {
        top=-1; // Initialise the top pointer of a stack to store addresses of nodes traversed
        Push (STACK, n, &top, root); // Assume array implementation of stack
     }
    while (top>=0)
    {
        struct node *Node=Pop (STACK, n, &top); // temporary area to process the current node
        while (Node!=NULL)
        {
            printf("\t%d",Node->data); // Display the visited node
            if ( Node->rchild != NULL)
            {
                Push (STACK, n, &top, Node->rchild); // Store address of right child
            }
            Node=Node->lchild;  // Traverse the left child
        }
    }
}

int Insert_LinkedList_BST(struct node **root,int element)
{
    int Node_inserted_flag;
    struct node *temp=*root; // Always check from the root the position to insert the new element or node
    if(*root==NULL) //inserting the first node
    {
        *root=GetNode();
        (*root)->data=element;
        Node_inserted_flag=1;
        return Node_inserted_flag;
    }
    Node_inserted_flag=0; //flag to indicate if the element is inserted in the BST
    while(Node_inserted_flag==0)// Repeat till an appropriate empty position is found
    {
        if(temp->data==element)
        {
            puts("\nDuplicate value found!Node cannot be inserted");
            Node_inserted_flag=-1;//Indication of exception
        }
        else
        {
            if(temp->data>element)
            {
                if(temp->lchild==NULL) // There is no left child
                {
                    temp->lchild=GetNode(); // Create the left child
                    temp->lchild->data=element; // Insert as the left child
                    Node_inserted_flag=1;// Successful insertion
                }
                else // The left child is occupied
                {
                    temp=temp->lchild; // Move to the left child
                }
            }
            else // The element is greater than the node value
            {
                if(temp->rchild==NULL) // There is no right child
                {
                    temp->rchild=GetNode(); // Create the right child
                    temp->rchild->data=element; // Insert as the right child
                    Node_inserted_flag=1; // Successful insertion
                }
                else // The right child is occupied
                {
                    temp=temp->rchild; //Move to the right child
                }
            }
        }
    }
    return Node_inserted_flag;
}

void Delete_LinkedList_BST(struct node **root,int element)
{
    struct node *temp=*root; // Start at the root node
    struct node *parent=*root; // Root node does not have a parent
    while(temp!=NULL&&element!=temp->data)
    {
        // Loop until the node is found
        parent=temp; // change the parent pointer before traversing further
        if(element<temp->data)
        {
            temp=temp->lchild;// Traverse to the left
        }
        else
        {
            temp=temp->rchild;// Traverse to the right
        }
    }
    if (temp==NULL)
    {
        puts("\nElement to be deleted is not found");
        return;
    }
    // Case 1 – Deletion of a leaf node
    if(temp->lchild==NULL&&temp->rchild==NULL) // Leaf node indicator
    {
        if(parent==temp) // The tree has only one node
        {
            *root=NULL;
        }
        else
        {
            if(temp==parent->lchild) // The node to be deleted is the left child of the parent
            {
                parent->lchild=NULL;
            }
            else
            {
                parent->rchild=NULL;
            }
        }
    }
    // Case 2 – Deletion of a  node with one subtree
    else
    {
        if(temp->lchild==NULL||temp->rchild==NULL)
        // Either one subtree is absent
        {
            if(parent==temp) // The root node is to be deleted
            {
                if(temp->lchild!=NULL) // The subtree is to the left of the root
                {
                    *root=temp->lchild;
                }
                else
                {
                    *root=temp->rchild;
                }
            }
            else // Handle four possible cases of deletion
            {
                if(temp==parent->lchild) // The node to be deleted is to the left of the parent
                {
                    if(temp->lchild!=NULL) // The node to be deleted has a left child
                    {
                        parent->lchild=temp->lchild;
                    }
                    else
                    {
                        parent->lchild=temp->rchild;
                    }
                }
                else // The node to be deleted is to the right of the parent
                {
                    if(temp->lchild!=NULL) // The node to be deleted has a left child
                    {
                        parent->rchild=temp->lchild;
                    }
                    else
                    {
                        parent->rchild=temp->rchild;
                    }
                }
            }
        }
        //Case 3 – Deletion of node with both the subtrees
        else// Locate the inorder successor and its parent for reference
        {
            struct node *parent_inorder_successor=temp; // Start from the node to be deleted
            struct node *inorder_successor=temp->rchild; // Inorder successor is surely in the right subtree
            while(inorder_successor->lchild!=NULL)
            {
                parent_inorder_successor=inorder_successor;
                inorder_successor=inorder_successor->lchild;
            }
            temp->data=inorder_successor->data; // Replace with inorder successor
            if(temp!=parent_inorder_successor)
            {
                parent_inorder_successor->lchild=inorder_successor->rchild;
            }
            else
            {
                parent_inorder_successor->rchild=inorder_successor->rchild;
            }
            temp=inorder_successor;
        }
    }
    free(temp); // Release the space utilised by the deleted node
    return;
}

int main()
{
    int choice,element,Node_inserted_flag;
    struct node *root=NULL;
    while(1)
    {
        puts("\n1.Insert an element\n2. Delete an element\n3. Display the preorder traversal of the tree\n4. Exit\n Enter your choice:");
        scanf("%d",&choice);
        switch(choice)
        {
        case 1:
            puts("\nEnter the element to be inserted:");
            scanf("%d",&element);
            Node_inserted_flag=Insert_LinkedList_BST(&root,element);
            if(Node_inserted_flag==1)
            {
                puts("\nPreorder traversal of tree:\n");
                Preorder_iterative(root);
            }
            break;
        case 2:
            if(root!=NULL)
            {
                puts("\nEnter the element to be deleted:");
                scanf("%d",&element);
                Delete_LinkedList_BST(&root,element);
                Preorder_iterative(root);
            }
            else
            {
                puts("\nEmpty tree!");
            }
            break;
        case 3:
            puts("\nPreorder traversal of tree:\n");
            Preorder_iterative(root);
            break;
        case 4:
            exit(0);
        default:
            puts("\nInvalid choice!");
        }
    }
    return 0;
}
