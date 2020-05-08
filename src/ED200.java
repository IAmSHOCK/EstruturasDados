import java.util.Scanner;

public class ED200
{
	static int n;
	static int rows;
	static int cols;
	static char[][] m;
	static boolean visited[][];

	static int t(int y, int x) 
    {
		if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
		if (visited[y][x]) return 0;  // Caso base: celula ja visitada
		if (m[y][x] == '.') return 0; // Caso base: celula vazia
		int count = 1;        // celula nao vazia
		visited[y][x] = true; // marcar como visitada
		count += t(y-1, x);   // Adicionando celulas nao vizinhas
		count += t(y+1, x);
		count += t(y, x+1);
		count += t(y, x-1);
		count += t(y, x+1);
		count += t(y+1, x+1);
		count += t(y+1, x-1);
		count += t(y-1, x+1);
		count += t(y-1, x-1);
		return count;
    }

	static void solve()
	{
		int max = 0;
		int tmp = max;
		for(int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				tmp = t(i,j);
				if(tmp > max) max = tmp;
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		for(int i = 0; i < n; i++)
		{
			rows = in.nextInt();
			cols = in.nextInt();
			m 	 = new char[rows][cols];	
			for (int j = 0; j < rows; j++)
        		m[j] = in.next().toCharArray();
      		visited = new boolean[rows][cols];
      		solve();	
		}
	}
}