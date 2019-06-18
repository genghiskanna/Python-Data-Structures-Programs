#include <stdio.h>
#include <stdlib.h>

#define BASE 10

int findMaximum(int a[], int n)
{
    int max_digits = 0,i;
    int temp,digit_count;
    for(i=0;i<n;i++)
    {
	    temp = a[i];
	    digit_count = 0;
	    while(temp > 0)
	    {
		digit_count++;
		temp = temp/10;
	    }
	    if( max_digits < digit_count )
	    {
		max_digits = digit_count;
	    }
    }
    return max_digits;
}



void radixSort(int a[],int n)
{
	int **bucket,temp,div;
	int maxDigits,digit;
	int i,j,k,c,i1;
	int *indexCounter, index;

	maxDigits = findMaximum(a,n);

	indexCounter = malloc(sizeof(int)*BASE);
	bucket = (int **)malloc(sizeof(int *) * BASE);
	for(i=0;i<BASE;i++)
	{
	    bucket[i] =(int *)malloc(sizeof(int) * n);
	    indexCounter[i] = 0;
	}


	for(i = 0,div = 1; i< maxDigits; i++,div *= 10)
	{
	    for(j=0;j<n;j++)
	    {
            temp = a[j];

            temp = temp/div;
            digit = temp%10;
            temp = temp/10;

            index = indexCounter[digit];
            bucket[digit][index] = a[j];
            indexCounter[digit]++;
	    }

	    //copy from bucket to the array
	    for(j=0,c =0;j<BASE;j++)
	    {
            for(k=0;k<indexCounter[j];k++)
            {
		      a[c++] = bucket[j][k];
            }
            indexCounter[j] = 0;
	    }
	    printf("\n");
	    for(i1=0;i1<n;i1++)
	    {
            printf("%d\t",a[i1]);
	    }

	}


	free(indexCounter);
	free(bucket);
	return;
}


int main()
{
int a[100],n,i;
printf("Enter the number of elements : ");
scanf("%d",&n);
printf("Enter the elements : ");
for(i=0;i<n;i++)
    scanf("%d",&a[i]);
radixSort(a,n);
printf("\n");
for(i=0;i<n;i++)
{
    printf("%d\t",a[i]);
}
return 0;
}
