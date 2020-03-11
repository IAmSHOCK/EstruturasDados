import java.util.Scanner;

public class MorseCode
{
    public static String CodetoText  (char ch)
    {
        if(!Character.isLowerCase(ch))
        {
            ch=Character.toLowerCase(ch);
        }
        switch(ch)
        {
            case 'a':
                return ".-";
            case 'b':
                return "-...";
            case 'c':
                return "-.-.";
            case 'd':
                return "-..";
            case 'e':
                return ".";
            case 'f':
                return "..-.";
            case 'g':
                return "--.";
            case 'h':
                return "....";
            case 'i':
                return "..";
            case 'j':
                return ".---";
            case 'k':
                return "-.-";
            case 'l':
                return ".-..";
            case 'm':
                return "--";
            case 'n':
                return "-.";
            case 'o':
                return "---";
            case 'p':
                return ".--.";
            case 'q':
                return "--.-";
            case 'r':
                return ".-.";
            case 's':
                return "...";
            case 't':
                return "-";
            case 'u':
                return "..-";
            case 'v':
                return "...-";
            case 'w':
                return ".--";
            case 'x':
                return "-..-";
            case 'y':
                return "-.--";
            case 'z':
                return "--..";
            default: return null;
        }
    }

    public static void main(String[] args)
    {
        char c;
        String palavra;
        int i = 0;
        Scanner stdin = new Scanner(System.in)     ;
        while(stdin.hasNext())
        {
            palavra = stdin.next();
            while(i!=palavra.length())
            {
                c = palavra.charAt(i);
                i++;
                System.out.print(CodetoText(c));
            }
            if(i!=(palavra.length()-1) && palavra.length() > 1)
            {
                System.out.println();
            }
            i=0;
            System.out.println("     ");
        }
        stdin.close();
    }
}
