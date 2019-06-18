#include <stdio.h>
#include <stdlib.h>
void Bubble_Sort(int* a);
int main()
{
    int n,i,a[100];
    printf("Enter the number of elements in an array\n");
    scanf("%d",&n);
    printf("Enter the elements\n");
    for(i=1;i<=n;i++)
    {
        scanf("%d",&a[i]);
    }
    printf("Elements in an array\n");
    for(i=1;i<=n;i++)
    {
        printf("%d\n",a[i]);
    }
    Bubble_Sort(a);
    printf("Elements in sorted order\n");
    for(i=1;i<=n;i++)
    {
        printf("%d\n",a[i]);
    }
    return 0;
}
void Bubble_Sort(int *a)
{
    int pass,i,n,temp;
    n=sizeof(a);
    for(pass=1;pass<=n;pass++)
    {
        for(i=1;i<=n-pass;i++)
        {
            if(a[i]>a[i+1])
            {
                temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
    }
}
