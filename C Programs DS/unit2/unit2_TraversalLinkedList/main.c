//PROGRAM TO TRAVERSE A LINKEDLIST
//VARIABLES USED:
//start-used to point to first node
//current-denotes current node being insertion
//previous-to aid insertion
//create()-function to get new nodes
//display()-to display the linked list

#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node*next;
}*current;
struct node* create(struct node*current)
{
    int x;
    printf("\nEnter the element to be inserted:");
    scanf("%d",&x);
    current->data=x;
    current->next=NULL;
    return current;
}
void Traversal_LinkedList(struct node*start)
{
    current=start;
    printf("Linked List : ");
    while(current!=NULL)
    {
        printf("%d\t",current->data);
        current=current->next;
    }
}
int main()
{
    struct node*start=NULL;
    struct node*current=NULL;
    struct node*previous=NULL;
    int choice;
    do
    {
         current=(struct node*)malloc(sizeof(struct node));
         current=create(current);
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
            printf("\nPress 1 to continue else 2:");
            scanf("%d",&choice);
    }while(choice==1);
    Traversal_LinkedList(start);

    return 0;
}
