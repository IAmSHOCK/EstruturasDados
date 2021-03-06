// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class BTree<T> {   
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

   public int numberLeafs()
   {
      return numberLeafs(root);
   }

   private int numberLeafs(BTNode<T> n)
   {
      if(n.getLeft() == null && n.getRight() == null) return 1;
      if(n.getRight() != null && n.getLeft() == null) return numberLeafs(n.getRight());
      if(n.getLeft() != null && n.getRight() == null) return numberLeafs(n.getLeft());
      return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
   }

   public boolean strict()
   {
      return strict(root);
   }

   private boolean strict(BTNode<T> n)
   {
      if(n.getLeft() == null && n.getRight() == null) return true;
      if(n.getRight() != null && n.getLeft() == null) return false;
      if(n.getLeft() != null && n.getRight() == null) return false;
      return strict(n.getLeft()) && strict(n.getRight());
   }

   public T path(String s) 
   {
      BTNode <T> curr = root;
      for (int i = 0; i < s.length(); i++) 
      {
         if(s.charAt(i) == 'E') curr = curr.getLeft();
         else if(s.charAt(i) == 'D') curr = curr.getRight();
         else if(s.charAt(i) == 'R') curr = root;
      }
      return curr.getValue();
   }

   public int internal()
   {
      if(root == null) return 0;
      return this.numberNodes() - this.numberLeafs();
   }

   public void cut(int d)
   {
      if(d <= 0) 
      {
         root = null;
         return;
      }
      else if(this.depth() < d) return;
      
      while(this.depth() >= d)
      {
         cut(root);
         d--;
      }
      

   }

   private void cut(BTNode<T> n)
   {
      BTNode<T> l = n.getLeft();
      BTNode<T> r = n.getRight();
   }

    public void tree() {
      tree(root);
      System.out.println();
   }

   private void tree(BTNode<T> n) {
      if (n==null) 
      {
         System.out.print(" N");
         return;
      }
      System.out.print(" " + n.getValue() );
      tree(n.getLeft());
      tree(n.getRight());
   }

   public int count()
   {
      return count(root);
   }

   private int count(BTNode<T> n)
   {
      int num = 0;
      if(n.getLeft() != null && n.getRight() == null) return (1 + count(n.getLeft()));
      if(n.getLeft() == null && n.getRight() != null) return (1 + count(n.getRight()));
      if(n.getLeft() == null && n.getRight() == null) return 0;
      else
      {
         return (count(n.getRight()) + count(n.getLeft()));
      }
  }

   static int maxlvl;
  public int level(T v)
  {  

      maxlvl = -2;
      level(root, v, 0);
      return maxlvl;
  }

  private void level(BTNode<T> n, T v, int size)
  {
      if(n != null)
      {
         if(n.getValue() == v && size > maxlvl) maxlvl = size;
         level(n.getRight(), v, size+1);
         level(n.getLeft(), v, size+1);
      }
      else return;
  }
}
