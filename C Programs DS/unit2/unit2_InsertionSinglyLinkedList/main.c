//PROGRAM TO INSERT THE ELEMENT IN LINKED LIST
//VARIABLES USED:
//start-used to point to first node
//current-denotes current node being checked
//new node-points to node being inserted
//get_node()-function to get new nodes
//insert()-to insert the created node into the linked list
//display()-to display the linked list
#include <stdio.h>
#include <stdlib.h>
struct node
{
    int item;
    struct node*next;
};
void create(struct node*newnode)
{
    int x;
    printf("\nenter the element to be inserted:");
    scanf("%d",&x);
    newnode->item=x;
    newnode->next=NULL;
}
struct node * insert(struct node * start,struct node*newnode,struct node*current)
{
    int data;
    if(start==NULL)
    {
        start=newnode;
        current=newnode;
    }
    else
    {
        current=start;
        while(current->next!=NULL)
        {
              if(current->item==data)
              {
                  newnode->next=current->next;
                  current->next=newnode;
                  break;
              }
              else
                {
                    current=current->next;
                }
        }
        if(current->next==NULL)
        {
            current->next=newnode;
        }

    }
    return start;
}
void display(struct node*start)
{
    struct node *current=start;
    while(current!=NULL)
    {
        printf("\t%d",current->item);
        current=current->next;
    }
}
int main()
{
    struct node*start=NULL;
    struct node*newnode=NULL;
    struct node*current=NULL;
    int choice;
    do
    {
        newnode=(struct node*)malloc(sizeof(struct node));
        create(newnode);
        start=insert(start,newnode,current);
        printf("Linked List : ");
        display(start);
        printf("\npress 1 to continue else 2:");
        scanf("%d",&choice);

    }while(choice==1);


    return 0;
}
