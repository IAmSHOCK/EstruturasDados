// Uma classe simples para representar um ponto 2D
class Point {
   int x, y;

   Point() {
      x = y = 0;
   }
   
   Point(int x0, int y0) {
      x = x0;
      y = y0;
   }

   // Devolve uma representação em texto do conteúdo de um Ponto
   public String toString() {
      return "(" + x + "," + y + ")";
   }
}

// Classe principal com a função main
public class TestGeometry {
   public static void main (String[] args){
      Point p1 = new Point();
	
      System.out.println("p1 original: " + p1);
      p1.x = 1;
      System.out.println("p1 modificado: " + p1);

      Point p2 = new Point(2,3);
      System.out.println("p2: " + p2);
   }
   public class Rectangle
   {
   		Point pinf, psup;
   		Rectangle(int x1, int y1, int x2, int y2)
   		{
   			pinf.x = x1;
   			pinf.y = y1;
   			psup.x = x2;
   			psup.y = y2;
   		}
   		Rectangle(Point p1, Point p2)
   		{
   			pinf.x = p1.x;
   			pinf.y = p1.y;
   			psup.x = p2.x;
   			psup.y = p2.y;
   		}
   		public int area()
   		{
   			return (psup.x-pinf.x)*(psup.y-pinf.x);
   		}
   		public int perimeter()
   		{
   			return 2*(psup.x-pinf.x)+2*(psup.y-pinf.x);
   		}
   		boolean pointInside(Point p)
   		{
   			if(p.x <= psup.x && p.x >= pinf.x && p.y <= psup.y && p.y >= pinf.y)
   				return true;
   		}
   		boolean rectangleInside(Rectangle r)
   		{
   			if(r.pointInside(r.x)
   		}
   }
}