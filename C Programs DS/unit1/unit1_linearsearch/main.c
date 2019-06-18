#include <stdio.h>
#include <stdlib.h>
int Linear_Search(int* a,int element);
int main()
{
    int n,i,a[100],element;
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
    printf("Enter the element to search\n");
    scanf("%d",&element);
    Linear_Search(a,element);
    //if(position==-1)
    return 0;
}
int Linear_Search(int *a,int element)
{
    int n,i;
    n=sizeof(a);
    for(i=1;i<=n;i++)
    {
        if(a[i]==element)
        {
            printf("The element searched is found at the %d position in the array",i);
            return i;
        }
    }
    printf("The element searched was not found");
    return -1;
}
