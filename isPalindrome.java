public class isPalindrome
{
    public static boolean isPalindrome(int N, String dada)
    {
        System.out.println(N);
        for(int i=1; i<=N;i++)
        {
        String str = "";//string ao contrario
        dada=dada.toLowerCase().replaceAll("[^a-z]" , "");// retirar carateres n letra minuscula
        for(int j=dada.length()-1; j>=0; j--)
        {
           str += dada.charAt(j);
        }
        if(str.equals(dada))
        {
            System.out.println("sim");;
        }
        System.out.println("nao");
        }
        
    }
    public static void main(String[] args)
    {
        
        isPalindrome(N,String);
    }
}

