import java.util.Scanner;

public class Game
{
	private char[] data;
	private int n;

	Game(int n)
	{
		data = new char[n][n];
		n = this.n;
	}

	public Game read(Scanner stdin)
	{
		for(int i =0; i<n;i++)
		{
			String next = stdin.next();
			for(int j=0;j<n;j++)
			{
				data[i][j] = next.chatAt(j);
			}
		}
	}

	public Game check()
	{

	}

	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		Game g = new Game(n);
		g.read(stdin);
		g.check();
	}

}