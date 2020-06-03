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
         BTree<Integer> t1, t2, t3, t4, t5;
         t1 = t2 = t3 = t4 = t5 = t;
         t.cut(3);
         t.tree();
         t1.cut(2);
         t1.tree();
         t2.cut(1);
         t2.tree();
         t3.cut(0);
         t3.tree();
         t4.cut(-1);
         t4.tree();
         t5.cut(42);
         t5.tree();
      }   
   }
}
