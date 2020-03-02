public class Square
{
	static void line (int n) //linha do inicio e do fim
	{
		char a = '*';
		char b = '-';
		System.out.print(a);
		for(int i=1; i<=n-2; i++)
		{
			System.out.print(b);
		}
		System.out.println(a);
	}
	static void linemeio (int n)
	{
		char a ='|';
		char b =' ';
		System.out.print(a);
		for (int i=1; i<=n-2;i++)
		{
			System.out.print(b);
		}
		System.out.print(a);
	}
	static void square (int n)
	{
		line(5);
		do 
		{
			linemeio(5);
			System.out.println("");
			n--;
		}
		while (n-2!=0);
		line(5);

	}


	public static void main(String[] args) 
	{
		square(10);
	}
}