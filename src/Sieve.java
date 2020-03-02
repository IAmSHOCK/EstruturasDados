public class Sieve
{
	public static  void sieve(int n, boolean prime[])
	{
		for(int i=2; i<n+1; i++)
		{
			if(prime[i])
			{
				for(int j=i+i; j<n+1;j += i)
				{
					prime[j]=false;
				}
			}
		}
	}
	public static void main(String[] args)
	{
		int n= 100000;
		boolean[] prime = new boolean[n+1];
		for(int i=2; i<n+1;i++)
		{
			prime[i]=true;
		}
		sieve(n,prime);
		for(int i=2; i<=n; i++)
		{
			if (prime[i])
			{
				System.out.println(i);
			}
		}
	}
}