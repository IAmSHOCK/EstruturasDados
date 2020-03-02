import java.util.Scanner;

public class isPalindrome
{
    public static boolean isPalindrome(String dada)
    {
        String str = "";//string ao contrario

        dada=dada.toLowerCase().replaceAll("[^a-z]" , "");// retirar carateres n letra minuscula
        
        for(int j=dada.length()-1; j>=0; j--)
        {
           str += dada.charAt(j);
        }
        return (str.equals(dada));

    }
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);

        int N = stdin.nextInt();

        String str = new String();
        System.out.println(N);
        str = stdin.nextLine();

        while(stdin.hasNextLine())
        {
            str = stdin.nextLine();
            if(isPalindrome(str))
            {
                System.out.println("sim");
            }
            else
            {
                System.out.println("nao");
            }
        }
        stdin.close();
    }
}