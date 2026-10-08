import java.util.ArrayList;
public class Map {
   private ArrayList<Point> points = new ArrayList<Point>();

   public ArrayList<Point> getPoints() { return points; }

   public Point addPoint(String name, int x, int y) {
      Point p = new Point(name, x, y);
      points.add(p);
      return p;
   }

   public Point getPoint(String name) {
      for (Point p : points) if (p.getName().equals(name)) return p;
      return null;
   }

   public void connect(Point a, Point b) {
      if (!a.getNeighbors().contains(b)) a.getNeighbors().add(b);
      if (!b.getNeighbors().contains(a)) b.getNeighbors().add(a);
   }

   public void print() {
      System.out.println("Road connections:");
      for (Point p : points) {
         System.out.print(p.getName());
         if (p.isBlocked()) System.out.print(" [blocked]");
         System.out.print(": ");
         if (p.getNeighbors().isEmpty()) System.out.print("no connections");
         for (int i = 0; i < p.getNeighbors().size(); i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(p.getNeighbors().get(i).getName());
         }
         System.out.println();
      }
   }
}
