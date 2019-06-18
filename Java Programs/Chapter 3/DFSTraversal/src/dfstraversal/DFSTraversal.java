
package dfstraversal;

import java.util.*;

public class DFSTraversal {

    public static void DFSTraversal(int AdjMat[][], int n) {
        
        // Possible States are 0,1,2. 0-Not Visited. 1-Added to Queue. 2-Visited
        Stack<Integer> q = new Stack<Integer>();
        int State[] = new int[n];
        int DFS[] = new int[n];
        LinkedList<Integer> nd=new LinkedList<Integer>();
        for(int i=0;i<n;i++)
            nd.add(i);
        int i = 0, top_vertex;
        q.add(i);
        State[i] = 1;
        while (!q.isEmpty()) {
            top_vertex = q.pop();
            System.out.print(top_vertex+"\t");
            if(!nd.isEmpty())
            nd.removeFirstOccurrence(top_vertex);
            DFS[i] = top_vertex;
            i++;
            State[top_vertex] = 2;
            for (int j = 0; j < n; j++)
                if (AdjMat[top_vertex][j] != 0 && !(State[j]==1 || State[j]==2)) {
                    q.push(j);
                    State[j] = 1;
                }
            if(q.isEmpty() && !nd.isEmpty())
                q.add(nd.removeFirst());

        }
    System.out.println("\n Vertices traversed using DFS:");
        for (i = 0; i < n; i++) {
            System.out.print(" "+(DFS[i]+1));
        }
	}

    public static void main(String[] args) {
        int n;
        int AdjMat[][];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices :");
        n = sc.nextInt();
        System.out.println("Enter the Adjacency Matrix in matrix form:");
        AdjMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AdjMat[i][j] = sc.nextInt();
            }
        }
        System.out.println("Adjacency Matrix ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(AdjMat[i][j] + "   ");
            }
            System.out.println("\n");
        }
        DFSTraversal(AdjMat, n);

	}
    }

