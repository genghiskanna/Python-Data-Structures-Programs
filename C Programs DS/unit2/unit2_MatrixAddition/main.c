#include <stdio.h>
#include <stdlib.h>
int  n,m,i,j, a[10][10],b[10][10], c[10][10];
int main()
{
    printf("******ADDITION OF TWO MATRICES*******\n");
    printf(" enter the row size\n ");
    scanf("%d",&n);
    printf("enter the column size\n ");
    scanf("%d",&m);
    printf("enter the elements of the first matrix row by row\n");
    for(i=0;i<n;i++)   /*INPUT FOR FIRST MATRIX*/
    {
        for(j=0;j<m;j++)
        {

        scanf("%d",&a[i][j]);

         }

    }
    printf("enter the elements of the second matrix row by row\n");
      for(i=0;i<n;i++)   //INPUT FOR SECOND MATRIX
    {
        for(j=0;j<m;j++)
        {

        scanf("%d",&b[i][j]);

         }

    }
    Matrix_Addition(&a,&b,n,m);
    return 0;
}
void Matrix_Addition(int (*a)[10],int (*b)[10],int n,int m)
{
  printf("the resultant matrix is\n");
  for(i=0;i<n;i++)
  {
      for(j=0;j<m;j++)
      {
          c[i][j]=a[i][j]+b[i][j];
          printf("%d",c[i][j]);
          printf("\t");
       }
  printf("\n");
  }
}
