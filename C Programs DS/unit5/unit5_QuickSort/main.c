#include<stdio.h>
#include<stdlib.h>

void quicksort(int a[],int low,int high,int n);
void swap(int a[],int i,int j);

void quicksort(int a[],int low,int high,int n)
{
        int pivot,j,i;
        printf("\nCall QuickSort(%d,%d)",low,high);
     	if(low < high)
	    {

//Then make pivot the first element
         pivot=a[low];
         i=low + 1;
         j=high;

         	while(i < j)
            {
                while( pivot >= a[i]&& i<high)
                {
                    i++;
                }
                while(pivot < a[j] && j>low)
                {
                    j--;
                }
                if( i < j)
                {
                    swap(a,i,j);
             	}
         	}
        if(a[low]>a[j])
         	swap(a,low,j);
        printf("\n");

        quicksort(a,low,j-1,n);
        quicksort(a,j+1,high,n);
    }
    printf("\nEnd QuickSort(%d,%d)\n",low,high);
    }
void swap(int a[],int i,int j)
{
    int temp;
    temp=a[i];
    a[i]=a[j];
    a[j]=temp;
}

int main()
{
    int a[100],low=0,high,i,n;
    printf("Enter the number of elements : ");
    scanf("%d",&n);
    printf("Enter the elements : ");
    for(i=0;i<n;i++)
    scanf("%d",&a[i]);
    high=n-1;
    quicksort(a,low,high,n);
    printf("\nSorted list : \n");
    for(i=0;i<n;i++)
	{
		printf("\tA[%d] = %d ",i+1,a[i]);
	}
	return 0;
}
