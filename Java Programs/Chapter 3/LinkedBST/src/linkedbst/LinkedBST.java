package linkedbst;

import java.util.*;

class node {

    int data;
    node rchild;
    node lchild;
}

public class LinkedBST {

    static int node_inserted_flag;
    static node root;

    private static int InsertBST(int element) {
        node temp = root;
        node_inserted_flag = 0;
        if (root == null) {
            temp = new node();
            temp.data = element;
            root = temp;
            node_inserted_flag = 1;
            return node_inserted_flag;
        } else {
            while (node_inserted_flag == 0) {
                if (temp.data == element) {
                    System.out
                            .println("Duplicate Value found - Node can't be inserted ");
                    node_inserted_flag = -1;
                }
                if (temp.data > element) {
                    if (temp.lchild == null) {
                        temp.lchild = new node();
                        temp.lchild.data = element;
                        node_inserted_flag = 1;
                    } else {
                        temp = temp.lchild;
                    }
                } else {
                    if (temp.rchild == null) {
                        temp.rchild = new node();
                        temp.rchild.data = element;
                        node_inserted_flag = 1;
                    } else {
                        temp = temp.rchild;
                    }
                }
            }
        }
        return node_inserted_flag;
    }

    private static node SearchBST(node root, int element) {
        if (root == null) {
            System.out.println("Element Not Found");
            return root;
        }
        if (element < root.data) {
            return SearchBST(root.lchild, element);
        } else if (element > root.data) {
            return SearchBST(root.rchild, element);
        } else {
            return root;
        }
    }

    public static void PreOrder(node root) {
        if (root == null) {
            return;
        } else {
            System.out.println(root.data);
        }
        if (root.lchild != null);
        PreOrder(root.lchild);
        if (root.rchild != null) {
            PreOrder(root.rchild);
        }
    }

    public static void PreOrderIterative(node root) {
        Stack<node> stk = new Stack<node>();
        node temp;
        if (root == null) {
            return;
        } else {
            stk.push(root);
        }
        while (!stk.empty()) {
            temp = stk.pop();
            while (temp != null) {
                System.out.println(temp.data);
                if (temp.rchild != null) {
                    stk.push(temp.rchild);
                }
                temp = temp.lchild;
            }
        }
    }

    public static void main(String[] args) {
        int choice, elt;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.Insert an element\n2.Delete an element\n3.PreOrder Traversal\n4.Exit ");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    InsertBST(elt);
                    break;
                case 2:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    Delete_LinkedList_BST(root, elt);
                    break;
                case 3:
                    PreOrder(root);
            }
        } while (choice <= 3);

    }

    public static void Delete_LinkedList_BST(node root, int element) {
        node temp = root; // Start at the root node
        node parent = root; // Root node does not have a parent
        while (temp != null && element != temp.data) {
            // Loop until the node is found
            parent = temp; // change the parent pointer before traversing further
            if (element < temp.data) {
                temp = temp.lchild;// Traverse to the left
            } else {
                temp = temp.rchild;// Traverse to the right
            }
        }
        if (temp == null) {
            System.out.println("\nElement to be deleted is not found");
            return;
        }
        // Case 1 – Deletion of a leaf node
        if (temp.lchild == null && temp.rchild == null) // Leaf node indicator
        {
            if (parent == temp) // The tree has only one node
            {
                root = null;
            } else {
                if (temp == parent.lchild) // The node to be deleted is the left child of the parent
                {
                    parent.lchild = null;
                } else {
                    parent.rchild = null;
                }
            }
        } // Case 2 – Deletion of a  node with one subtree
        else {
            if (temp.lchild == null || temp.rchild == null) // Either one subtree is absent
            {
                if (parent == temp) // The root node is to be deleted
                {
                    if (temp.lchild != null) // The subtree is to the left of the root
                    {
                        root = temp.lchild;
                    } else {
                        root = temp.rchild;
                    }
                } else // Handle four possible cases of deletion
                {
                    if (temp == parent.lchild) // The node to be deleted is to the left of the parent
                    {
                        if (temp.lchild != null) // The node to be deleted has a left child
                        {
                            parent.lchild = temp.lchild;
                        } else {
                            parent.lchild = temp.rchild;
                        }
                    } else // The node to be deleted is to the right of the parent
                    {
                        if (temp.lchild != null) // The node to be deleted has a left child
                        {
                            parent.rchild = temp.lchild;
                        } else {
                            parent.rchild = temp.rchild;
                        }
                    }
                }
            } //Case 3 – Deletion of node with both the subtrees
            else// Locate the inorder successor and its parent for reference
            {
                node parent_inorder_successor = temp; // Start from the node to be deleted
                node inorder_successor = temp.rchild; // Inorder successor is surely in the right subtree
                while (inorder_successor.lchild != null) {
                    parent_inorder_successor = inorder_successor;
                    inorder_successor = inorder_successor.lchild;
                }
                temp.data = inorder_successor.data; // Replace with inorder successor
                if (temp != parent_inorder_successor) {
                    parent_inorder_successor.lchild = inorder_successor.rchild;
                } else {
                    parent_inorder_successor.rchild = inorder_successor.rchild;
                }
                temp = inorder_successor;
            }
        }
    }
}
