#include<stdio.h>
 #include<conio.h>
 #include<stdlib.h>
 struct Node
 {
        int Data;
        struct Node* next;
 }*rear=NULL, *front=NULL;

void deQueue()
{
      struct Node *temp, *var=front;
      if(rear!=front)
      {
             front = front->next;
             free(var);
      }
      else if(front==NULL)
        printf("\nQueue Empty");
      else if(rear==front)
      {
            rear=front=NULL;
            free(var);
      }



}

void enQueue(int value)
{
     struct Node *temp;
     temp=(struct Node *)malloc(sizeof(struct Node));
     temp->Data=value;
     if (rear == NULL)
     {
           rear=temp;
           rear->next=NULL;
           front=rear;
     }
     else
     {
           rear->next=temp;
           rear=temp;
           rear->next=NULL;
     }
}

void display()
{
     struct Node *var=front;
     if(var!=NULL)
     {
        printf("\nElements are :  ");
        do
           {
                printf("\t%d",var->Data);
                var=var->next;
           }while(var!=NULL);
     printf("\n");
     }
     else
     printf("\nQueue is Empty");
}

int main()
{
     int ch=0;
     front=NULL;
     printf(" \n1. Insert to Queue");
     printf(" \n2. Remove from Queue");
     printf(" \n3. Display Data of Queue");
     printf(" \n4. Exit\n");
     while(1)
     {
          printf(" \nChoose Option: ");
          scanf("%d",&ch);
          switch(ch)
          {
                case 1:
                {
                     int value;
                     printf("\nEnter a value to insert into the Queue: ");
                     scanf("%d",&value);
                     enQueue(value);
                     display();
                     break;
                }
                case 2:
                {
                     deQueue();
                     display();
                     break;
                }
                case 3:
                {
                     display();
                     break;
                }
                case 4:
                {
                     exit(0);
                }
                default:
                {
                     printf("\nwrong choice for operation");
                }
          }
     }
}
