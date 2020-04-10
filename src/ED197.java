class ED197
{
	public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b)
	{
		MyQueue<Integer> q = new LinkedListQueue<>();
		while(a.size() > 0 && b.size() > 0)
		{
			if(a.first() < b.first()) q.enqueue(a.dequeue());
			else 
			{
				if(a.first() > b.first()) q.enqueue(b.dequeue());
				else 
				{
					q.enqueue(a.dequeue());
					q.enqueue(b.dequeue());
				}			
			}
		}
		if(a.size() != 0) q.enqueue(a.dequeue());
		else if(b.size() != 0) q.enqueue(b.dequeue());
		return q;
	}

	public static void main(String[] args) 
	{
		MyQueue<Integer> a = new LinkedListQueue<>();
		MyQueue<Integer> b = new LinkedListQueue<>();

		a.enqueue(2);
		a.enqueue(4);
		a.enqueue(8);
		a.enqueue(10);

		b.enqueue(1);
		b.enqueue(4);
		b.enqueue(9);

		System.out.println(merge(a,b));
	}
}