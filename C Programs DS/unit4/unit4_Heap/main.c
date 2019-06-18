//program to sort the max_heap
#include<stdio.h>
#include<conio.h>
static int insert_tree=0;//variable for inserting elements in tree
void heapsort(int tree[])//for sorting the tree in ascending order
{
  int iterator;//variable for constructing_heap
   for(iterator=0;iterator<7;iterator++)//constructing max_heap from root element
  {
      construct_heap(tree,iterator);//constructing the normal binary tree into a max heap tree
  }
  printf("\nheap:\n");
  display(tree);
  for(iterator=6;iterator>=0;iterator--)//arranging from last element
  {
      if(tree[iterator]!=-1)
      {
           tree[iterator]=delete_max_heap(tree,iterator);//swapping occurs for arranging in ascending order
      }
  }
  printf("\nreheapify\n");
  display(tree);

}
void construct_heap(int tree[],int eltindex)//constructing the normal binary tree into a max heap tree
{
    int newposition;//variable for checking with parent element
    newposition=eltindex-1;
    while((tree[eltindex] > tree[newposition/2]) &&(eltindex >0 )&&(newposition>=0))//comparing with parents
    {
               swap(&tree[eltindex],&tree[newposition/2]);
              eltindex=(eltindex-1)/2;//for comparing with each parent
               newposition=(eltindex-1)/2;
    }
}
int delete_max_heap(int tree[],int noelement)//swapping occurs for arranging in ascending order
{
    int deleted_elt,newposition;//deleted_elt-variable for restoring the highest number in the heap max tree
    deleted_elt=tree[0];//restoring highest number
    tree[0]=tree[noelement];//arranging in ascending order
    tree[noelement]=-1;//not considering this element for next loop
    newposition=0;//comparing from root element's children
   while (((2*newposition) <  noelement))//checking till the parent's rchild is present(not -1)
    {
            if(tree[(2*newposition)] > tree[(2*newposition+1)])//comparing greatest among lchild and rchild(lchild is greater)
            {
                 if(tree[newposition] < tree[2*newposition])//comparing greatest among parent and lchild(lchild is greater)
                 {
                      swap(&tree[newposition],&tree[(2*newposition)]);//arranging in ascending order
                      newposition =2 * newposition;
                 }
                else//parent is greater
                    break;
            }
           else//rchild is greater
          {
              if(tree[newposition] < tree[2 * newposition + 1])//comparing greatest among parent and rchild(rchild is greater)
                 { swap(&tree[newposition], &tree[2 * newposition + 1]);//arranging in ascending order
                   newposition = 2 * newposition + 1;
                 }
             else//parent is greater
	             break;
          }
}
return deleted_elt;//restoring the greatest element
}
void swap(int *element1,int *element2)
{
    int temp;//temporary variable for swapping
    temp=*element1;//swapping by reference
    *element1=*element2;
    *element2=temp;
}
void insert(int tree[],int element)
{
   {
        tree[insert_tree] = element;//inserting element in the tree
        insert_tree++;//incrementing for next insert
    }
    display(tree);
}
void display(int tree[])
{
    int i;//variable for storing all elements of the tree
    printf("\n");
    for(i=0;i<7;i++)//storing elements in tree
    {
        printf("%d\t",tree[i]);
    }
}
void main()
{
    int k,tree[7],wish,elt;
    for(k=0;k<7;k++)
    {
        tree[k]=-1;
    }
    printf("\ninitial:\n");
    display(tree);
    printf("\ninsert\n1.yes\n2.no");
    scanf("%d",&wish);
    do
    {
    if(wish==1)
    {
        printf("\nelement:");
        scanf("%d",&elt);
        if(insert_tree>=7)
        {
            printf("\nout of bounds\n");
        }
        insert(tree,elt);//inserts the element in the tree
    }
    printf("\ninsert\n1.yes\n2.no");
    scanf("%d",&wish);
    }while(wish==1);
    heapsort(tree);//sorting the tree as max_heap
}


