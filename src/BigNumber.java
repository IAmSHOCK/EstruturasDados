import java.util.Scanner;

public class BigNumber
{
	int number[];
	int size;

	BigNumber(String n)
	{
		int k,i;
		number = new int[1000];
		size=n.length();
		for(i=n.length()-1, k=0; i>=0; i--, k++)
		{
			number[k] = (n.charAt(i)-'0');
		}
	}

	public boolean equals(BigNumber n)
	{
		if(size!=n.size) return false;
		for(int i=0; i<size; i++)
		{
			if(number[i]!=n.number[i]) return false;
		}
		return true;
	}

	public String toString()
	{
		String res="";
		for (int i=size-1; i>=0 ;i-- ) 
		{
			res+=number[i];
		}
		return res;
	}

	public BigNumber add(BigNumber n)
	{
		BigNumber soma = new BigNumber("0")
		System.out.println(soma);

		if(size > n.size) 
			{
				int difSize = size - n.size;
				transform(difSize);
			}
		else  
		{
			int difSize = n.size - size;
			n.transform(difSize);
		}

		int tmp;
		for(int i=size; i>=0; i--)
		{
			if(soma.number[i]>9)
			{
				soma.number[i-1] += soma.number[i]/10; 
				soma.number[i]   += soma.number[i]%10;
			}

			if((tmp = number[i]+n.number[i]) > 9) 
			{
				soma.number[i]   += tmp%10;
				soma.number[i-1] += tmp/10;
			}
			else 
			{
				soma.number[i]+=number[i]+n.number[i];
			}
		}
		return soma;
	}

	public void transform(int difSize)
	{

		for(int i=size-1; i<difSize; i++)
			{
				number[i]=0;
			}
			size+=difSize;
	}

	/*public BigNumber multiply(BigNumber n)
	{	

	}*/

	public static void main(String[] args)
	{
		Scanner input = new Scanner (System.in);
		BigNumber n1 = new BigNumber("1234567890");
      	System.out.println(n1); // Escreve "1234567890"

      	BigNumber n2 = new BigNumber("42");
      	BigNumber n3 = new BigNumber("1234567890");
      	System.out.println(n1.equals(n2)); // Escreve "false"
      	System.out.println(n1.equals(n3)); // Escreve "true"
      
      	BigNumber n4 = new BigNumber("46711237126582920746212");
      	BigNumber n5 = new BigNumber("8765432110");
      	BigNumber n6 = n1.add(n3);
      	System.out.println(n6); // Escreve "2469135780"
      	BigNumber n7 = n1.add(n4);
      	System.out.println(n7); // Escreve "46711237126584155314102"
      	BigNumber n8 = n1.add(n5);
      	System.out.println(n8); // Escreve "10000000000"

      

      	
   }
}