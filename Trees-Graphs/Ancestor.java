import java.util.*;

// First ancestor of 2 nodes (not neccesarilly a search tree)
public class Ancestor{

  static Node root = null;

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;

    int n,m;
    Node tmp;

    while((line = sc.nextLine()) != null){
      char c = line.charAt(0);

      if(c == 'a'){     // Add node
        n = new Integer(line.split(" ")[1]);

        if(root == null)
          root = new Node(n);
        else
          root.insert(n);
      }
      else if(c == 'p'){    // Print tree
        inorden(root);
        System.out.println();
      }
      else if(c == 'f'){     // Find ancestor
        n = new Integer(line.split(" ")[1]);
        m = new Integer(line.split(" ")[2]);

        tmp = findAncestor(n,m);
        System.out.println("Ancestor: "+tmp.value);
      }
    }

  }


  public static Node findAncestor(int node1, int node2){
    Stack<Node> stack1 = fillStack(node1);
    Stack<Node> stack2 = fillStack(node2);

    // while(!stack1.isEmpty()) {System.out.println(stack1.pop().value);}
    // System.out.println("");
    // while(!stack2.isEmpty()) {System.out.println(stack2.pop().value);}

    Node tmp;
    while(!stack1.isEmpty()){
        tmp = stack1.pop();
        if(stack2.search(tmp) > 0) return tmp;
    }
    return null;
  }

  public static Stack<Node> fillStack(int node){
      if(root == null) return null;
      // else if(node == null) return null;
      else{
          Stack<Node> stack = new Stack<Node>();
          Node tmp = root;
          Map visited = new HashMap<Node, Boolean>();
          visited.put(root, true);
          stack.push(root);
          while(!stack.isEmpty()){
              if(tmp.value == node) return stack;
              if(tmp.left != null && !visited.containsKey(tmp.left)){
                  tmp = tmp.left;
                  visited.put(tmp, true);
                  stack.push(tmp);
              }
              else if(tmp.right != null && !visited.containsKey(tmp.right)){
                  tmp = tmp.right;
                  visited.put(tmp, true);
                  stack.push(tmp);
              }
              else {
                tmp = (tmp == stack.peek()) ? stack.pop() : stack.peek();
              }
          }
          return null;
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
