#include<stdio.h>
int a,b,u,v,n,i,j,ne=1;
int visited[10]={0},min,mincost=0,cost[10][10];
int main()
{
printf("\nEnter the number of nodes:");
scanf("%d",&n);
printf("\nEnter the cost matrix:\n");
for(i=1;i<=n;i++)
    for(j=1;j<=n;j++)
    {
        scanf("%d",&cost[i][j]);
        if(cost[i][j]==0)
            cost[i][j]=999;
    }
    visited[1]=1;
    printf("\n");
    while(ne < n)
    {
        for(i=1,min=999;i<=n;i++)
            for(j=1;j<=n;j++)
                if(cost[i][j]< min){
                    printf("\nmin:%d %d\n",min,cost[i][j]);
                    if(visited[i]!=0)
                    {
                        min=cost[i][j];
                        printf("\nmin:%d\n",min);
                        a=u=i;
                        b=v=j;
                    }
        printf("%d %d %d %d",a,b,u,v);
                    if(visited[u]==0 || visited[v]==0)
                    {
                        printf("\n Edge %d:(%d %d) cost:%d",ne++,a,b,min);
                        mincost+=min;
                        printf("\nm:%d mi:%d\n",mincost,min);
                        visited[b]=1;
                    }
                    cost[a][b]=cost[b][a]=999;
                }
        }
        printf("\n Minimun cost=%d",mincost);
        return 0;
}
