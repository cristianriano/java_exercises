import java.util.*;

// Next node inOrder given a node. With link to its parent
public class NextInOrder{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;

    Node root = null, tmp;

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
      else if(c == 'n'){     // Print next inOrder
        int n = new Integer(line.split(" ")[1]);
        tmp = search(root, n);
        System.out.println("Next: "+next(tmp).value);
      }
    }

  }


  public static Node next(Node node){
    if(node == null) return null;
    if(node.right != null) return nextInOrder(node.right);
    if(node.parent.value > node.value) return node.parent;
    else{
        while(node.parent.value < node.value){
            node = node.parent;
            if(node == null) return null;
        }
        return node.parent;
    }
  }

  public static Node nextInOrder(Node node){
      if(node != null){
          nextInOrder(node.left);
          return node;
      }
      return null;
  }

  public static void inorden(Node root){
    if(root == null)
      return;
    else
      inorden(root.left);
      System.out.print(root.value+" ");
      inorden(root.right);
  }

  public static Node search(Node node, int value){
    if(node == null) return null;
    if(node.value == value) return node;
    if(value < node.value) return search(node.left, value);
    else return search(node.right, value);
  }

}

class Node{
  int value;
  Node left;
  Node right;
  Node parent;

  public Node(int n){
    value = n;
    right = left = parent = null;
  }

  void insert(int n){
    if(n < value){  // If the value is less then goes to left side
      if(left == null){
        left = new Node(n); // If there is no left node then insert it
        left.parent = this;
      }

      else
        left.insert(n); // If there is left node then recursively insert to the left node
    }
    else if(n > value){
      if(right == null){
        right = new Node(n);
        right.parent = this;
      }
      else
        right.insert(n);
    }
  }

}
