//PROGRAM TO DELETE THE NODE IN LINKED LIST
//VARIABLES USED:
//start-points to first node
//current-points to current node being considered
//previous-temporary node for traversal and insertion purpose
//display()-used to display the linked list
//delete_node()-used to delete the node in the linked list
//create()-used to create  node in the linked list
//flag-variable to check if the number to be deleted is present or not
#include <stdio.h>
#include <stdlib.h>

struct node
{
    int x;
    struct node*next;
}*start,*current,*previous;
void create(struct node*current)
{
    printf("\nenter the value:");
    scanf("%d",&current->x);
    current->next=NULL;
    if(start==NULL)
        {
            start=current;
            previous=current;
        }
        else
        {
            previous->next=current;
            previous=current;
        }
}
void display(struct node *start)
{
    if(start==NULL)
    {
        printf("\nList is empty:");
    }
    struct node*current=NULL;
    current=(struct node*)malloc(sizeof(struct node));
    current=start;
    while(current!=NULL)
    {
        printf("\n%d",current->x);
        current=current->next;
    }
}
void delete_node(struct node *start)
{
    int i,flag=1;
    current=(struct node*)malloc(sizeof(struct node));
    current=start->next;
    previous=(struct node*)malloc(sizeof(struct node));
    previous=start;
    printf("\nenter the number to be deleted:");
    scanf("%d",&i);
    if(i==start->x)
    {
        start=start->next;
    }
    else
    while(current!=NULL)
    {
        if(current->x==i)
        {
            previous->next=current->next;
            current=current->next;
            flag=0;
        }
        else
        {
            current=current->next;
            previous=previous->next;
        }
    }
    if(flag==1)
    {
        printf("\nnumber is not found:");
    }
}
int main()
{
    int c;
    do
    {
    printf("\n1.INSERT\n2.DELETE\n3.EXIT");
    printf("\nEnter your choice");
    scanf("%d",&c);
switch(c)
{
    case 1:

        current=(struct node*)malloc(sizeof(struct node));
        create(current);
        break;

   case 2:

        if(start==NULL)
            printf("\nempty linked list\n");
        else
        {
        printf("\nbefore deleting:\n");
        display(start);
        delete_node(start);
        printf("\nafter deleting:\n");
        display(start);

        }
        break;
   case 3:
        exit(0);
   default:
        printf("Invalid choice");
}
    }while(c!=3);

    return 0;
}
