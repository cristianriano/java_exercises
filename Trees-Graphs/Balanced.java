import java.util.*;

// Check if a binary tree is balanced
public class Balanced{

  static int maxDistance;
  static boolean balanced;

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;

    Node root = null;
    boolean flag;

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
      else if(c == 'b'){     // Is balanced
        isBalanced(root);
        System.out.println(balanced);
      }
    }

  }

  // Check if a tree is balanced
  public static void isBalanced(Node root){
      balanced = true;
      maxDistance = -1;
      preOrder(root, 0);
  }

  public static void preOrder(Node n, int distance){
      if(n != null){
        // If the node is a leaf node
        if(n.left == null && n.right == null){
            if(maxDistance == -1)
                maxDistance = distance;
            if(distance < maxDistance-1 || distance > maxDistance+1){
                balanced = false;
                return;
            }
        }
        preOrder(n.left, distance + 1);
        preOrder(n.right, distance + 1);
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
