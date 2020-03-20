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
		BigNumber soma = new BigNumber("");
		for(int k=0; k<size+1; k++) soma.number[k]=0;

		if(this.size > n.size) 
			{
				int difSize = this.size - n.size;
				n.transform(difSize);
			}
		else if(this.size < n.size)
		{
			int difSize = n.size - this.size;
			transform(difSize);
		}
		soma.size = this.size+1;

		int tmp;
		for(int i=0; i<this.size; i++)
		{
			
			if((tmp = this.number[i]+n.number[i]) > 9) 
			{
				soma.number[i]   += tmp%10;
				soma.number[i+1] += tmp/10;
			}
			else 
			{
				soma.number[i]+=this.number[i]+n.number[i];
			}
			if(soma.number[i]>9)
			{
				soma.number[i+1] += soma.number[i]/10; 
				soma.number[i]   = soma.number[i]%10;
			}
		}
		if(soma.number[size]==0) soma.size--;

		this.redo();
		n.redo();

		return soma;
	}

	private void transform(int difSize)
	{

		for(int i=size; i<(size+difSize); i++)
			{
				number[i]=0;
			}
			size+=difSize;
	}
	public void redo()
	{
		int i = this.size;
		while(this.number[i]==0)
		{
			i--;
		}
		this.size=i+1;
	}

	public BigNumber multiply(BigNumber n)
	{	
		
	}
}