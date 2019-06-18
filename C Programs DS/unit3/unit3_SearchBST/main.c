# include <stdio.h>
# include <stdlib.h>

typedef struct BST {
   int data;
   struct BST *lchild, *rchild;
} node;

void insert(node *, node *);
node *search(node *, int, node **);

int main() {
   int choice;
   char ans = 'N';
   int key;
   node *new_node, *root, *tmp, *parent;
   node *get_node();
   root = NULL;
   do {
      printf("\n1.Create");
      printf("\n2.Search");
      printf("\nEnter your choice :");
      scanf("%d", &choice);

      switch (choice) {
      case 1:
         do {
            new_node = get_node();
            printf("\nEnter The Element ");
            scanf("%d", &new_node->data);

            if (root == NULL) /* Tree is not Created */
               root = new_node;
            else
               insert(root, new_node);

            printf("\nWant To enter More Elements?(y/n)");
            ans = getch();
         } while (ans == 'y');
         break;

      case 2:
         printf("\nEnter Element to be searched :");
         scanf("%d", &key);

         tmp = search(root, key, &parent);
         if(tmp!=NULL)
            printf("\nParent of node %d is %d", tmp->data, parent->data);
         break;

      }
   } while (choice != 2);
   return 0;
}
/*
 Get new Node
 */
node *get_node() {
   node *temp;
   temp = (node *) malloc(sizeof(node));
   temp->lchild = NULL;
   temp->rchild = NULL;
   return temp;
}
/*
 This function is for creating a binary search tree
 */
void insert(node *root, node *new_node) {
   if (new_node->data < root->data) {
      if (root->lchild == NULL)
         root->lchild = new_node;
      else
         insert(root->lchild, new_node);
   }

   if (new_node->data > root->data) {
      if (root->rchild == NULL)
         root->rchild = new_node;
      else
         insert(root->rchild, new_node);
   }
}
/*
 This function is for searching the node from
 binary Search Tree
 */
node *search(node *root, int key, node **parent) {
   node *temp;
   temp = root;
   while (temp != NULL) {
      if (temp->data == key) {
         printf("\nThe %d Element is Present", temp->data);
         return temp;
      }
      *parent = temp;

      if (temp->data > key)
         temp = temp->lchild;
      else
         temp = temp->rchild;
   }
   printf("\nElement is not found");
   return NULL;
}
