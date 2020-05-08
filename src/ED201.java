import java.util.Scanner;

public class ED201
{
	static int viagem;
	static int nMusicas;
	static int[] musicas;
	static boolean[] used;

	public static int solve(int cur, int v[])
	{
		int sum = 0;
		int tmp1, tmp2;
		if (cur == v.length) 
      	{ 
      		for (int i=0; i<v.length; i++) 
            	if (used[i]) sum+= v[i];
            return sum;
      	} 
      	else 
      	{                  // Se nao terminamos, continuar a gerar
        	used[cur] = true;      // Subconjuntos que incluem o elemento actual
        	tmp1 = solve(cur+1, v);// Chamada recursiva
        	used[cur] = false;     // Subconjuntos que nao incluem o el. actual
        	tmp2 = solve(cur+1, v);// Chamada recursiva
        	if(tmp1 > tmp2 && tmp1 <= viagem) return tmp1;
        	if(tmp2 > tmp1 && tmp2 <= viagem) return tmp2;
        }
        return 0;
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
		System.out.println(solve(0, musicas));
	}
}