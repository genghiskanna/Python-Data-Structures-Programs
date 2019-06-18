#include <stdio.h>
#include<conio.h>
void Array_Deletion(int* a,int n,int element);
void main()
{
    int a[100],element,i,j,n;
    printf("************DELETION OF AN ELEMENT IN ARRAY************\n");
    printf("enter the no of elements in array\n ");
    scanf("%d",&n);
    printf("enter the elements for array\n");
    for(i=0;i<n;i++)/*input for array*/
    {
    scanf("%d",&a[i]);
    }
    printf("the elements of the array before deletion\n");
    for(i=0;i<n;i++)
    {
       printf("%d\t",a[i]);
    }
    printf("\nenter the element to be deleted\n");
    scanf("%d",&element);/*deletion of element*/
    Array_Deletion(a,n,element);
}
void Array_Deletion(int *a,int n,int element)
{
    int noelement,i,j;
    noelement=n;
    for(i=0;i<n;i++)
    {
      if(a[i]==element)
      {
          for(j=i;j<noelement-1;j++)
          {
            a[j] =a[j+1] ;
          }
      }

    }
   printf("array after deletion\n");
   for(i=0;i<n-1;i++)
   {
       printf(" %d \t",a[i]);
   }
}
