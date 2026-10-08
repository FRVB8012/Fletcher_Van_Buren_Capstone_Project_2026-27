import java.util.ArrayList;

public class Client {
   private Map map = new Map();

   public Map getMap() { return map; }

   //Finds the route with the fewest roads; all roads count equally for now.
   public Path pathfinder(Point a, Point b) {
      Path path = new Path();
      if (!map.getPoints().contains(a) || !map.getPoints().contains(b)) return path;
      if (a == null || b == null || a.isBlocked() || b.isBlocked()) return path;
      ArrayList<Point> queue = new ArrayList<Point>();
      ArrayList<Point> previous = new ArrayList<Point>();
      queue.add(a);
      previous.add(null);
      
      for (int i = 0; i < queue.size(); i++) {
         Point p = queue.get(i);
         if (p == b) break;
         for (Point next : p.getNeighbors()) {
            if (!next.isBlocked() && !queue.contains(next)) {
               queue.add(next);
               //Each parent has the same list index as its point in the queue.
               previous.add(p);
            }
         }
      }
      if (!queue.contains(b)) return path;
      //Trace backward from the end, adding each point to the front of the path.
      for (Point p = b; p != null; p = previous.get(queue.indexOf(p))) path.getPoints().add(0, p);
      return path;
   }

   public static void main(String[] arg) {
      Client client = new Client();
      Map map = client.getMap();
      //Sample intersections: coordinates describe location, not connections.
      Point start = map.addPoint("Home", 0, 0), end = map.addPoint("School", 7, 4), park = map.addPoint("Park", 2, 5), bridge = map.addPoint("Bridge", 4, -2), market = map.addPoint("Market", 6, 1), library = map.addPoint("Library", 8, -1);
      map.connect(start, park);
      map.connect(park, end);
      map.connect(start, bridge);
      map.connect(bridge, market);
      map.connect(market, end);
      map.connect(market, library);
      map.connect(library, end);
      Path path = client.pathfinder(start, end);
      map.print();
      if (path.getPoints().isEmpty()) System.out.println("\nNo route from " + start.getName() + " to " + end.getName() + ".");
      else path.print();
   }
}
