#include <stdio.h>
#include <stdlib.h>
int Binary_Search(int* a,int low,int high,int e);
int main()
{
    int n,i,a[100],low=1,high,e;
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
    high=sizeof(a);
    printf("Enter the element to search\n");
    scanf("%d",&e);
    Binary_Search(a,low,high,e);
    return 0;
}
int Binary_Search(int* a,int low,int high,int e)
{
    int mid;
    if(low>high)
    {
        printf("Element not found");
        return -1;
    }
    mid=(low+high)/2;
    if(a[mid]==e)
    {
        printf("Element is found in the array");
        return mid;
    }
    if(a[mid]>e)
    {
        Binary_Search(a,low,mid-1,e);
    }
    else
    {
        Binary_Search(a,mid+1,high,e);
    }
}
