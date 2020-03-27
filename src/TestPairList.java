public class TestPairList
{
	public static void main(String[] args)
	{
		SinglyLinkedList<Pair> p = new SinglyLinkedList<Pair>();

		for(int i = 1; i<=3; i++)
		{
			for (int j = 1; j<=3 ;j++ ) 
			{
				p.addLast(new Pair(i,j));
			}
		}
		System.out.println(p);
	}
}