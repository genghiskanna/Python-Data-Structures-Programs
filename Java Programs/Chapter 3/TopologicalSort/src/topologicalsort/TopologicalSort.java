
package topologicalsort;

import java.util.*;
import java.util.Scanner;


public class TopologicalSort {

    public static void TopologicalSort(int AdjMat[][],int n)
	{
		int InDegree[]=new int[n],i,j,k,u,w;
                int status[]=new int[n];//0-unvisited,1-in queue,2-visited
		Queue<Integer> q=new LinkedList<Integer>();
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
                System.out.println("Indegree : ");
                for(i=0;i<n;i++)
			System.out.print(i+" : "+InDegree[i]+", ");
		for(i=0;i<n;i++)
			if(InDegree[i]==0)
				q.add(i);
		
		while(!q.isEmpty())
		{
		u=q.remove();
                status[u]=2;
		System.out.print("\nTopological Sort : ");
                System.out.print((u+1)+"\n");
		for(w=0;w<n;w++)
		{
			if(AdjMat[u][w]>0 && status[w]!=2)
				InDegree[w]--;
			if(InDegree[w]==0 && status[w]==0)
                        {
                            System.out.println("In queue : "+(w+1));
                            status[w]=1;
				q.add(w);
                        }
		}	
                System.out.println("\n\nIndegree : ");
                for(i=0;i<n;i++)
			System.out.print(i+" : "+InDegree[i]+", ");
		}
	}
    
    public static void main(String[] args) {
        int n;
	int AdjMat[][];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Vertices :");
        n = sc.nextInt();
        AdjMat = new int[n][n];
        System.out.println("Enter the Adjacency Matrix:");
	for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
		AdjMat[i][j] = sc.nextInt();
	System.out.println("Adjacency Matrix ");
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			System.out.print(AdjMat[i][j] + "   ");
		}
			System.out.println("\n");
	}
		
	TopologicalSort(AdjMat,n);
		
    }
}
