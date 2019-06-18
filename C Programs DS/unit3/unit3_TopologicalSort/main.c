#include<stdio.h>
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
    void TopologicalSort(int AdjMat[10][10],int n)
	{
		int InDegree[10],i,j,k,u,w;
        int status[10];//0-unvisited,1-in queue,2-visited
		for(i=0;i<n;i++)
                {
                    InDegree[i]=0;
                    status[i]=0;
                }
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
				if(AdjMat[i][j]!=0)
					InDegree[j]++;
		}
        printf("Indegree : ");
        for(i=0;i<n;i++)
			printf("%d : %d",i,InDegree[i]);
		for(i=0;i<n;i++)
			if(InDegree[i]==0)
				insert(i);

		while(isEmpty() == 0)
		{
            u=delet();
            status[u]=2;
            printf("\nTopological Sort : ");
            printf("%d\n",(u+1));
		for(w=0;w<n;w++)
		{
			if(AdjMat[u][w]>0 && status[w]!=2)
				InDegree[w]--;
			if(InDegree[w]==0 && status[w]==0)
               {
                    printf("In queue : %d",(w+1));
                    status[w]=1;
                    insert(w);
               }
		}
                printf("\n\nIndegree : ");
                for(i=0;i<n;i++)
                    printf("%d : %d",i,InDegree[i]);
		}
	}

    int main() {
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

	TopologicalSort(AdjMat,n);

    }

