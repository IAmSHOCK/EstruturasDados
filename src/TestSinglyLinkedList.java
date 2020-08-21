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
      SinglyLinkedList<Character> list  = new SinglyLinkedList<>();
      
      list.addLast('a');
      list.addLast('b');
      list.addLast('c');
      list.addLast('d');
      list.addLast('e');
      list.shift(4);
      System.out.println(list);
      SinglyLinkedList<Integer> list2  = new SinglyLinkedList<>();
      list2.addLast(1);
      list2.addLast(2);
      list2.addLast(42);
      list2.shift(0);
      System.out.println(list2);


   }
}
