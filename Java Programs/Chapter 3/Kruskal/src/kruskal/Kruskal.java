
package kruskal;

import java.util.*;
import java.lang.Math.*;
import java.util.Comparator;

class edge {
	int u, v, cost;

	edge(int x, int y, int z) {
		u = x;
		v = y;
                cost=z;
}
}

class EdgeComparator implements Comparator<edge> {
	@Override
	public int compare(edge x, edge y) {
		if (x.cost < y.cost) {
			return -1;
		} else if (x.cost > y.cost)
			return 1;
		return 0;
	}
}

public class Kruskal {

    public static int FindParent(int ParentSet[],int k)
	{
		if(ParentSet[k]==Integer.MAX_VALUE)
			return k;
		else return FindParent(ParentSet,ParentSet[k]); 
	}
	public static void KruskalMST(int AdjMat[][],int n){
		int i, j, k=1;
		int Cost[][] = new int[n][n];
		Comparator<edge> comparator = new EdgeComparator();
		PriorityQueue<edge> q = new PriorityQueue<edge>(10, comparator);
		LinkedList<edge> MST = new LinkedList<edge>(); // LinkedList to store edges
		int ParentSet[]=new int[n];
		edge e;
		int mincost=0;
		for(i=0;i<n;i++)
		{
			ParentSet[i]=Integer.MAX_VALUE;
			for(j=0;j<=i;j++)
				if(AdjMat[i][j]!=0)
					q.add(new edge(i,j,AdjMat[i][j]));
		}
		while(k<n && !q.isEmpty())
		{
			e=q.remove();
                        if(FindParent(ParentSet,e.u)!=FindParent(ParentSet,e.v))
			{
				MST.add(e);
				if(ParentSet[e.v]==Integer.MAX_VALUE)
                                    ParentSet[e.v]=e.u;
				System.out.println((e.u+1) + " to " + (e.v+1) + " : " + e.cost);
				mincost=mincost+e.cost;
				k++;
			}
		}
		System.out.println("Minimum Cost :"+mincost);
		
	}
    public static void main(String[] args) {
        int n;
		int AdjMat[][];

		Scanner sc = new Scanner(System.in);
                System.out.print("Enter the no. of Vertices :");
		n = sc.nextInt();
		AdjMat = new int[n][n];
                System.out.println("Enter the Cost Matrix:");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
                        {
				AdjMat[i][j] = sc.nextInt();
                                if(AdjMat[i][j]==0)
                                    AdjMat[i][j]=999;
                        }
		System.out.println("Cost Matrix ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(AdjMat[i][j] + "   ");

			}
			System.out.println("\n");
		}
		KruskalMST(AdjMat,n);
    }
}
