//give input as alphabet. if a means value 1, b means value 2 and goes on....
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include<ctype.h>
#include<malloc.h>

struct node
{
    void * value;
    struct node * next;
};
struct stack
{
    struct node * first;
    int elemSize;
    int length;
};
struct stack* stackNew(int elemSize)
{
    struct stack* s = (struct stack*)malloc(sizeof(struct stack));
    s->elemSize = elemSize;
    s->length = 0;
    return s;
}
void Push(struct stack* s, void* value)
{
    struct node* oldFirst = s->first;
    s->first = (struct node*)malloc(sizeof(struct node));
    s->first->value = malloc(s->elemSize);
    memcpy(s->first->value, value, s->elemSize);
    s->first->next = oldFirst;
    s->length++;
}

void* Pop(struct stack* s)
{
    void* value = malloc(s->elemSize);
    memcpy(value, s->first->value, s->elemSize);
    struct node* oldFirst = s->first;
    s->first = s->first->next;
    free(oldFirst);
    s->length--;
    return value;
}
struct nodeexpr{
int value;
int val;
char opr;
struct nodeexpr *lchild,*rchild;
};
struct nodeexpr * ConstructExpressionTree(char str[])
{
    struct stack* s = stackNew(sizeof(struct nodeexpr));
    printf("Given Expression :");puts(str);
    struct nodeexpr *temp,*t2;
    struct nodeexpr *n1,*n2;
    char next;
    int i;
		for (i = 0; i < strlen(str); i++) {
			next = str[i];
			if(!(next=='+' || next=='-' || next=='*' || next=='/' || next=='%'))
            {
                temp=(struct nodeexpr *)malloc(sizeof(struct nodeexpr));
                t2=(struct nodeexpr *)malloc(sizeof(struct nodeexpr));
                temp->value=next;
                temp->val=1;
                temp->lchild=NULL;
                t2->val=1;
                if(next=='a'||next=='b')
                    t2->value=1;
                temp->rchild=t2;
                Push(s,temp);
            }
            else if((next=='+' || next=='-' || next=='*' || next=='/' || next=='%'))
            {
                temp=(struct nodeexpr *)malloc(sizeof(struct nodeexpr));
                t2=(struct nodeexpr *)malloc(sizeof(struct nodeexpr));
                temp->value=next;
                temp->val=0;
                n1=(struct nodeexpr *)Pop(s);
                n2=(struct nodeexpr *)Pop(s);
                temp->lchild=n1;
                temp->rchild=n2;
                Push(s,temp);
            }

}
return (struct nodeexpr *)Pop(s);
}
int val[26],n;

int EvaluateExpressionTree(struct nodeexpr *root)
{

		int op1, op2, x;
		if (root->val == 1) {
				return val[root->value-'a'];
		} else {
			char opr = root->value;
			op1 = EvaluateExpressionTree(root->lchild);
			op2 = EvaluateExpressionTree(root->rchild);
			if (opr == '+')
				return op1 + op2;
			else if (opr == '-')
				return op1 - op2;
			else if (opr == '*')
				return op1 * op2;
			else if (opr == '/')
				return op1 / op2;
			else
				return op1 % op2;
		}
    return 0;
}
int main()
{
    int i;
 struct nodeexpr *root=(struct nodeexpr *)malloc(sizeof(struct nodeexpr));
char postfix[100]="";
printf("\nEnter number of variables");
scanf("%d",&n);
for (i=0;i<n;i++)
{
printf("Enter the value for %c",'a'+i);
scanf("%d",&val[i]);
}
printf("Enter the postfix expression:");
scanf("%s",postfix);
root=ConstructExpressionTree(postfix);
printf("Evaluating the Expression Tree : %d",EvaluateExpressionTree(root));
return 0;
}
