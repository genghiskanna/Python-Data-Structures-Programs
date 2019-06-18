//Preorder traversal of a tree represented using arrays

// Tree is the array holding the tree of size N.
// root is the index of the array indicating the beginning of the Tree or the Subtree.
//The empty positions in an array are denoted by 0. So it is a tree of non-zero elements.

#include <stdio.h>

void Preorder(int *,int ,int );

void Preorder(int *TREE,int root,int N)
{
    printf("%d\t",*(TREE+root));
    if (*(TREE+2*root+1)!=0&&2*root+1<N) //Does a left child exist?
    {
        Preorder(TREE,2*root+1,N);
    }
    if (*(TREE+2*root+2)!=0&&2*root+2<N) //Does a right child exist?
    {
        Preorder(TREE,2*root+2,N);
    }
}

int main()
{
    int TREE[20]={0},n,i;//Initially tree is empty
    //Creating the tree
    printf("Enter the no of nodes");
    scanf("%d",&n);
    printf("Enter the elements");
    for(i=0;i<n;i++)
    {
        scanf("%d",&TREE[i]);
    }
    puts("\nPreorder traversal of tree:");
    Preorder(TREE,0,20);
    return 0;
}
