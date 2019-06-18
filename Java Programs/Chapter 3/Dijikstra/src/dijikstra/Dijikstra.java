
package dijikstra;

import java.util.*;

public class Dijikstra {

public static void Dijkstra(int n,int v,int cost[][],int dist[])
{
 int i,u=0,count,w,min;
 boolean flag[]= new boolean[n];
 for(i=0;i<n;i++)
 {
    flag[i]=false;
    dist[i]=cost[v][i];
 }
 count=2;
 while(count<n)
 {
  min=99;
  for(w=0;w<n;w++)
   if((dist[w]<min) && !(flag[w]))
   {
    min=dist[w];
    u=w;
   }
  flag[u]=true;
  count++;
  for(w=0;w<n;w++)
   if((dist[u]+cost[u][w]<dist[w]) && !flag[w])
    dist[w]=dist[u]+cost[u][w];
 }
	}
    
    public static void main(String[] args) {
        int n,v;
		int COST[][];

		Scanner sc = new Scanner(System.in);
                System.out.println("Enter the number of vertices : ");
		n = sc.nextInt();
		COST = new int[n][n];
                System.out.println("Enter the cost matrix : ");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				COST[i][j] = sc.nextInt();
		System.out.println("Cost Matrix(Enter large numbers for infinity) ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(COST[i][j] + "   ");

			}
			System.out.println("\n");
		}
		int dist[]=new int[n];
                System.out.println("\n Enter the source vertex(0 to n-1):");
                v = sc.nextInt();
		 Dijkstra(n,v,COST,dist);
		 System.out.println("\n Shortest path:\n");
		 for(int i=0;i<n;i++)
		    System.out.println(v+" to "+i+" :"+dist[i]);
	}
    }


