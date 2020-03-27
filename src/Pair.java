public class Pair<A,B>
{
	private A x;
	private B y;

	Pair(A x, B y)
	{
		this.x = x;
		this.y = y;
	}

	public String toString()
	{
		String str = "("+x+","+y+")";
		return str;
	}
}