// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
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

   public T get(int pos)
   {
      if(pos<0) return null;
      Node<T> cur = first;
      for(int i=1; i<=pos; i++)
      {
         cur = cur.getNext();
         if(cur==null) return null;
      }
      return cur.getValue();
   }

   public T remove(int pos)
   {
      if(pos<0 || pos>size || size==0) return null;
      Node<T> cur = first;
      if(pos==0)
      {
         T valor = cur.getValue();
         first = first.getNext();
         size--;
         return valor;
      } 
      for(int i=1; i<pos; i++)
      {
         cur = cur.getNext();
         if(cur==null) return null;
      }
      if(cur.getNext()==null) return null;
      T valor = cur.getNext().getValue();
      cur.setNext(cur.getNext().getNext());
      size--;
      return valor;
   }

   public SinglyLinkedList<T> copy()
   {
      SinglyLinkedList<T> s = new SinglyLinkedList<>();

      if(isEmpty()) return s;

      Node <T> cur = first;
      while(cur!=null)
      {
         s.addLast(cur.getValue());
         cur = cur.getNext();
      }
      return s;
   }

   public void duplicate()
   {
      Node<T> cur=first;
      while(cur!=null)
      {
         Node<T> newNode = new Node<>(cur.getValue(), cur.getNext());
         cur.setNext(newNode);
         cur = cur.getNext().getNext();
         size++;
      }
   }

   public int count(T value)
   {
      int count = 0;
      Node<T> cur = first;
      while(cur!=null)
      {
         if(cur.getValue().equals(value))count++;
         cur = cur.getNext();
      }
      return count;
   }

   public void removeAll(T value)
   {
      Node<T> cur = first;
      if(cur==null) return;

      while(cur != null && (cur.getValue()).equals(value)) 
         {
            first=first.getNext();
            cur = first;
            size--;
         }
      if(first==null) return;
      while(cur.getNext()!=null)
      {
         if(cur.getNext().getValue().equals(value))
         {
            cur.setNext(cur.getNext().getNext());
            size--;
         }
         else 
            cur = cur.getNext();
      }
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
}