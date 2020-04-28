public class MyIntSet implements IntSet
{
	Boolean elem[];
	int size;
	MyIntSet()
	{
		elem = new Boolean[1001];
		size = 0;
		for(int i=0; i<1001;i++) elem[i]=false;
	}

	public boolean contains(int x)
	{
		return elem[x];
	}

	public boolean add(int x)
	{
		if(!contains(x))
		{
			elem[x] = true;
			size++;
			return true;
		}
		return false;
	}

	public boolean remove(int x)
	{
		if(contains(x))
		{
			elem[x] = false;
			size--;
			return true;
		}
		return false;
	}

	public int size()
	{
		return size;
	}

	public void clear()
	{
		for(int i=0; i<elem.length; i++)
		{
			elem[i] = false;
		}
		size = 0;
	}

	public String toString() 
	{
        String res = "{";
        for (int i=0; i<elem.length; i++) 
        {
      		if (i>0) res += ",";
      		if(elem[i]) res+=i;
        }
        res += "}";
        return res;
    }
}