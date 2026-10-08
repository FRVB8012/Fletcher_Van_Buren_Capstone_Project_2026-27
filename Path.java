import java.util.ArrayList;

public class Path {
   private ArrayList<Point> points = new ArrayList<Point>();

   public ArrayList<Point> getPoints() { return points; }

   public void print() {
      if (points.isEmpty()) { System.out.println("No route found."); return; }
      System.out.print("\nRoute: ");
      for (int i = 0; i < points.size(); i++) {
         if (i > 0) System.out.print(" -> ");
         System.out.print(points.get(i).getName());
      }
      System.out.println("\nRoads used: " + (points.size() - 1) + "\n\nDirections:");
      printDirections();
   }

   public void printDirections() {
      if (points.isEmpty()) return;
      if (points.size() == 1) { System.out.println("Already at the destination."); return; }
      String lastDirection = "";
      for (int i = 1; i < points.size(); i++) {
         String direction = direction(points.get(i - 1), points.get(i));
         String action = "Turn";
         if (i == 1) action = "Head";
         else if (direction.equals(lastDirection)) action = "Continue";
         System.out.print(i + ". ");
         if (direction.isEmpty()) System.out.println("Continue to " + points.get(i).getName() + ".");
         else System.out.println(action + " " + direction + " to " + points.get(i).getName() + ".");
         lastDirection = direction;
      }
      System.out.println(points.size() + ". Arrive at " + points.get(points.size() - 1).getName() + ".");
   }

   //Increasing x means east, increasing y means north.
      private String direction(Point a, Point b) {
      String direction = "";
      if (b.getY() > a.getY()) direction = "north";
      else if (b.getY() < a.getY()) direction = "south";
      if (b.getX() > a.getX()) direction += "east";
      else if (b.getX() < a.getX()) direction += "west";
      return direction;
   }
}
