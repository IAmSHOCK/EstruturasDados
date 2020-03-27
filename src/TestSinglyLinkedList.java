// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples
// Ultima alteracao: 01/04/2018
// -----------------------------------------------------------

public class TestSinglyLinkedList 
{
   public static void main(String[] args) 
   {
      // Criacao de lista de inteiros
      SinglyLinkedList<Character> list  = new SinglyLinkedList<Character>();
      list.addLast('a');
      list.addLast('b');
      list.addLast('c');
      System.out.println(list);
      list.duplicate();
      System.out.println(list);
   }
}
