import java.util.Scanner;

public class ED201
{
	static int viagem;
	static int nMusicas;
	static int[] musicas;
	static boolean[] used;
	static int max;

	public static void solve(int cur, int v[])
	{
		int sum = 0;
		if (cur == v.length) 
      	{ 
      		for (int i=0; i<v.length; i++) 
            	if (used[i]) sum+= v[i];
            if(sum > max && sum <= viagem) max = sum;
      	} 
      	else 
      	{                  // Se nao terminamos, continuar a gerar
        	used[cur] = true;      // Subconjuntos que incluem o elemento actual
        	solve(cur+1, v);// Chamada recursiva
        	used[cur] = false;     // Subconjuntos que nao incluem o el. actual
        	solve(cur+1, v);// Chamada recursiva
        }
	}

	static void input(Scanner in, int nMusicas, int[] musicas)
	{
		for (int i=0; i<nMusicas; i++)
		{
			musicas[i] = in.nextInt();
		}
	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		viagem 	 = in.nextInt();
		nMusicas = in.nextInt();
		musicas = new int[nMusicas];
		input(in, nMusicas, musicas);
		used = new boolean[nMusicas];
		max = 0;
		solve(0, musicas);
		System.out.println(max);
	}
}