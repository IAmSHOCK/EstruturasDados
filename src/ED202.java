import java.util.Scanner;

class ED202
{
	static int nLocais;
	static String[] locais;
	static float[][] matriz;
	static boolean[] used; 
	static int[] perm;

	static int solve(int curr)
	{
		if (cur == v.length)
		{
			for (int i=0;i<locais.length ;i++ ) 
			{
				
			}
		}
		else
		{

		}
	}

	static void input(Scanner in)
	{
		nLocais = in.nextInt();
		locais = new String[nLocais];
		for (int k=0; k<nLocais; k++) 
			locais[k] = in.next();	
		matriz = new float[nLocais][nLocais];
		for (int i=0; i<nLocais; i++) 
			for (int j=0; j<nLocais; j++) 
				matriz[i][j] = in.nextFloat();
		boolean used[] = new boolean[nLocais];
		perm[] = new int[nLocais];
	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		input(in);
		solve(0);
	}
}