import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matriz
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }
   public static Matrix identity(int n)
   {
      Matrix m = new Matrix(n,n);
      for(int i=0;i<n;i++)
      {
         for(int j=0; j<n; j++)
         {
            if(i==j)
            {
               m.data[i][j]=1;
            }
            else m.data[i][j]=0;
         }
      }
      return m;
   }

   public Matrix transpose()
   {
      Matrix m = new Matrix(cols,rows);
      for(int i=0;i<cols;i++)
      {
         for(int j=0; j<rows; j++)
         {
            m.data[i][j]=data[j][i];
         }
      }
      return m;
   }

   public Matrix sum(Matrix m)
   {
      Matrix sum = new Matrix(rows,cols);
      for(int i=0;i<rows;i++)
      {
         for(int j=0; j<cols; j++)
         {
            sum.data[i][j] = m.data[i][j] + data[i][j];
         }
      }
      return sum;
   }
   public Matrix multiply(Matrix m)
   {
      if(cols!=m.rows) return null;
      Matrix multiply = new Matrix(rows,m.cols);
      for(int i=0; i<rows; i++)
      {
         for(int j=0;j<m.cols; j++)
         {
            for(int k=0; k<cols; k++)
            {
               multiply.data[i][j] += m.data[k][j] * data[i][k];
            }
         }
      }
      return multiply;
   }
}
