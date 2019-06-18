// INSERTION AND DELETION ON ARRAY IMPLEMENTATION OF BINARY SEARCH TREE
#include <stdio.h>
#include<math.h>
#include <stdlib.h>
//int NaN=-1;
struct array
{
int TREE[1];
}a;
int Restore_BST_Property(int TREE[sizeof(a.TREE)],int root,int N)
{
       int temp1=floor((root-1)/2);
       int temp=a.TREE[root]; //Replace the parent with inorder successor
       a.TREE[root]=-2; // Mark the node as deleted
       a.TREE[temp1]=temp;
       if((a.TREE[(2*root)+1]!=-2)&&((2*root)+1<N)) // A left child exists for the inorder successor
       {
           Restore_BST_Property(a.TREE[sizeof(a.TREE)],(2*root)+1,N);
       }
       if((a.TREE[2*root+2]!=-2)&&((2*root)+2<N)) // A right child exists for the inorder successor
       {
          Restore_BST_Property(a.TREE[sizeof(a.TREE)],(2*root)+2,N);
       }
       return 0;
}
void display(int TREE[sizeof(a.TREE)],int N)
{
         int i;
         printf("ARRAY ELEMENTS ARE(Empty locations : -2) :\n");
         for(i=0;i<N;i++)
        {
        printf("TREE[%d] : %d \n",i,a.TREE[i]);
        }
}
 int Insert_Array_BST(int TREE[sizeof(a.TREE)],int N)
{
    int temp=0,Node_Inserted_Flag=0,element=0;
    //temp=1;
    printf("\n Enter the element to be insert into the array which represents the tree :\n");
    scanf("%d",&element);
  // printf("%d",n);
    if(a.TREE[temp]==-2)
   {
     a.TREE[temp]=element;
     Node_Inserted_Flag = 1;
     return(Node_Inserted_Flag);
   }
  Node_Inserted_Flag=0;
  while((Node_Inserted_Flag==0)&&(temp<N))
  {
      if(a.TREE[temp]==element)
      {
         printf("\n Duplicate value found. Node cannot be inserted");
         Node_Inserted_Flag = -1;
      }
      else
      {
          if(a.TREE[temp]>element)
          {
              if(a.TREE[2*temp+1]==-2)
              {
                  a.TREE[2*temp+1]=element;
                  Node_Inserted_Flag=1;
              }
              else
              {
                  temp=2*temp+1;
              }
          }
          else
          {
              if(a.TREE[(2*temp)+2]==-2)
              {
                  a.TREE[(2*temp)+2]=element;
                  Node_Inserted_Flag=1;
              }
              else
              {
                  temp=(2*temp)+2;
              }
          }
      }
   }
    if(temp>=N)
    {
    printf("Array out of bound");
    Node_Inserted_Flag=-2;
    }
     return 0;
}
int Delete_Array_BST(int TREE[sizeof(a.TREE)],int N)
{
    int temp=0,inorder_successor=0,element=0;
    //temp=1;
    printf("\n Enter the element to be Delete from the array which represents the tree :\n");
    scanf("%d",&element);
    while((a.TREE[temp]!=element)&&(a.TREE[temp]!=-2)&&(temp<N))
       {
            if(element<a.TREE[temp])
            {
                temp=2*temp+1;
            }
             else
             {
                temp =(2*temp)+2;
             }
        }
        if(temp>=N)
        {
            printf("Array out of bound\n");
            return 0;
        }
        if(a.TREE[temp]==-2)
        {
            printf("Element to be deleted is not found");
            return 0;
        }
        if(a.TREE[temp]!=-2)// If the element is found // Case 1 – Deletion of a leaf node
         {
             if(((2*temp)+2<N)&&((2*temp)+1<N)&&(a.TREE[2*temp+1]==-2)&&(a.TREE[(2*temp)+2]==-2))
             {
                //   if() //Node is a leaf node
                //  {
                    a.TREE[temp]=-2; //Marked as deleted
                //  }
             }
             else if(((2*temp)+2>=N)&&((2*temp)+1>=N))
            {
                    a.TREE[temp]=-2;
            }
            else if((((2*temp)+2)>=N)&&(((2*temp)+1)<N)&&(a.TREE[2*temp+1]==-2)) //Node is a leaf node
            {
               // if
                //  {
                    a.TREE[temp]=-2; //Marked as deleted
                  //}
            }
           else
          {
            if(((2*temp)+1<N)&&(a.TREE[2*temp+1]==-2)||((2*temp)+2<N)&&(a.TREE[(2*temp)+2]==-2))
            {
                if(a.TREE[2*temp+1]!=-2)// The node has left subtree to be managed
                {
                    Restore_BST_Property(a.TREE[sizeof(a.TREE)],(2*temp)+1,N);
                }
                else // The node has right subtree to be managed
                {
                    Restore_BST_Property(a.TREE[sizeof(a.TREE)],(2*temp)+2,N);
                }
            }
            else  if(((2*temp)+1<N)&&(a.TREE[2*temp+1]!=-2)&&(2*temp)+2>=N)
            {
                    Restore_BST_Property(a.TREE[sizeof(a.TREE)],(2*temp)+1,N);
            }
            else if((a.TREE[2*temp+1]!=-2)&&(a.TREE[(2*temp)+2]!=-2)) // Case 3 – Deletion of a node with both left and right subtrees
            {
                if(((2*temp)+2<N)&&(2*temp+1!=-2))
                {
                inorder_successor=(2*temp)+2; // Inorder successor is surely in the right subtree
                }
               else
               {
                   inorder_successor=2*temp+1;
                }
                while((2* inorder_successor+1<N)&&(a.TREE[2* inorder_successor+1]!=-2)) // Locate the inorder successor
                {
                    inorder_successor=2* inorder_successor+1;
                }
                a.TREE[temp]=a.TREE[inorder_successor]; // Replace with inorder successor
                a.TREE[inorder_successor]=-2;
             if(2* inorder_successor+2<N)
             {
               if(a.TREE[2* inorder_successor+2]==-2) // Inorder successor has no child
                {
                    a.TREE[inorder_successor]=-2;
                }
                else // Inorder successor has one child
                {
                    Restore_BST_Property(a.TREE[sizeof(a.TREE)],(2* inorder_successor)+2,N);
                }
             }
          }
        }
    }
}
int main()
{
         char ch;
         int c,i,size_TREE;
         printf("\n Enter the size of the array which represents the tree :\n");
         scanf("%d",&size_TREE);
          a.TREE[size_TREE];
         for(i=0;i<size_TREE;i++)
        {
            a.TREE[i]=-2;
        }
       //    for(i=0;i<size_TREE;i++)
       // {
         //    printf("ARRAY ELEMENTS ARE : %d\n",a.TREE[i]);
       // }
        do
        {
            printf("\n\t\tARRAY IMPLEMENTATION OF BINARY SEARCH TREE OERATIONS:\n");
            printf("--------------------------------------------------------------------------------\n");
            printf("Enter your choice :\n");
            printf("\n\t 1.INSERT \n\t 2.DELETE \n\t 3.DISPLAY ALL ELEMENTS IN BST\n\t 4.EXIT \n");
            scanf("%d",&c);
            /*if(ch==49)
            {
                c=1;
            }
            else if(ch==50)
            {
                c=2;
            }
            else if(ch==51)
            {
                c=3;
            }
            else if(ch==52)
            {
                c=4;
            }
            else
            {
                c=5;
            }*/
            switch(c)
            {
                case 1:
                a.TREE[size_TREE]=Insert_Array_BST(a.TREE[size_TREE],size_TREE);
                break;
                case 2:
                a.TREE[size_TREE]=Delete_Array_BST(a.TREE[size_TREE],size_TREE);
                break;
                case 3:
                display(a.TREE[0],size_TREE);
                break;
                case 4:
                printf("Thank you...\n");
                exit(0);
                default :
                printf("Please choose the correct choice...\n");
              //  break;
            }
        }while(1);
    return 0;
}

