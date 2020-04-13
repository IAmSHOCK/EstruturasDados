import java.util.Scanner;

class ED007
{
	public static void solve(String s)
	{
		MyStack<Character> stack = new LinkedListStack<>();
		char ch, ant;
		int pos = 0;;

		for (int i = 0; i < s.length() ; i++) 
		{
			ch = s.charAt(i);
			switch (ch)
			{
				case '(': case'[':
					//System.out.println("push " + ch);
					stack.push(ch);
					pos++;
					// System.out.println("pos " + pos);
					break;

				case ')': 
					
					if(stack.isEmpty()) 
						{
							System.out.println("Erro na posicao " + pos);
							return;
						}
					else 
					{
						ant = stack.pop();
						// System.out.println("pop " + ant);
						// System.out.println("pos " + pos);
						if(ant != '(') 
							{
								System.out.println("Erro na posicao " + pos);
								return;
							}
						pos++;
						break;
					}

				case ']':
					if(stack.isEmpty()) 
					{
						System.out.println("Erro na posicao " + pos);
						return;
					}
					else
					{	ant = stack.pop();
						// System.out.println("pos " + pos);
						// System.out.println("pop " + ant);
						if(ant != '[') 
						{
							System.out.println("Erro na posicao " + pos);
							return;
						}
						pos++;
					 	break;
					}
				default:
					pos++;
			}
		}

		if(stack.size() > 0) System.out.println("Ficam parenteses por fechar");
		else System.out.println("Expressao bem formada");
	}

	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		int n;
		String s;

		n = stdin.nextInt();
		s = stdin.nextLine();

		for(int i = 0; i < n; i++)
		{
			s = stdin.nextLine();
			// System.out.println(s);
			solve(s);
		}
	}
}