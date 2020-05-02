// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Invertendo um array (versao recursiva)
// Ultima alteracao: 21/04/2018
// -----------------------------------------------------------

import java.util.Arrays;

public class TestReverse {

   // Inverter array v entre posicoes start e end
   static void reverse(int v[], int start, int end) {
      if (start>=end) return;     // Caso base: array de tamanho < 2
      int tmp = v[start];         // Trocar primeiro com ultimo
      v[start] = v[end];
      v[end] = tmp;
      reverse(v, start+1, end-1); // Chamada recursiva para o resto
   }
   
   // -----------------------------------------------------------
   static boolean capicua(int v[], int start, int end)
   {
      boolean cap = false;
      if(start >= end) return (v[start] == v[end]);
      if((v[start] == v[end])) cap = capicua(v, start+1, end-1);
      return cap;
   }

   public static void main(String[] args) {
      int[] v1 = {1, 2, 3, 2, 1};
      int[] v2 = {5, 8, 8, 5};
      int[] v3 = {1, 2, 3, 1};
      int[] v4 = {5, 8, 7, 5};
      System.out.printf("[1, 2, 3, 2, 1] %b %n", capicua(v1, 0, 4));
      System.out.printf("[5, 8, 8, 5] %b %n", capicua(v2, 0, 3));
      System.out.printf("[1, 2, 3, 1] %b %n", capicua(v4, 0, 3));
      System.out.printf("[5, 8, 7, 5] %b %n", capicua(v4, 0, 3));
   }
}
