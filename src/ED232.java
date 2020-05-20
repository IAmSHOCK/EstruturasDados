  //------------------------------------------------------------------------------------
// Nome: João Aires
// Número: 201905175
//------------------------------------------------------------------------------------
// Reverse:
// Ciclo para percorrer todos os nos, ao adicionar o valor na primeira posiçao ele
// no final da o reverso da lista.
//
// Occurrences:
// Ciclo para percorrer todos os nos, se o valor do no currente for igual ao elem,
// coloca-se o index no array. Dentro deste if tem outro que verifica se o array esta
// cheio e se sim, aumenta-o (cria um novo maior e passa a informação do antigo para 
// o recente).
//
// Remove:
// Se o valor do curr for igual ao valor da lista que tem os valores a remover, o no
// anterior passa a apontar para o seguinte do seguinte.
// Se nao, avança-se o no da lista que tem os valores a remover, e verifica-se outra
// vez.
// Este algoritmo remove todas as ocurrencias menos se o valor estiver no first, dai
// o ciclo a seguir.
// Neste metodo, tive a ajuda do Nazar num bug.
//------------------------------------------------------------------------------------

import java.util.Arrays;
   class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }
   
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first); 
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null); 
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);         
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }
   
   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }

   public SinglyLinkedList<T> reverse()
   {
      SinglyLinkedList<T> rev = new SinglyLinkedList<>();
      Node<T> cur = first;
      while (cur != null) 
      {
         rev.addFirst(cur.getValue());
         cur = cur.getNext();
      }
      return rev;      
   }

   public int[] occurrences(T elem)
   {
      int array_size = 1;
      Node<T> cur = first;
      int[] array = new int[array_size];
      int index = 0;
      int j = 0;
      Boolean null_flag = true;
      
      while(cur != null)
      {
         if(cur.getValue().equals(elem))
         {
            if (j == array_size) 
            {
               array = array_grow(array, array_size); 
               array_size++;
            }
            null_flag = false;
            array[j++] = index;
         }

         cur = cur.getNext();
         index++;
      }
      if(null_flag) return null;
      return array;
   }

   private static int[] array_grow(int[] old_array, int array_size)
   {
      int[] array = new int[array_size+1];
      for(int i=0; i < array_size; i++)
      {
         array[i] = old_array[i];
      }
      return array;
   }

   public void remove(SinglyLinkedList<T> toRemove)
   {

      if(first == null) return;
      Node<T> cur        = this.first.getNext();
      Node<T> prev       = this.first;
      Node<T> cur_remove = toRemove.first;
      while(cur!= null)
      {
         while(cur_remove != null) 
         {
            if(cur.getValue().equals(cur_remove.getValue()))
            {
               prev.setNext(cur.getNext());        
               this.size--;
               cur = prev;
               break;
            }
            else
            {
               cur_remove = cur_remove.getNext();
            }
         }
         cur_remove = toRemove.first;
         prev = cur;
         cur = cur.getNext();
      }
      //remover o 1 elemento se ele for igual a um dos val de toRemove
      cur_remove = toRemove.first;
      while(cur_remove.getNext() != null) 
      {
         if(this.first.getValue().equals(cur_remove.getValue())) this.removeFirst();
         cur_remove = cur_remove.getNext();
      }
   }
}