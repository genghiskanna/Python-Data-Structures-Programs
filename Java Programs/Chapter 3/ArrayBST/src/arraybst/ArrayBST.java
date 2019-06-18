
package arraybst;

import java.util.Scanner;

public class ArrayBST {

	public static int InsertBST(int[] Tree, int element) {
		int temp = 1;
		int node_inserted_flag = 0;
		if (Tree[temp] == -999) {
			Tree[temp] = element;
			node_inserted_flag = 1;
			return node_inserted_flag;
		}
		while (node_inserted_flag == 0 && temp <= 100) {
			if (Tree[temp] == element) {
				System.out
						.println("Duplicate value found - Node cannot be inserted");
				node_inserted_flag = -1;
			} else {
				if (Tree[temp] > element) {
					if (Tree[2 * temp] == -999) {
						Tree[2 * temp] = element;
						node_inserted_flag = 1;
					} else {
						temp = 2 * temp;
					}
				} else {
					if (Tree[2 * temp + 1] == -999) {
						Tree[2 * temp + 1] = element;
						node_inserted_flag = 1;
					} else {
						temp = 2 * temp + 1;
					}
				}
			}
			if (temp >= 100) {
				System.out.println("Array out of Bounds - Node can't be inserted");
				node_inserted_flag = -2;
			}
		}
		return node_inserted_flag;

	}

	public static void DeleteBST(int[] Tree, int element) {
		int temp = 1;
		while (Tree[temp] != element && Tree[temp] != -999 && temp < 100) {
			if (element < Tree[temp])
				temp = 2 * temp;
			else
				temp = 2 * temp + 1;
		}
		System.out.println(temp);
		if (temp > 100) {
			System.out.println("Array out of Bounds");
		}
		if (Tree[temp] == -999) {
			System.out.println("Element to be deleted is not found");
		} else {
			if (Tree[2 * temp] == -999 & Tree[2 * temp + 1] == -999) {
				Tree[temp] = -999;
				return;

			}
			if (Tree[2 * temp] == -999 || Tree[2 * temp + 1] == -999) {
				if (Tree[2 * temp] == -999)
					RestoreBST(Tree, 2 * temp);
				else
					RestoreBST(Tree, 2 * temp + 1);
			} else {
				int inorder_successor = 2 * temp + 1;
				while (Tree[2 * inorder_successor] != -999)
					inorder_successor = 2 * inorder_successor;
				Tree[temp] = Tree[inorder_successor];
				if (Tree[2 * inorder_successor + 1] == -999)
					Tree[inorder_successor] = -999;
				else
					RestoreBST(Tree, 2 * inorder_successor + 1);
			}
		}
	}

	private static void RestoreBST(int[] Tree, int root) {
		Tree[root / 2 - 1] = Tree[root];
		Tree[root] = -999;
		if (Tree[2 * root] != -999)
			RestoreBST(Tree, 2 * root);
		if (Tree[2 * root + 1] != -999)
			RestoreBST(Tree, 2 * root + 1);
	}

	private static void PreOrder(int[] Tree, int root) {
		System.out.println(Tree[root]);
		if (Tree[2 * root] != -999 && 2 * root <= 100)
			PreOrder(Tree, 2 * root);
		if (Tree[2 * root + 1] != -999 && 2 * root + 1 <= 100)
			PreOrder(Tree, 2 * root + 1);
	}

	public static void main(String[] args) {
		int Tree[] = new int[101];
		Scanner sc = new Scanner(System.in);
        int choice, elt;
        for (int i = 0; i < 100; i++)
			Tree[i] = -999;
        do {
            System.out.println("1.Insert an element\n2.Delete an element\n3.PreOrder Traversal\n4.Exit ");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    InsertBST(Tree, elt);
                    break;
                case 2:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    DeleteBST(Tree, elt);
                    break;
                case 3:
                    PreOrder(Tree,1);
            }
        } while (choice <= 3);
                
		
	}

}
