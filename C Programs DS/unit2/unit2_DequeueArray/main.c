#include <stdio.h>
#include<stdlib.h>
#include<stdio.h>
void enqueue_right(int* arr,int *left,int *right,int x,int n);
void enqueue_left(int* arr,int *left,int *right,int x,int n);
int dequeue_left(int* arr,int *left,int *right,int n);
int dequeue_right(int* arr,int *left,int *right,int n);
void display(int *l,int *r,int* arr,int n);

void enqueue_right(int *arr,int *left,int *right,int x,int n)
{
    if(((*left==1)&&(*right==n)||(*left-1==*right)))
        {printf("\n\noverflow......");return;}
    else if(*left==0)
    {
*left=*right=1;
    }
    else if(*right==n)
    {
        *right=1;
    }
    else
    {
        *right=*right+1;

    }
       arr[*right]=x;
}
void enqueue_left(int *arr,int *left,int *right,int x,int n)
{
    if(((*left==1)&&(*right==n)||(*left-1==*right)))
        {printf("\n\noverflow......");return;}
    else if(*left==0)
    {
    *left=*right=1;
    }
    else if(*left==1)
    {
        *left=n;
    }
    else
    {
        *left=*left-1;

    }
    printf("left: %d",*left);
       arr[*left]=x;
}
int dequeue_left(int *arr,int *left,int *right,int n)
{
    int elt;
    if(*left==0)
    {
        printf("\n\nunderflow");
        return -1;
    }
     else if(*left==*right)
    {
        elt=arr[*left];
        *left=*right=0;
    }
    else if(*left==n)
    {elt=arr[*left];

        *left=1;
    }
    else
    {elt=arr[*left];

        *left=*left+1;
 }       return elt;

}

int dequeue_right(int *arr,int *left,int *right,int n)
{
    int elt;
    if(*left==0)
    {
        printf("\n\nunderflow");
        return -1;
    }
     else if(*left==*right)
    {
        elt=arr[*right];

        *left=*right=0;
    }
    else if(*right==1)
    {elt=arr[*right];

        *right=n;
    }
    else
    {elt=arr[*right];

        *right=*right-1;
 }       return elt;

}

void display(int *l,int *r,int *arr,int n)
{
    int i;
    printf("l: %d r:%d",*l,*r);
    if(*l == *r && *l == 0)
    {
        printf("\nQueue is empty");
        return;
    }

    printf("\n\n the elements of the queue are");
   if(*l<=*r)
    for(i=*l; i<=*r; i++)
    {
        printf(" %d %d\n",i,arr[i]);
    }
    else
    {
        for(i=1;i<=*r;i++)
              printf(" %d %d\n",i,arr[i]);
        for(i=n;i>=*l;i--)
              printf(" %d %d\n",i,arr[i]);
    }
}
int main()
{
    int arr[20],left=0,right=0,n=11;
    int ch;
    int element;
    int z,t;
    printf("\n\t*****DEQUE*****");
    do
    {
        printf("\n1.enqueue left");
        printf("\n2.enqueue right");
        printf("\n3.dequeue left");
        printf("\n4.dequeue right");
        printf("\n5.display the queue");
        printf("\n\nenter your choice....");
        scanf("%d",&ch);
        switch(ch)
        {
        case 1:
            printf("\n\nenter an element to be inserted at left");
            scanf("%d",&element);
            enqueue_left(arr,&left,&right,element,n);
            break;
        case 2:
            printf("\n\nenter an element to be inserted at right");
            scanf("%d",&element);
            enqueue_right(arr,&left,&right,element,n);
            break;
        case 3:
            z=dequeue_left(arr,&left,&right,n);
            if(z==-1)
            {
                printf("\n\nqueue is empty");
            }
            else
            {
                printf("\n\ndeleted element is %d",z);
            }
            break;
        case 4:
            z=dequeue_right(arr,&left,&right,n);
            if(z==-1)
            {
                printf("\n\nqueue is empty");
            }
            else
            {
                printf("\n\ndeleted element is %d",z);
            }
            break;
        case 5:
            display(&left,&right,arr,n);
            break;
        }
      }while(ch<=5);
    return 0;
}
