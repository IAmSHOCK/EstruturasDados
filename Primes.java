public class Primes
{
	static boolean isPrime(int n)
	{
		for(int i=2; i*i<n; i++)
		{
			if(n%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) 
	{

		int n=20;
		System.out.print(n "= ");
		for (int i=3; i*i<=n; i++)
		{
			if (isPrime(i))
			{
				if (n%i==0)
				{
					n=n/i;
					System.out.print();
				}
			}
		}
	}
}