import java.util.Scanner
public class SopaDeLetras
{
	int lines;
	int cols;
	char[][] data;
	int nwords;
	String words[];

	SopaDeLetras(int line, int col)
	{
		lines  = line;
		cols   = col;
		data   = new char[line][col];
		nwords = 0;
		words  = new String [nword];
	}

	public void read()
	{

	}

	public void search(char ch)
	{
		
	}

	public void print(int n)
	{

	}

	public static int main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		int lines, cols;
		SopaDeLetras game = new SopaDeLetras(stdin.nextInt(),stdin.nextInt());
		game.read();
		game.search();
		game.print(num);
		if(stdin.hasNext("00")) return;
	}

}