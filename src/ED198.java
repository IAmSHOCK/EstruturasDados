import java.util.Scanner;

public class ED198
{

   static int[] input(Scanner in, int[] nums)
   {
      for (int i = 0; i < nums.length ; i++) 
      {
         nums[i] = in.nextInt();   
      }
      return nums;
   }

   public static void solve(int[] v, int n)
   {
      int[] best = new int[n];
      best[0] = v[0];
      int i;
      int max = v[0];
      for (i=0; i<n-1; i++) // Todas as posicoes iniciais possiveis
      {
         if(best[i] >= 0) best[i+1] = best[i] + v[i+1];
         else best[i+1] = v[i+1];
         if(max < best[i]) max = best[i];
      }
      System.out.println(max);
   }

   public static void main(String[] args) 
   {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] nums = new int[n];
      nums = input(in, nums);
      solve(nums, n);
   }
}