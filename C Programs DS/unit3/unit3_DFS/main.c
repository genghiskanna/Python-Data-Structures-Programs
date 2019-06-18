#include<stdio.h>

#define SIZE 10

int stack[SIZE], top=-1, item;

void insert(int item)
{
if(top == SIZE-1)
    printf("\n\nQueue is full.");
else
{
    top++;
    stack[top] = item;
    printf("\n\nItem inserted: %d\n", item);
}
}

int delet()
{
if(top ==-1)
    printf("\n\nQueue is empty.\n");
else
{
    item = stack[top];
    top--;
    return(item);
}
}

int isEmpty()
{
    if(top == -1)
        return 1;
    return 0;
}

void DFSTraversal(int AdjMat[10][10], int n) {
        int State[10],DFS[10],i=0, j, front_vertex,flag=0;
        // Possible States are 0,1,2. 0-Not Visited. 1-Added to Queue. 2-Visited
        for ( j = 0; j < n; j++)
            State[j]=0;
        insert(0);
        State[0] = 1;
        do
        {
          while (isEmpty() == 0) {
            front_vertex = delet();
            printf("DFS : %d\t",front_vertex);
            DFS[i] = front_vertex;
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
            printf(" %d ",(DFS[i]));
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
    DFSTraversal(AdjMat,n);
}
