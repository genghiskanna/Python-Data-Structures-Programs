package bfstraversal;

import java.util.*;
import java.lang.Math.*;

import javax.swing.text.html.MinimalHTMLWriter;

//The BFS traversal from the starting vertex 0 is displayed. Nodes not connected to vertex 0 will not be displayed

public class BFSTraversal {

    public static void BFSTraversal(int AdjMat[][], int n) {
        // Possible States are 0,1,2. 0-Not Visited. 1-Added to Queue. 2-Visited
        Queue<Integer> q = new LinkedList<Integer>();
        LinkedList<Integer> nd=new LinkedList<Integer>();
        for(int i=0;i<n;i++)
            nd.add(i);
        int State[] = new int[n];
        int BFS[] = new int[n];
        int i = 0, front_vertex;
        q.add(i);
        State[i] = 1;
        while (!q.isEmpty()) {
            front_vertex = q.remove();
            System.out.print(front_vertex+"\t");
            if(!nd.isEmpty())
            nd.removeFirstOccurrence(front_vertex);
            BFS[i] = front_vertex;
            i++;
            State[front_vertex] = 2;
            for (int j = 0; j < n; j++)
                if (AdjMat[front_vertex][j] != 0 && !(State[j]==1 || State[j]==2)) {
                    q.add(j);
                    State[j] = 1;
                }
            if(q.isEmpty() && !nd.isEmpty())
                q.add(nd.removeFirst());
        }
        System.out.println("\n Vertices traversed using BFS:");
        for (i = 0; i < n; i++) {
            System.out.print(" "+BFS[i]);
        }
    }

    public static void main(String[] args) {
        int n;
        int AdjMat[][];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices :");
        n = sc.nextInt();
        System.out.println("Enter the Adjacency Matrix:");
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
        BFSTraversal(AdjMat, n);

    }
}
