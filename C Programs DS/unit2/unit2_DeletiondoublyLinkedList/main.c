#include <stdio.h>

#include<stdlib.h>

struct node          //creation of structure
{
    int value;
    struct node*next;
    struct node*prev;
}*current,*start,*start1,*a,*previous;
struct node* create_node()     // function to create a node
{
    current=(struct node*)malloc(sizeof(struct node));
    printf("\n Enter the integer \n");
    scanf("%d", &current->value);

    current->next=NULL;
    current->prev=NULL;

    return current;
};
void display(struct node*start)        // display function begins
{

   a=start;
    printf("\n\t**** DISPLAY*****\n");
    do
    {

        printf("\n address: %p\t",a);
printf(" value: %d \t",a->value);

        printf("  previous: %p\t",a->prev);
        printf(" next:%p\t",a->next);

        a=a->next;


    }while(a!=NULL);

return;
}                                         // display function ends
void deletion(struct node*start,int data)    // deletion function
{

    if(start==NULL)
    {
        printf("\n empty");       // if there is no list
    }
    current=start;
    previous=start;
    while(current!=NULL)
    {
        if(current->value==data)      //if the node pointed by current is to be deleted
        {
            if(current==start)        // if the first node is to be deleted
            {


            start=current->next;
            start->prev=NULL;
            printf("\n node deleted");
            free(current);

        display(start);
        return;
        }
        else
        {
            previous->next=current->next;
        if(current->next!=NULL)       // if not the last node
        {
            (current->next)->prev=previous;
        }
        printf("\n deleted");
        free(current);
        display(start);
        return;
    }
}
else
{
    previous=current;
    current=current->next;
}
}

}                                  // deletion function ends
int main()
{
    int a,b;                         // creation of doubly list begins

 printf("\n \t\t*******INSERTION*******\n");
   current=create_node();

   start=current;
   start1=current;
   do
   {


   printf("\nPress 1 to add node 0 to exit\n");
   scanf("%d",&a);
   if(a==1)
   {



   current=create_node();

   start1->next=current;
   current->prev=start;

   start1=current;
   }

   }while(a!=0);
   display(start);
   printf("\n\t\t***** DELETION******\n");
   do
   {// creation of doubly list ends
   int data;
   printf("\n Press 1 to delete and 0 to exit\n");
   scanf("%d",&b);
   if(b==1)
   {// deletion begins
   printf("\n Enter the element to be deleted\n");
   scanf("%d",&data);
   deletion(start,data);
  //display(start);
   //printf("hiii");
   }
   }while(b!=0);
              // the deletion ends
   return 0;
}

