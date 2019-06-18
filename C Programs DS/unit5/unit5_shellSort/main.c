#include<stdio.h>

void ShellSort(int[],int);


int main()
{
 int i,A[100],n;

 printf("Enter the number of elements : ");
 scanf("%d",&n);
 printf("Enter the elements : ");
 for(i=1;i<=n;i++)
  scanf("%d",&A[i]);
 ShellSort(A,n);
  printf("\nSorted List : ");
 for(i=1;i<=n;i++)
  printf(" %d ",A[i]);

 return(0);
}
void ShellSort(int a[], int n)
{
	int i, j, increment, temp;
for(increment = n/2;increment > 0; increment = increment/2)
{


	for(i = increment+1; i<=n; i++)
    	{
        temp = a[i];
        j=i;
        while((j>=(increment+1)) && (a[j-increment]>temp))
        {
                a[j] = a[j-increment];
                j=j-increment;
        }
        a[j] = temp;
     }
    printf("\nIntermediate List : ");
    for(i=1;i<=n;i++)
        printf(" %d ",a[i]);
}

}
