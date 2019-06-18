
package floydwarshall;

import java.util.Scanner;


public class FloydWarshall {
public static void display(int a[][],int n)
{
    int i,j;
    System.out.println("\n\n");
    for( i=0;i<n;i++)
    {


       for( j=0;j<n;j++)
            System.out.print(" "+a[i][j]);
        System.out.println("\n");
    }

}

public static void Floyd(int COST[][], int n)
{
    int DISTANCE[][], i, j, k;
    DISTANCE = new int [n][n];

    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            DISTANCE[i][j] = COST[i][j];
    for(k=0;k<n;k++)
    {
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                DISTANCE[i][j] = minimum(DISTANCE[i][j],DISTANCE[i][k]+DISTANCE[k][j]);
        System.out.println("\nk = "+(k+1));
        display(DISTANCE,n);
    }
}
public static int minimum(int a1, int b)
{
    if(a1<b)
        return a1;
    else
        return b;
}

    public static void main(String[] args) {
        int n;
		int COST[][];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Vertices :");
        n = sc.nextInt();
        COST = new int[n][n];
        System.out.println("Enter the Cost Matrix(Enter any large value for non-existent edges):");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				COST[i][j] = sc.nextInt();
		System.out.println("Cost Matrix ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(COST[i][j] + "   ");

			}
			System.out.println("\n");
		}
                Floyd(COST,n);
    }
}
