#include <stdio.h>
#include <stdlib.h>
void Array_Insertion(int* a,int n,int element,int pos);
int main()
{
    int i,a[100];
    int n,element,pos,noelements;
    printf("Enter the number of elements in array\n\n");
    scanf("%d",&n);
    printf("enter the %d elements\n\n",n);
    for(i=0;i<n;i++)/*INPUT FOR ARRAY*/
    {
         scanf("%d", &a[i]);
    }
    printf("****array before insertion****\n");
    for(i=0;i<n;i++)
    {
         printf("%d\t", a[i]);
    }
    printf("\nno of elements=%d\nenter the element to be inserted\n",n);
    scanf("%d",&element);
    printf("enter the position of the element\n");
    scanf("%d",&pos);
    if(pos > 100)
    {
        printf("\nInsertion not possible");
        exit(0);
    }

    Array_Insertion(a,n,element,pos);
    return 0;
}
void Array_Insertion(int *a,int n, int element,int pos)
{
    int noelements,i;
    noelements=n;
    printf("No. of element : %d,pos : %d",noelements,pos);
    for(i=noelements;i>=pos;i--)
    {
        a[i+1]=a[i];/*SWAPPING*/
    }
    printf("element : %d,pos : %d",element,pos);
    if(pos > noelements)
        a[pos-1]=element;
    else
        a[pos]=element;/*INSERTION OF ELEMENTS*/

    printf("\na[pos] = %d, n=%d",a[pos],n);
    noelements++;
    printf("****after insertion****\n");
    for(i=0;i<=n;i++)
    {
        printf("%d\t", a[i]);
    }
    printf("\nno of elements=%d",noelements);
}
