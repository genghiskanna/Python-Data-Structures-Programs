#include <stdio.h>
#include <stdlib.h>
struct node              //creation of structure
{
   int value;
   struct node*previous_address;
   struct node*next_address;
}*start,*current,*newnode,*a;
struct node*getnode()        // function for creating a node
{
    current=(struct node*)malloc(sizeof(struct node));
    return current;
};
void insertion(struct node*start,int data,int item)      //insertion function begins
{
    newnode=getnode();       //create a node and store its address in newnode
    newnode->value=item;     //store the item in the value part
    newnode->previous_address=NULL;  //store NULL in the address part
    newnode->next_address=NULL;
    if(start==NULL)                // the list is empty
    {
        start=newnode;

        return ;                  // the data has been inserted
    }

    current=start;                // the list is not empty

    while(current->next_address!=NULL)    // to search for the node with data in the value part
    {
        if(current->value==data)          // data found
        {
            newnode->next_address=current->next_address;
            newnode->previous_address=current;
            current->next_address=newnode;

            return;                  // data has been inserted
        }
        else
        {
            current=current->next_address;     // move to the next node

        }
    }
    current->next_address=newnode;
    newnode->previous_address=current;      //data present or not not present the list is linked
}                                           //insertion function ends
void display(struct node*start)
{
   a=start;
    printf("\n\t**** DISPLAY*****\n");
    do
    {

        printf("\n address: %p\t",a);
printf(" value: %d \t",a->value);

        printf("  previous: %p\t",a->previous_address);
        printf(" next:%p\t",a->next_address);

        a=a->next_address;


    }while(a!=NULL);


}

int main()
{
    struct node*start;
       int item,data,choice;

   start=NULL;       // initially start is null
   printf("\n\t\t\t ******** DOUBLY LINKED LIST ******\n\n");
   printf("\n FIRST NODE \n");
   start=getnode();
   printf("\n Enter the item \n");

       scanf("%d",&item);
       start->value=item;
       start->previous_address=NULL;
    start->next_address=NULL;
    printf("\n First node created  \n");
   do
   {
       printf("\n Enter the data to be inserted after the existing item...else enter 0 to insert at the end \n");
       scanf("%d",&data);
       printf("\n Enter the new item \n");
       scanf("%d",&item);


       insertion(start,data,item);   // function call to insert the node

       printf("\n Press 1 to continue and 0 to exit \n");
       scanf("%d",&choice);
   }while(choice!=0);
   display(start);
   return 0;
}
