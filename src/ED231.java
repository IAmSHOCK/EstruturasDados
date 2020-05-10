//------------------------------------------------------------------------------------
// Nome: João Aires
// Número: 201905175
//------------------------------------------------------------------------------------
// Algoritmo:
//
//	Flag 1: 
//	Fazer um ciclo desde o 2º dia ate ao ultimo (o 1º dia ja foi contabilizado
//	pois é a inicialização das variáveis e o numero de casos novos são os casos do
//	próprio dia), de seguida, dentro do ciclo: 
//		-calcula-se o numero de casos;
//		-verificar se é maior que o max;
//		-verificar se é menor que o min;
//		-imprimir o valor de max e min.
//	Complexidade: Θn, n = num dias.
//
//	Flag 2: 
//	Fazer um ciclo desde o 2º dia ate ao ultimo (o 1º dia nao conta)
//	bef = false significa que o caso anterior nao foi uma subida percentual <= 5%.
//	Dentro do ciclo:
//		-calcular a subida percentual;
//		-verificar se no caso anterior houve uma subida percentual <= 5% e se no caso
// 		 atual há (para aumentar a quantidade de períodos de baixa propagação);
//		-Se no caso atual a subida percentual <= 5%, aumenta-se o tamanho do período
//		 de baixa propagação em 1 dia e coloca-se a flag bef a true para no proximo
//		 caso nao ser considerado um periodo de dias extra. De seguida verifica-se se o
//		 tamanho do período de baixa propagação é o maior até agora e, se sim,
//		 guarda-se esse tamanho em maxTamanho;
//		-Se no caso atual nao houver a subida percentual <= 5%, então o tamanho do
//		 período de baixa propagação reseta para 0 e a flag a false.
//	No final imprime-se os valores pedidos.
//	Complexidade: Θn, n = num dias.
//
// Flag 3:


import java.util.Scanner;

public class ED231
{
	static int nDias;
	static int[] dias;
	static int flag;
	static char[][] matrix;
	static int max;

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
		int nPeriodos  = 0;
		int tamanho    = 0;
		int maxTamanho = 0;
		float curr;
		boolean bef  = false;
		for(int i = 1; i < dias.length; i++)
		{
			curr = (float)(dias[i]-dias[i-1])*100/dias[i-1];
			if(!bef && curr <= 5) nPeriodos++;
			if(curr <= 5) 
			{
				tamanho++;
				bef = true;	
				if(tamanho > maxTamanho) maxTamanho = tamanho;
			}
			else 
			{
				tamanho = 0;
				bef = false;
			}
		}
		System.out.printf("%d %d%n", nPeriodos, maxTamanho);
	}

	static void solve3()
	{

		gerar_chars();
		print_chars();
	}	

	static void gerar_chars()
	{
		int[] numChars = new char[nDias];
		max = dias[0]/100;		

		for (int i = 1; i < nDias; i++) 
		{
			if(dias[i]/100 > max) max = dias[i]/100;
			numChars[i] = dias[i]/100;
		}

		matrix = new char[nDias][max];
		for (int i = 0; i < nDias ; i++)
		{
			int numPoints = max - numChars[i];
			int j = 0;
			int index = numPoints;
			while(index > 0)
			{
				matrix[i][j] = '.';
				index--;
				j++;
			}
			while(numPoints < numChars)
			{
				matrix[i][j] = '#';
				numPoints++;
				j++;
			}
		}
	}

	static void print_chars()
	{
		for(int i = 0; i < max, i++)
		{
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		input(in);
		solve();		
	}
}