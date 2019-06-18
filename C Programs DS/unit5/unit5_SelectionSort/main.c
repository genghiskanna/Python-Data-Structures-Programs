#include<stdio.h>

void SelectionSort(int* a,int n);
int FindMinimum(int[],int,int);
void Swap(int[],int,int);

int main()
{
 int i,A[100],n;

printf("Enter the number of elements : ");
 scanf("%d",&n);
 printf("Enter the elements : ");
 for(i=1;i<=n;i++)
  scanf("%d",&A[i]);
SelectionSort(A,n);
  printf("\nSorted List : ");
 for(i=1;i<=n;i++)
  printf(" %d ",A[i]);
 return 0;
}

void SelectionSort(int *a,int n)
{
    int i,k, position;
    for(i = 1;i<=n-1;i++)
    {
        position = FindMinimum(a, i, n);
        Swap (a,position,i);
        printf("\ni : %d\n",i);
        for(k=1;k<=n;k++)
            printf(" %d ",a[k]);
        printf("\n");
     }

}


int FindMinimum(int A[],int low,int n)
{
 int position,j,small;
 position = low;
 for(j=low+1;j<=n;j++)
 {
    if(A[j] < A[position])
    {
	small = A[j];
	position = j;
    }
 }
 return (position);
}

void Swap(int A[],int i,int position)
{
// temp is a temporary variable used to enable a swap
    int temp;
    temp = A[i];
    A[i] = A[position];
    A[position] = temp;
}
