// Uma classe simples para representar um ponto 2D
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
class TestRectangle {
   public static void main(String[] args) {
      Point a = new Point(1,1);
      Point b = new Point(2,2);
      Point c = new Point(3,4);
      Point d = new Point(8,2);
      
      Rectangle amarelo  = new Rectangle(a, c);
      Rectangle laranja  = new Rectangle(2, 3, 9, 6);
      Rectangle verde    = new Rectangle(3, 4, 4, 5);
      Rectangle azul     = new Rectangle(5, 1, 6, 5);
      Rectangle vermelho = new Rectangle(7, 3, 9, 5);
      
      System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
      System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20
      
      System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
      System.out.println("Area do retangulo laranja = " + laranja.area()); // 21                   
      
      System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
      System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false
      
      System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
      System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
      System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true
   }
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
            return false;
   		}
   		boolean rectangleInside(Rectangle r)
   		{
   			if(r.pinf.x >= pinf.x && r.pinf.y >= pinf.y && r.psup.x <= psup.x && r.psup.y <= psup.y)
               return true;
            return false;
   		}
   }