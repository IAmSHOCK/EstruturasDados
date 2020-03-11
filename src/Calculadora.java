import java.util.Scanner;

public class Calculadora
{
    public static void escrever(int num)
    {
        String[][] numeros = new String [10][7];
        numeros[0][0] = ".##.";
        numeros[0][1] = "#..#";
        numeros[0][2] = "#..#";
        numeros[0][3] = "....";
        numeros[0][4] = "#..#";
        numeros[0][5] = "#..#";
        numeros[0][6] = ".##.";

        numeros[1][0] = "....";
        numeros[1][1] = "...#";
        numeros[1][2] = "...#";
        numeros[1][3] = "....";
        numeros[1][4] = "...#";
        numeros[1][5] = "...#";
        numeros[1][6] = "....";

        numeros[2][0] = ".##.";
        numeros[2][1] = "...#";
        numeros[2][2] = "...#";
        numeros[2][3] = ".##.";
        numeros[2][4] = "#...";
        numeros[2][5] = "#...";
        numeros[2][6] = ".##.";

        numeros[3][0] = ".##.";
        numeros[3][1] = "...#";
        numeros[3][2] = "...#";
        numeros[3][3] = ".##.";
        numeros[3][4] = "...#";
        numeros[3][5] = "...#";
        numeros[3][6] = ".##.";

        numeros[4][0] = "....";
        numeros[4][1] = "#..#";
        numeros[4][2] = "#..#";
        numeros[4][3] = ".##.";
        numeros[4][4] = "...#";
        numeros[4][5] = "...#";
        numeros[4][6] = "....";

        numeros[5][0] = ".##.";
        numeros[5][1] = "#...";
        numeros[5][2] = "#...";
        numeros[5][3] = ".##.";
        numeros[5][4] = "...#";
        numeros[5][5] = "...#";
        numeros[5][6] = ".##.";

        numeros[6][0] = ".##.";
        numeros[6][1] = "#...";
        numeros[6][2] = "#...";
        numeros[6][3] = ".##.";
        numeros[6][4] = "#..#";
        numeros[6][5] = "#..#";
        numeros[6][6] = ".##.";

        numeros[7][0] = ".##.";
        numeros[7][1] = "#..#";
        numeros[7][2] = "#..#";
        numeros[7][3] = "....";
        numeros[7][4] = "...#";
        numeros[7][5] = "...#";
        numeros[7][6] = "....";

        numeros[8][0] = ".##.";
        numeros[8][1] = "#..#";
        numeros[8][2] = "#..#";
        numeros[8][3] = ".##.";
        numeros[8][4] = "#..#";
        numeros[8][5] = "#..#";
        numeros[8][6] = ".##.";

        numeros[9][0] = ".##.";
        numeros[9][1] = "#..#";
        numeros[9][2] = "#..#";
        numeros[9][3] = ".##.";
        numeros[9][4] = "...#";
        numeros[9][5] = "...#";
        numeros[9][6] = ".##.";

        String number = Integer.toString(num);
        int i=0;
        for (int j = 0; j <= 6 ; j++)
        {
            while(i < number.length())
            {
                System.out.print(numeros[((int)(number.charAt(i)))-48][j]);
                if(i!=(number.length()-1)) System.out.print(' ');
                i++;
            }
            i=0;
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        int numero = stdin.nextInt();
        escrever(numero);
        stdin.close();
    }
}