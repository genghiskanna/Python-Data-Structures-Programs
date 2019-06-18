package prim;

import java.util.Scanner;

public class Prim {

    public static void PrimMST(int AdjMat[][], int source, int n) {
        int i, j, k, visited[] = new int[n], ne = 1, min = Integer.MAX_VALUE, a = 0, b = 0, u = 0, v = 0, mincost = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (AdjMat[i][j] == 0) {
                    AdjMat[i][j] = 999;
                }
            }
        }
        visited[source] = 1;
        System.out.println("\n");
        while (ne < n) {
            for (i = 0, min = 999; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (AdjMat[i][j] < min) {
                        if (visited[i] != 0) {
                            min = AdjMat[i][j];
                            a = u = i;
                            b = v = j;
                        }
                    }
                }
            }
            if (visited[u] == 0 || visited[v] == 0) {
                System.out.println("\n Edge " + ne + " :(" + a + " " + b + ") cost:" + min);
                mincost += min;
                ne++;
                visited[b] = 1;
            }
            AdjMat[a][b] = AdjMat[b][a] = 999;
        }
        System.out.println("\n Minimun cost " + mincost);
    }

    public static void main(String[] args) {
        int n;
        int AdjMat[][];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Vertices :");
        n = sc.nextInt();
        AdjMat = new int[n][n];
        System.out.println("Enter the Cost Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AdjMat[i][j] = sc.nextInt();
            }
        }
        System.out.println("Cost Matrix ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(AdjMat[i][j] + "   ");

            }
            System.out.println("\n");
        }
        System.out.println("Enter the starting vertex(0 to n-1) : ");
        int source = sc.nextInt();
        PrimMST(AdjMat, source, n);
        
    }
}


