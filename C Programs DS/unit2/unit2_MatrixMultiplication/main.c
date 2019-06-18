#include <stdio.h>
#include <stdlib.h>
int  n,m,r,i,j,k, a[10][10],b[10][10], c[10][10];
int main()
{
    printf("******MULTIPLICATION OF TWO MATRICES*******\n");
    printf(" Enter the row size\n ");
    scanf("%d",&n);
    printf("Enter the column size\n ");
    scanf("%d",&m);
    printf("Enter the elements of the first matrix row wise\n");
    for(i=0;i<n;i++)   /*INPUT FOR FIRST MATRIX*/
    {
        for(j=0;j<m;j++)
        {

        scanf("%d",&a[i][j]);

         }

    }
    printf("Enter the column size of the second matrix\n ");
    scanf("%d",&r);
    printf("Enter the elements of the second matrix row wise\n");
      for(i=0;i<m;i++)   //INPUT FOR SECOND MATRIX
    {
        for(j=0;j<r;j++)
        {

        scanf("%d",&b[i][j]);

         }

    }
    Matrix_Multiplication(&a,&b,n,m);
    return 0;
}
void Matrix_Multiplication(int (*a)[10],int (*b)[10],int n,int m)
{
  printf("The resultant matrix is\n");
  for(i=0;i<n;i++)
  {
      for(j=0;j<r;j++)
      {
          c[i][j]=0;
          for(k=0;k<m;k++)
          {
              c[i][j]=c[i][j]+(a[i][k]*b[k][j]);


          }
          printf("%d\t",c[i][j]);

      }
      printf("\n");
  }
}
