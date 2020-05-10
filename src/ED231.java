//------------------------------------------------------------------------------------
// Nome: João Aires
// Número: 201905175
//------------------------------------------------------------------------------------
// Algoritmo:
//
//	Flag 1: Fazer um ciclo desde o 2º dia ate ao ultimo (o 1º dia ja foi contabilizado
//	pois é a inicialização das variáveis e o numero de casos novos são os casos do
//	próprio dia), de seguida, dentro do ciclo: 
//		calcula-se o numero de casos;
//		verificar se é maior que o max;
//		verificar se é menor que o min;
//		imprimir o valor de max e min.
//
//	Flag 2: 


import java.util.Scanner;

class ED231
{
	static int nDias;
	static int[] dias;
	static int flag;

	static void input(Scanner in)
	{
		nDias = in.nextInt();
		dias  = new int[nDias];
		for(int i = 0; i < nDias; i++)
		{
			dias[i] = in.nextInt();
		}  
		flag = in.nextInt();
	}

	static void solve()
	{
		switch(flag)
		{
			case 1:
				solve1();
				break;

			case 2:
				solve2();
				break;

			case 3:
				solve3();
				break;
			default: System.out.println("flag inválida.");								
		}
	}

	static  void solve1()
	{
		int min = dias[0];
		int max = dias[0];
		int dif;
		for(int i = 1; i < dias.length; i++)
		{
			dif = dias[i] - dias[i-1];
			if(dif > max) max = dif;
			if(dif < min) min = dif;
		}
		System.out.printf("%d %d%n", min, max);
	}

	static void solve2()
	{
		
	}

	static void solve3()
	{
		
	}	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		input(in);
		solve();		
	}
}