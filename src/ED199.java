import java.util.Scanner;

public class ED199
{
	int nArcas;
	int binicial;
	int iInstrucoes;
	char[] tesouro;
	char[] direcao;
	int[] numpassos;

	public void input(Scanner in)
	{
		String cur;
		this.nArcas 	 = in.nextInt();
		this.binicial 	 = in.nextInt();
		this.iInstrucoes = in.nextInt();
		this.tesouro 	 = new char[nArcas];

		cur = in.next();
		for(int i = 0; i < nArcas; i++)
		{
			tesouro[i] = cur.charAt(i);
		}

		this.direcao   = new char[iInstrucoes];
		this.numpassos = new int[iInstrucoes];
		for(int i = 0; i < iInstrucoes; i++)
		{ 
			direcao[i]   = in.next().charAt(0);
			numpassos[i] = in.nextInt();
		}
	}

	public void solve()
	{
		int TESOUROS = 0;
		int max = binicial-1;
		int min = binicial-1;
		int cur = binicial-1;
		for (int i = 0; i < this.iInstrucoes; i++) 
		{
			if(direcao[i] == 'D')
			{
				cur += numpassos[i];
				if(max < cur) max = cur;
			}
			else
			{
				cur -= numpassos[i];
				if(min > cur) min = cur;
			}
		}

		for (int i = min; i <= max; i++)
		{
			if(tesouro[i] == 'T') TESOUROS++;
		}

		System.out.println(TESOUROS);
	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		ED199 problema = new ED199();
		problema.input(in);
		problema.solve();
	}
}