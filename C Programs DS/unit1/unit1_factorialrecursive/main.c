#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n=0;
    printf("Enter the number to find factorial\n");
    scanf("%d",&n);
    printf("FACTORIAL: %d",factorial(n));
    return 0;
}
int factorial(int n)
{
    if(n==1)
    {
        return 1;
    }
    else
    {
        return n*factorial(n-1);
    }
}
