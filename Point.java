import java.util.ArrayList;

public class Point {
   private String name;
   private int x, y;
   private boolean blocked;
   private ArrayList<Point> neighbors = new ArrayList<Point>();

   public String getName() { return name; }
   public int getX() { return x; }
   public int getY() { return y; }
   public boolean isBlocked() { return blocked; }
   public ArrayList<Point> getNeighbors() { return neighbors; }
   public void setBlocked(boolean blocked) { this.blocked = blocked; }

   public Point(String name, int x, int y) {
      this.name = name;
      this.x = x;
      this.y = y;
   }
}
