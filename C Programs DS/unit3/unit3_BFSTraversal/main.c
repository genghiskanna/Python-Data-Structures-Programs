#include<stdio.h>
#include<conio.h>
#define SIZE 10

int queue[SIZE], rear=-1, front=-1, item;

void insert(int item)
{
if((front==0 && rear==SIZE-1) || (front==rear+1))
    printf("\n\nQueue is full.");
else
{
    if(rear ==-1)
    {
        rear = 0;
        front = 0;
    }
    else if(rear == SIZE-1)
        rear = 0;
    else
        rear++;
    queue[rear] = item;
    printf("\n\nItem inserted: %d\n", item);
}
}

int delet()
{
if(front ==-1)
    printf("\n\nQueue is empty.\n");
else
{
    item = queue[front];
    if(front == rear)
    {
        front =-1;
        rear =-1;
    }
else if(front == SIZE-1)
    front = 0;
else
    front++;
return(item);
}
}

int isEmpty()
{
    if(front == -1)
        return 1;
    return 0;
}

void BFSTraversal(int AdjMat[10][10], int n) {
        int State[10],BFS[10],i=0, j, front_vertex,flag=0;
        // Possible States are 0,1,2. 0-Not Visited. 1-Added to Queue. 2-Visited
        for ( j = 0; j < n; j++)
            State[j]=0;
        insert(0);
        State[0] = 1;
        do
        {
          while (isEmpty() == 0) {
            front_vertex = delet();
            printf("BFS : %d\t",front_vertex);
            BFS[i] = front_vertex;
            i++;
            State[front_vertex] = 2;
            for ( j = 0; j < n; j++)
            {
                if (AdjMat[front_vertex][j] != 0 && !(State[j]==1 || State[j]==2)) {
                    printf("In queue : %d",j);
                    insert(j);
                    State[j] = 1;
                }

            }
        }
        for(j=0;j<n;j++)
        {
            if(State[j] == 0)
            {
                insert(j);
                State[j]=1;
                flag=0;
                break;
            }
            else{
                flag=1;
            }
        }
        }while(flag!=1);
        printf("\n Vertices traversed using BFS:");
        for (i = 0; i < n; i++) {
            printf(" %d ",(BFS[i]+1));
        }
    }
int main()
{
 int n,i,j;
	    int AdjMat[10][10];


        printf("Enter the no. of Vertices :");
        scanf("%d",&n);

        printf("Enter the Adjacency Matrix:");
        for ( i = 0; i < n; i++)
            for ( j = 0; j < n; j++)
                scanf("%d",&AdjMat[i][j]);
        printf("Adjacency Matrix ");
        for ( i = 0; i < n; i++) {
            printf("\n");
            for ( j = 0; j < n; j++) {
                printf(" %d ",AdjMat[i][j]);
		}
			printf("\n");
	}
    BFSTraversal(AdjMat,n);
}
