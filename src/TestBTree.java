// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      int num = in.nextInt();
      for(int i = 0; i < num; i++)
      {
         BTree<Integer> t = LibBTree.readIntTree(in);
          System.out.println("t.level(2) " + t.level(2));
          System.out.println("t.level(5) " + t.level(5));
          System.out.println("t.level(1) " + t.level(1));
          System.out.println("t.level(3) " + t.level(3));
      }   
   }
}
