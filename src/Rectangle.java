public class Rectangle
{
    Point pinf, psup;

   	Rectangle(int x1, int y1, int x2, int y2)
   	{
   		pinf = new Point(x1,y1);
   		psup = new Point(x2,y2);
   	}

   	Rectangle(Point p1, Point p2)
   	{
   		pinf = p1;
   		psup = p2;
   	}

   	public int area()
   	{
   		return ((psup.x-pinf.x)*(psup.y-pinf.y));
   	}

   	public int perimeter()
   	{
   		return (2*(psup.x-pinf.x)+2*(psup.y-pinf.y));
   	}

   	boolean pointInside(Point p)
   	{
   		return (p.x <= psup.x && p.x >= pinf.x && p.y <= psup.y && p.y >= pinf.y);
   	}

   	boolean rectangleInside(Rectangle r)
   	{
   		return (pointInside(r.pinf) && pointInside(r.psup));
   	}
}