import java.util.Scanner;

public class Unique
{
	private MyIntSet s;
	int uniqueSize;

	Unique()
	{
		s = new MyIntSet(632432);
		uniqueSize = s.size();
	}

	public void read(Scanner stdin)
	{
		while(stdin.hasNextInt())
		{
			s.add(stdin.nextInt());
		}
		uniqueSize = s.size();
	}


	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		Unique teste = new Unique();
		teste.read(stdin);
		System.out.println("Unique numbers: " + teste.uniqueSize);
	}
}