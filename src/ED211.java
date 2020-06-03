import java.util.Scanner;

public class ED211

{
   public static int countEven(BTree<Integer> t)
   {
      if(t.getRoot().getValue() % 2 == 0) return countEven(t, t.getRoot()) + 1;
      return countEven(t, t.getRoot());
   }

   private static int countEven(BTree<Integer> t, BTNode<Integer> n)
   {
      int sum = 0;
      if(n == null) return 0;
      if(n.getRight() == null && n.getLeft() != null) if(n.getLeft().getValue() % 2 == 0) sum++;
      else if(n.getLeft() == null && n.getRight() != null) if(n.getRight().getValue() % 2 == 0) sum++;
      else
      {
         if(n.getRight().getValue() % 2 == 0) sum++;
         if(n.getLeft().getValue() % 2 == 0) sum++;
      }
      return sum + countEven(t, n.getRight()) + countEven(t, n.getLeft());
   }

   public static void main(String[] args) 
   {
      Scanner in = new Scanner(System.in);
      int num = in.nextInt();
      for(int i = 0; i < num; i++)
      {
         BTree<Integer> t = LibBTree.readIntTree(in);
         System.out.println(countEven(t));   
      }   
   }
}
