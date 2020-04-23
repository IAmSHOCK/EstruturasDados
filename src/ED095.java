import java.util.Scanner;

class Bombeiro
{
	public String nome;
	public int num_eventos;
	public int num_minutos;

	Bombeiro(String s)
	{
		this.nome 		 = s;
		this.num_eventos = 0;
		this.num_minutos = 0;
	}
}

class Bombeiros
{
	public Bombeiro array;

	Bombeiros()
	{
		array = new Bombeiro("");
	}
}

public class ED095
{

	public static void ler_bombeiros(Scanner stdin, int num_bomb)
	{
		MyQueue fila = new LinkedListQueue();
		String s;
		int i = 0;
		Bombeiros[] bombeiros = new Bombeiros[num_bomb];

		for (int j = 0; j < num_bomb ; j++) 
		{
			bombeiros[i] = new Bombeiros();		
		}

		while((s = stdin.next()) != "PARTIDA")
		{
			Bombeiro d = new Bombeiro(s);
			bombeiros[i].array = d;
			i++;
		}

		for (int j = 0; j < 5 ; j++) 
		{
			System.out.println(bombeiros[i]);
		}
	}

	public static void contar_eventos(Scanner stdin)
	{
		String s;
		int eventos = 0;
		
		while(stdin.hasNext())
		{
			s = stdin.next();
			if(s.equals("PARTIDA")) eventos++;
		}

		System.out.println("Ocorreram " + eventos + " eventos");
	}

	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		int flag 	  = stdin.nextInt();
		int num_bomb  = stdin.nextInt();
		stdin.nextLine();

		switch(flag)
		{
			case 1:
				contar_eventos(stdin);
				break;

			case 2:
				ler_bombeiros(stdin, num_bomb);
				break;

			case 3:
				ler_bombeiros(stdin, num_bomb);
				break;

			default:
				System.out.println("Flag invalida.");
		}
	}
}