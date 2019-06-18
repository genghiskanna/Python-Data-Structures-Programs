package avl;

import java.util.Scanner;

class node {

    int data, height;
    node lchild, rchild;
};

public class AVL {

    public static node Insert(node root, int element) {
        if (root == null) {
            return (GetNode(element));
        }
        if (element < root.data) {
            root.lchild = Insert(root.lchild, element);
        } else {
            root.rchild = Insert(root.rchild, element);
        }
        //Update height of ancestor node
        root.height = FindMaximum(FindHeight(root.lchild), FindHeight(root.rchild)) + 1;
        int balance = GetBalance(root);

        /**
         * if the AVL tree is unbalanced , we check for 4 possible cases
         */
        // LL type rotation
        if (balance > 1 && element < root.lchild.data) {
            System.out.println("\nLL type");
            return RightRotate(root);
        }

        // RR type rotation
        if (balance < -1 && element > root.rchild.data) {
            System.out.println("\nRR type");
            return LeftRotate(root);
        }

        // LR type rotation
        if (balance > 1 && element > root.lchild.data) {
            System.out.println("\nLR type");
            root.lchild = LeftRotate(root.lchild);
            return RightRotate(root);
        }

        // RL type rotation
        if (balance < -1 && element < root.rchild.data) {
            System.out.println("\nRL type");
            root.rchild = RightRotate(root.rchild);
            return LeftRotate(root);
        }
        return root;
    }

    static node GetNode(int element) {
        node temp = new node();
        temp.data = element;
        temp.height = 1;
        temp.lchild = null;
        temp.rchild = null;
        return (temp);
    }

    static int FindMaximum(int node1_height, int node2_height) {
        if (node1_height > node2_height) {
            return (node1_height);
        } else {
            return (node2_height);
        }
    }

    static int GetBalance(node node1) {
        if (node1 == null) {
            return (0);
        } else {
            return (FindHeight(node1.lchild) - FindHeight(node1.rchild));
        }
    }

    static node LeftRotate(node lchildRoot) {
        node temp1 = lchildRoot.rchild;
        node temp2 = temp1.lchild;
        temp1.lchild = lchildRoot;
        lchildRoot.rchild = temp2;
        lchildRoot.height =
                FindMaximum(FindHeight(lchildRoot.lchild), FindHeight(lchildRoot.rchild)) + 1;
        temp1.height =
                FindMaximum(FindHeight(temp1.lchild), FindHeight(temp1.rchild)) + 1;
        return temp1;
    }

    static node RightRotate(node rightRoot) {
        node temp1 = rightRoot.lchild;
        node temp2 = temp1.rchild;
        temp1.rchild = rightRoot;
        rightRoot.lchild = temp2;
        rightRoot.height =
                FindMaximum(FindHeight(rightRoot.lchild), FindHeight(rightRoot.rchild)) + 1;
        temp1.height =
                FindMaximum(FindHeight(temp1.lchild), FindHeight(temp1.rchild)) + 1;;
        return temp1;
    }

    static void inorder(node root) {
        if (root != null) {
            inorder(root.lchild);

            System.out.println("Data : "+root.data + ", Height : " + root.height);
            inorder(root.rchild);
        }
    }

    static int FindHeight(node node1) {
        if (node1 == null) {
            return (0);
        } else {
            return (node1.height);
        }
    }

    static node InorderSuccessor(node inorder_N) {
        while (inorder_N.lchild != null) {
            // node parent_inorder_N = inorder_N;
            inorder_N = inorder_N.lchild;
        }
        return (inorder_N);
    }

    static node Delete_LinkedList_AVL(node root, int element) {
        node temp;
        if (root == null) {
            return root;
        }
        if (element < root.data) // // Is the node the lchild or right child of the root
        {
            root.lchild = Delete_LinkedList_AVL(root.lchild, element);
        } else if (element > root.data) {
            root.rchild = Delete_LinkedList_AVL(root.rchild, element);
        } else // The element is found
        {
            // Case 1 - Delete leaf node or Case 2 - Delete node with one child
            if ((root.lchild == null) || (root.rchild == null)) {
                if (root.lchild != null) // Is the child in the left of the root
                {
                    temp = root.lchild;
                } else {
                    temp = root.rchild;
                }
                if (temp == null) // Case 1 - Delete leaf node
                {
                    temp = root;
                    root = null;
                } else // Case 2 - Delete node with one child
                {
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                //Case 3 - Delete node with 2 children
                node temp1 = InorderSuccessor(root.rchild);
                // Copy the inorder successor's data to this node
                root.data = temp1.data;
                // Delete the inorder successor
                root.rchild = Delete_LinkedList_AVL(root.rchild, temp1.data);
            }
        }

        // If the tree had only one node then return
        if (root == null) {
            return root;
        }

        //Update height of current node
        root.height = FindMaximum(FindHeight(root.lchild), FindHeight(root.rchild)) + 1;
        int balance = GetBalance(root);

        // If this node becomes unbalanced, then there are 4 cases, combining R0 and R1 and L0 nd L-1 respectively

        // R0 or R1 rotation
        if (balance > 1 && GetBalance(root.lchild) >= 0) {
            System.out.println("Right Rotate");
            return RightRotate(root);
        }

        // R-1 Rotation
        if (balance > 1 && GetBalance(root.lchild) < 0) {
            System.out.println("R-1 rotation");
            root.lchild = LeftRotate(root.lchild);
            return RightRotate(root);
        }

        // L0 and L-1 Rotation
        if (balance < -1 && GetBalance(root.rchild) <= 0) {
            System.out.println("Left Rotate");
            return LeftRotate(root);
        }

        // L1 Rotation
        if (balance < -1 && GetBalance(root.rchild) > 0) {
            System.out.println("L1 rotation");
            root.rchild = RightRotate(root.rchild);
            return LeftRotate(root);
        }
        return root;
    }
    public static void main(String args[]) {
        node root = null;
        Scanner sc = new Scanner(System.in);
        int choice, elt;
        do {
            System.out.println("1.Insert an element\n2.Delete an element\n3.InOrder Traversal ");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    root=Insert(root, elt);
                    break;
                case 2:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    root=Delete_LinkedList_AVL(root, elt);
                    break;
                case 3:
                    inorder(root);
            }
        } while (choice <= 3);
    }
}
