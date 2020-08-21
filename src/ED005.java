import java.util.Scanner;

public class ED005
{
	public static void solve(String s)
	{
		MyStack<Integer> stack = new LinkedListStack<>();
		char ch;
		int num1;
		int num2;
		int result = 0;

		for (int i=0; i<s.length() ; i++)
		{
			ch = s.charAt(i);
			if(ch >= '0' && ch <= '9') stack.push(ch-'0');	
			else if(!Character.isSpace(ch))
			{
				if(stack.size() < 2) 
				{
					System.out.println("Expressao Incorrecta");
					return;
				}
				num1 = stack.pop();
				num2 = stack.pop();
				switch(ch)
				{
					case '*':
						result = num1 * num2;
						break;

					case '/':
						result = num1 / num2;
						break;

					case '+':
						result = num1 + num2;
						break; 

					case '-':
						result = num1 - num2;
						break; 
				}
				stack.push(result);
			}
		}				
		stack.pop();
		if(stack.isEmpty()) System.out.println(result);
		else 
		{
			System.out.println("Expressao Incorrecta");
		}
	}

	public static void main(String[] args) 
	{
		int n;
		Scanner stdin = new Scanner(System.in);

		n = stdin.nextInt();


		String s;
		s = stdin.nextLine();

		for(int i=0; i<n; i++)
		{
			s = stdin.nextLine();
			solve(s);
		}
	}
}