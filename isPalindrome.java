import java.util.Scanner;

public class isPalindrome
{
    public static boolean isPalindrome(int N, String dada)
    {
        String str = "";//string ao contrario

        dada=dada.toLowerCase().replaceAll("[^a-z]" , "");// retirar carateres n letra minuscula
        
        for(int j=dada.length()-1; j>=0; j--)
        {
           str += dada.charAt(j);
        }
        if(str.equals(dada))
        {
            return true;
        }
        return false; 
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        String str = new String();

        System.out.println(N);

        for(int i=1;i<=N;i++)
        {
            str = scan.nextLine();
            if(isPalindrome(N,str))
            {
                System.out.println("sim");
            }
            else
            {
                System.out.println("nao");
            }
        }
        scan.close();
    }
}