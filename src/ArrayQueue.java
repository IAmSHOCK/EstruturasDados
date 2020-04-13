// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Implementacao de Pilha usando array
// Ultima alteracao: 06/04/2018
//
// Nota: o Java proibe a criacao de arrays genericos. Para efeitos
// de demonstracao, usamos aqui um array de Objects e um cast
// (que prova um aviso de compilacao que e "evitado" com a linha do
// Supress Warning). De um modo geral, para genericos, o ideal seria
// Nao usar um array "nativo", mas sim algo como um ArrayList, mas
// aqui queriamos demonstrar como podia ser feito.
// -----------------------------------------------------------

import java.util.Arrays;

public class DoubleArrayQueue<T> implements MyQueue<T> {
   public static final int CAPACITY = 1000; // Capacidade padrao   
   private T[] data;  // Array para conter elementos
   private T[] data2;
   private int size;  // Quantidade de elementos

   DoubleArrayQueue() {
      this(CAPACITY);
   }

   @SuppressWarnings("unchecked")
   DoubleArrayQueue(int capacity) {
      data = (T[]) new Object[capacity];
      size = 0;
   }
   
   public void enqueue(T v) {
      if (size >= data.length) throw new RuntimeException("Stack is full");
      data[size++] = v;
   }
   
   public T dequeue() {
      if (isEmpty()) return null;
      T number = data[0];
      for(int i = 0; i < size-1; i++)
      {
         data[i] = data[i+1];
      }
      size--;
      return number;
   }
   
   public T first() { return data[0];}
   public int size() {return size;}
   public boolean isEmpty() {return (size==0);}

   public String toString() {
      String str = "[";
      for (int i=size-1; i>=0; i--) {
         str += data[i];
         if (i>0) str += ",";
      }
      str += "]";
      return str;
   }
}