// Nome: João Aires
// Número: 201905175
// Usei as dicas que estavam na pagina.

import java.util.Scanner;
 
public class ED234
{

	public static void f1(Scanner in)
	{
		int avaliacoes = in.nextInt();
		String movie;
		BSTree<String> tree = new BSTree<>();
		while(in.hasNext())
		{
			tree.insert(in.next());
			in.next();
		}

		System.out.println(tree.numberNodes());
	}
	public static void f2(Scanner in)
	{
		int avaliacoes = in.nextInt();
		Integer value;
		BSTMap<String,Integer> map = new BSTMap<>();
		String s;
		while(in.hasNext())
		{
			s = in.next();
			if((value = map.get(s)) == null)
				map.put(s, 1);
			else
			{
				value++;
				map.put(s, value);
			}
			in.next();
		}

		int max = 0;
		int tmp;
		String print = "";
		for (String k : map.keys())
		{
			if((tmp = map.get(k)) > max) 
			{
				max = tmp; 
				print = k;
			}
		}
		System.out.println(print + " " + max);
	}

	public static void f3(Scanner in)
	{
		int avaliacoes = in.nextInt();
		Integer value;
		BSTMap<String,Integer> map1 = new BSTMap<>();
		BSTMap<String,Integer> map2 = new BSTMap<>();
		String s;
		while(in.hasNext())
		{
			s = in.next();


			if((value = map1.get(s)) == null)
				map1.put(s, 1);
			else
			{
				value++;
				map1.put(s, value);
			}


			int movie = in.nextInt();
			if((value = map2.get(s)) == null)
				map2.put(s, movie);
			else
			{
				value += movie;
				map2.put(s, value);
			}
		}
		int ocur;
		for (String k : map2.keys())
		{
			ocur = map1.get(k);
			if(map2.get(k)/ocur >= 5) System.out.println(k);
		}

	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int flag = in.nextInt();

		switch(flag)
		{
			case 1:
				f1(in);
				break;
			case 2:
				f2(in);
				break;
			case 3:
				f3(in);
				break;
			default: System.out.println("invalid flag");		
		}
	}
}