import java.util.Scanner;

public class ReadNumbers {

    // Escrever os numeros guardados num array no stdout
    static double media(int v[])
    {
        double media = 0;
        for (int i=0; i<v.length; i++)
        {
            media+=v[i];
        }
        return (media/v.length);
    }

    static int amplitude(int v[])
    {
        int max=0, min=v[1];
        for(int i=0; i<v.length; i++)
        {
            if (v[i] > max)
            {
                max = v[i];
            }
            if (v[i] < min) {
                min = v[i];
            }
        }
        return (max-min);
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem
        int v[] = new int[n];     // Cria um novo array com espaço para 10 inteiros

        for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
            v[i] = stdin.nextInt();

        System.out.printf("%.2f\n", media(v));
        System.out.println(amplitude(v));
    }
}