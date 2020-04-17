import java.util.Scanner;

class Cliente
{
	String nome;
	int seg_cheg;
	int num_prod;
	
	Cliente()
	{
		this.nome = "";
		this.seg_cheg = 0;
		this.num_prod = 0;
	}


	static Cliente Cliente_update(String nome, int seg_cheg, int num_prod)
	{
		Cliente tmp  = new Cliente();
		tmp.nome 	 = nome;
		tmp.seg_cheg = seg_cheg;
		tmp.num_prod = num_prod;
		return tmp;
	}
	public static int solve_1(Cliente x, Caixa caixa, int saida_anterior)
	{
		int seg_saida;
		int espera;
		espera = saida_anterior - x.seg_cheg;
		if(espera < 0) espera = 0;
		seg_saida = espera + x.seg_cheg + 10 + (x.num_prod * caixa.tempo_k[0]);
		System.out.println(x.nome+ " " + x.seg_cheg + " " + seg_saida);
		saida_anterior = seg_saida;
		return saida_anterior;
	}
	public void solve_2()
	{
 
	}


	public String toString()
	{
		String s = "";
		s += this.nome + " " + this.seg_cheg + " " + this.num_prod;
		return s;
	}
}

class Caixa 
{
    public MyQueue<Cliente> q;
    public int[] caixas;
    public int num_caixas;
    public int[] tempo_k;

	Caixa(int num_caixas)
	{
		this.num_caixas = num_caixas;
		caixas  		= new int[num_caixas];
		tempo_k 		= new int[num_caixas];
		q 				= new LinkedListQueue<Cliente>();
	}

	public void caixas(Scanner stdin)
	{
		for(int i = 0; i < num_caixas; i++) 
		{	
			this.tempo_k[i] = stdin.nextInt();
		}
	}
}

public class ED115
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		int flag, caixas, c;
		String s;
		Cliente[] clientes;
		flag    = stdin.nextInt();
		Caixa k;

		if(flag == 2)
		{
			caixas  = stdin.nextInt();

			k = new Caixa(caixas);
			
			k.caixas(stdin);

			c = stdin.nextInt();
			
			clientes = new Cliente[c];

			for (int i = 0; i < c ; i++) 
			{
				clientes[i] = Cliente.Cliente_update(stdin.next(), stdin.nextInt(), stdin.nextInt());
				clientes[i].solve_2();
			}

		}
		else
		{
			caixas  = stdin.nextInt();

			k = new Caixa(caixas);

			k.caixas(stdin);
	
			c = stdin.nextInt();
			
			clientes = new Cliente[c];
			int seg_anterior = 0;
			for (int i = 0; i < c ; i++) 
			{
				clientes[i]  = Cliente.Cliente_update(stdin.next(), stdin.nextInt(), stdin.nextInt());
				seg_anterior = Cliente.solve_1(clientes[i], k, seg_anterior);
			}
		}
	}
}