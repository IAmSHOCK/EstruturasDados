public class losango
{
	public static void losango(int n)
	{
		int star = 1;
		int space = (n-1)/2;

		while(space > 0)
		{
			for(int i=1; i<=space;i++)
			{
				System.out.print(" ");
			}
			for (int i=1;i<=star ;i++ ) 
			{
				System.out.print("#");
			}
			space--;
			star+=2;
			System.out.println();
		}
		while(star>0)
		{
			for(int i=1; i<=space;i++)
			{
				System.out.print(" ");
			}
			for (int i=1;i<=star ;i++ ) 
			{
				System.out.print("#");
			}
			star-=2;
			space++;
			System.out.println();			}
	}
	public static void main(String[] args) {
		int n=5;
		losango(n);
	}
}