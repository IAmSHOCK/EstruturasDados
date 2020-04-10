class ED196
{
	public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b)
	{
		String currName;
		String currPlace;

		while(q.size() > 0)
		{
			currName  = q.dequeue();
			currPlace = q.dequeue();
			switch(currPlace)
			{
				case "A":
					a.enqueue(currName);
					break;

				case "B":
					b.enqueue(currName);
					break;

				case "X":
					if(a.size() < b.size()) a.enqueue(currName);
					if(b.size() < a.size()) b.enqueue(currName);
					break;
			}

		}
	}
	public static void main(String[] args) 
	{
		MyQueue<String> q = new LinkedListQueue<>();
		MyQueue<String> a = new LinkedListQueue<>();
		MyQueue<String> b = new LinkedListQueue<>();
		q.enqueue("Luis");
		q.enqueue("B");
		q.enqueue("Pedro");
		q.enqueue("A");
		q.enqueue("Luisa");
		q.enqueue("A");
		q.enqueue("Joao");
		q.enqueue("X");
		q.enqueue("Jose");
		q.enqueue("X");
		q.enqueue("Miguel");
		q.enqueue("B");

		System.out.println(q + " " + a + " " + b);
		process(q,a,b);
		System.out.println(q + " " + a + " " + b);

	}
}