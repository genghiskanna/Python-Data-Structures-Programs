#include<stdio.h>

void display(int a[6][6],int n)
{
    int i,j;
    printf("\n\n");
    for( i=0;i<n;i++)
    {
       for( j=0;j<n;j++)
            printf("%d ",a[i][j]);
        printf("\n");

    }

}

void Floyd(int COST[6][6],int n)
{
    int DISTANCE[6][6], i, j, k;

    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            DISTANCE[i][j] = COST[i][j];
    for(k=0;k<n;k++)
    {
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                DISTANCE[i][j] = minimum(DISTANCE[i][j],DISTANCE[i][k]+DISTANCE[k][j]);
        printf("\nk = %d",k+1);
        display(DISTANCE,n);
    }


}
int minimum(int a1, int b)
{
    if(a1<b)
        return a1;
    else
        return b;
}

void main()
{
    int i,j,n, COST[6][6];
    printf("\n Enter the number of vertices:");
    scanf("%d",&n);
    printf("\n Enter the cost matrix(Enter large numbers for non-existent edges):\n");for(i=1;i<=n;i++)
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
        {
            scanf("%d",&COST[i][j]);
        }
    Floyd(COST,n);

}
