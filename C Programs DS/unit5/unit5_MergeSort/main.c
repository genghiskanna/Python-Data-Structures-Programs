#include<stdio.h>

void merge(int a[], int low, int mid, int high,int n);

void mergesort(int a[], int low, int high,int n)
{

    	if (low < high)
        {

            int mid = (high + low)/2;
            printf("\nmid = %d, Call Merge_Sort(A, %d, %d)",mid+1, low+1, mid+1);
            mergesort(a, low, mid,n);
            printf("\nmid = %d, Call Merge_Sort(A, %d, %d)",mid+1, mid+2, high+1);
            mergesort(a, mid + 1, high,n);
            printf("\nmid = %d, Call Merge(A, %d, %d, %d)",mid+1, low+1, mid+1, high+1);
            merge(a, low, mid, high,n);
            printf("\n\nend Merge(A, %d, %d, %d)\n",low+1, mid+1, high+1);
        }
    	printf("\nend Merge_Sort(A, %d, %d)\n",low+1, high+1);
}


void merge(int a[], int low, int mid, int high,int n)
{
    int temp[8]={0};
    int subarray1 = low;
    int subarray2 = mid + 1;
    int temparray = low;
    int i;

    printf("\nInitial : subarray1 = %d, subarray2 = %d, temparray = %d", subarray1+1,subarray2+1,temparray+1);

   	while (subarray1 <= mid && subarray2 <= high)
	{
        if (a[subarray1] < a[subarray2])
        {
            printf("\na[%d] < a[%d] is satisfied", subarray1+1, subarray2+1);
    		temp[temparray] = a[subarray1];
			subarray1++;
		}
        else
		{
		    printf("\na[%d] < a[%d] is not satisfied", subarray1+1, subarray2+1);
    		temp[temparray] = a[subarray2];
			subarray2++;
		}
		temparray++;

    }


	if(subarray1 > mid)
	{
	    printf("\nThe first sublist has no more elements and the second sublist has elements");
	    while (subarray2 <= high)
     	{
			temp[temparray++] = a[subarray2++];
  		}
	}
	else
	{
	    printf("\nThe second sublist has no more elements and the first sublist has elements");
		while (subarray1 <= mid)
		{
        	temp[temparray++] = a[subarray1++];
  		}
	}

   	for(i=low;i<=high;i++)
	{
		a[i] = temp[i];
	}
	printf("\n\nIntermediate A\n");
    for(i=0;i<n;i++)
	{
		printf("A[%d] = %d ",i+1,a[i]);
	}
	printf("\n");
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
    mergesort(a,low,high,n);
    for(i=0;i<n;i++)
	{
		printf("\nA[%d] = %d ",i+1,a[i]);
	}
}
