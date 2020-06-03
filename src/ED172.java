import java.util.Scanner;

public class ED172
{
	public static void main(String[] args) 
	{
		BSTMap<String, Integer> map = new BSTMap<>();
		Scanner in = new Scanner(System.in);
		String word = in.next();
		Integer value;

		BSTMapNode<String, Integer> node = new BSTMapNode<>(word, 1, null, null);
		map.setRoot(node);
		while(in.hasNext())
		{
			word = in.next();
			if((value = map.get(word)) == null)
				map.put(word, 1);
			else
			{
				value++;
				map.put(word, value);
			}
		}

		for (String k : map.keys())
		{
			System.out.println(k + ": " + map.get(k));
		}
	}
}