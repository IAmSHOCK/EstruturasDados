class Fraction
{
	int num;
	int denum;

	Fraction()
	{
		num=denum=0;
	}

	Fraction(int a, int b)
	{
		num=a;
		denum=b;
	}

	public String toString()
	{
		int u=0;
		while(num>=denum)
		{
			num-=denum;
			u+=1;
		}
		if(num==0) return (""+u);
		return (u +" + " + num + "/" + denum );
	}

	public void simplify()
	{
		int p,q,r;
		q=num;
		p=denum;

	 	while (q != 0) 
	 	{
        	r = p%q;
        	p = q;
        	q = r;
       	}
        num = num/p;
        denum = denum/p;
	}

	public Fraction add(Fraction f)
	{
		Fraction result = new Fraction();
		if(denum==f.denum)
		{
			result.denum = denum;
			result.num = num + f.denum;
		}

		else
		{
			result.denum = denum * f.denum;
			result.num = (num*f.denum) + (f.num*denum);
		}
		return result;
	}


	public static void main(String[] args) 
	{
		Fraction n = new Fraction(5,2);
		Fraction m = new Fraction(6,4);
		Fraction add = n.add(m);
		Fraction simple = new Fraction(10,6);
		simple.simplify();
		System.out.println(add);
		System.out.println(simple);		
	}

}