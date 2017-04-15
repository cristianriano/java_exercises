import java.util.*;

// A List for nodes at each depth
public class TreeToList{

  static ArrayList<ArrayList<Integer>> lists;

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;

    Node root = null;

    while((line = sc.nextLine()) != null){
      char c = line.charAt(0);

      if(c == 'a'){     // Add node
        int n = new Integer(line.split(" ")[1]);

        if(root == null)
          root = new Node(n);
        else
          root.insert(n);
      }
      else if(c == 'p'){    // Print tree
        inorden(root);
        System.out.println();
      }
      else if(c == 'l'){     // Is balanced
        buildLists(root);
        printLists();
      }
    }

  }


  public static void buildLists(Node root){
      lists = new ArrayList<ArrayList<Integer>>();
      preOrder(root, 0);
  }


  public static void preOrder(Node node, int distance){
      if(node == null) return;
      if(lists.size() < distance+1){
          ArrayList<Integer> list = new ArrayList<Integer>();
          list.add(node.value);
          lists.add(list);
      }
      else{
          lists.get(distance).add(node.value);
      }
      preOrder(node.left, distance+1);
      preOrder(node.right, distance+1);
  }

  public static void printLists(){
      List<Integer> list;
      for(int i=0; i<lists.size(); i++){
          System.out.println("List of depth "+i);
          list= lists.get(i);
          for(int j=0; j<list.size(); j++){
              System.out.print("["+list.get(j)+"]");
          }
          System.out.println();
      }
  }

  public static void inorden(Node root){
    if(root == null)
      return;
    else
      inorden(root.left);
      System.out.print(root.value+" ");
      inorden(root.right);
  }

}

class Node{
  int value;
  Node left;
  Node right;

  public Node(int n){
    value = n;
    right = left = null;
  }

  void insert(int n){
    if(n < value){  // If the value is less then goes to left side
      if(left == null)
        left = new Node(n); // If there is no left node then insert it
      else
        left.insert(n); // If there is left node then recursively insert to the left node
    }
    else if(n > value){
      if(right == null)
        right = new Node(n);
      else
        right.insert(n);
    }
  }

}
