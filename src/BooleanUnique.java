import java.util.Scanner;

public class BooleanUnique
{
	private BooleanArrayIntSet s;
	int uniqueSize;

	BooleanUnique()
	{
		s = new BooleanArrayIntSet(1000001);
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
		BooleanUnique teste = new BooleanUnique();
		teste.read(stdin);
		System.out.println("Unique numbers: " + teste.uniqueSize);
	}
}