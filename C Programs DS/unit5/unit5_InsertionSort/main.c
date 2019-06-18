#include<stdio.h>

void InsertionSort(int[],int);


int main()
{
 int i,A[100],n;

 printf("Enter the number of elements : ");
 scanf("%d",&n);
 printf("Enter the elements : ");
 for(i=1;i<=n;i++)
    scanf("%d",&A[i]);
 InsertionSort(A,n);
 printf("\nSorted List : ");
 for(i=1;i<=n;i++)
    printf(" %d ",A[i]);

 return(0);
}

void InsertionSort(int A[], int n)
{
    int i,j,k,temp;
    for(i=2;i<=n;i++)
  {
     temp = A[i];
     for(j=i-1;j>=1;j--)
      {
        if(temp < A[j])
            A[j+ 1] = A[j];
        else
            break;
        printf("\nj = %d,i = %d,temp = %d\n",j,i,temp);
        for(k=1;k<=n;k++)
            printf("a[%d] = %d ",k,A[k]);
        }
        A[j+ 1] = temp;
      }
}
