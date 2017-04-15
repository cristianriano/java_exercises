import java.util.*;

// Check if there is a path between 2 nodes
public class Path{

  static Graph graph;
  static int nodes, connections;

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Number of nodes:");
    nodes = new Integer(sc.nextLine());
    System.out.println("Number of connections:");
    connections = new Integer(sc.nextLine());

    // Incress number of nodes for the value corresponds with the index
    nodes++;
    graph = new Graph(nodes);

    // Get all connections
    // Format entry: nodeA nodeB (means there is a connection)
    String line;
    int x,y;
    for(int i=0; i<connections; i++){
      line = sc.nextLine();

      x = new Integer(line.split(" ")[0]);
      y = new Integer(line.split(" ")[1]);

      graph.addPath(x,y);
    }

    boolean isPath;
    while(true){
      System.out.println("Find path between:");
      line = sc.nextLine();

      x = new Integer(line.split(" ")[0]);
      y = new Integer(line.split(" ")[1]);

      isPath = routeExists(x,y);
      System.out.println(isPath);
    }

  }

  public static boolean routeExists(int from, int to){
    boolean[] visited = new boolean[nodes];
    Queue<Integer> queue = new LinkedList<Integer>();

    for(int i=0; i<nodes; i++) { visited[i] = false;}
    visited[from] = true;
    queue.offer(from);

    int tmp,visiting;
    ArrayList<Integer> neighboorNodes;

    while(!queue.isEmpty()){
        visiting = queue.remove();
        neighboorNodes = graph.getPathsFromNode(visiting);

        for(int i=0; i<neighboorNodes.size(); i++){
            tmp = neighboorNodes.get(i);
            if(!visited[tmp]){
                if(tmp == to) return true;
                queue.offer(tmp);
                visited[tmp] = true;
            }
        }
    }
    return false;
  }

}


class Graph{
    int[] nodes;
    ArrayList<Integer>[] paths;

    public Graph(int n){
        nodes = new int[n];
        paths = new ArrayList[n];

        for(int i=0; i<n; i++) { paths[i] = new ArrayList<Integer>(); }
    }

    public void addPath(int from, int to){
        paths[from].add(to);
    }

    public ArrayList<Integer> getPathsFromNode(int n){
        return paths[n];
    }
}
