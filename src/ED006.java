import java.util.Scanner;

public class ED006
{
	private CircularLinkedList<String> jogo;
	private int rotacoes;
	private int pessoas;

	public ED006(int rotacoes, int pessoas)
	{
		jogo 		  = new CircularLinkedList<String>();
		this.rotacoes = rotacoes;
		this.pessoas  = pessoas;
	}

	public void add_people(String[] people, int pessoas)
	{
		for (int i = 0; i < pessoas; i++) 
		{
			jogo.addLast(people[i]);
		}
	}

	public String pimPamPum()
	{
		String result="";
		
		while(jogo.getLast() != jogo.getFirst())
		{
			int n=0;
			while(n < rotacoes)
			{
				jogo.rotate();
				n++;

			}
			//result = jogo.getFirst();
			jogo.removeLast();
		}
		return jogo.getFirst();
		
	}

	public static void main(String[] args) 
	{
		int 	 casos 		 = 0;
		int 	 palavras	 = 0;
		int 	 num_pessoas = 0;
		String[] pessoas 	 = new String[100];
		String   result;
		Scanner  stdin    	 = new Scanner(System.in);

		casos = stdin.nextInt();
		for (int i = 0; i < casos ; i++)
		{
			stdin.nextLine();
			
			palavras = stdin.nextLine().split(" ").length;
			
			num_pessoas = stdin.nextInt();
			ED006 jogo = new ED006(palavras, num_pessoas);
			for(int j = 0; j < num_pessoas; j++)
			{
				pessoas[j] = stdin.next();
			}

			jogo.add_people(pessoas, num_pessoas);

			result = jogo.pimPamPum();

			if(result.equals("Carlos"))
			{
				System.out.println("O Carlos nao se livrou");
			}
			else
			{
				System.out.println("O Carlos livrou-se (coitado do " + result + "!)");
			}
		}

		stdin.close();
	}
}