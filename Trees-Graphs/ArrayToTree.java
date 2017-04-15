import java.util.*;

// From a sorted array (ASC) create binary tree with minimal height
public class ArrayToTree{

  static Node root;

  public static void main(String... args){
    int[] array = {1,2,3,4,5,6,7,8,9};
    printArray(array);

    root = arrayToTree(array);
    inorden(root,0);
  }

  static public void insertBisectionToTree(int first, int last, int[] array){
    if(first == last) {root.insert(array[first]);}
    if(first < last){
        int pivot = (first+last)/2;
        root.insert(array[pivot]);
        insertBisectionToTree(first, pivot-1, array);
        insertBisectionToTree(pivot+1, last, array);
    }
  }

  static public Node arrayToTree(int[] array){
      if(array == null) return null;
      else if(array.length == 1) return new Node(array[0]);
      else{
          int pivot = (array.length - 1)/2;
          root = new Node(array[pivot]);
          insertBisectionToTree(0, pivot+1, array);
          insertBisectionToTree(pivot-1, array.length-1, array);
          return root;
      }
  }

  public static void inorden(Node node, int distance){
    if(node == null)
      return;
    else{
      inorden(node.left, distance+1);
      System.out.println("["+node.data+"] -> "+distance);
      inorden(node.right, distance+1);
    }
  }



  // Print array
  public static void printArray(int[] array){
      for(int i=0; i<array.length; i++){
        System.out.print("["+array[i]+"] ");
      }
      System.out.println();
  }

}


class Node{
    Node left;
    Node right;
    int data;

    public Node(int d){
        data = d;
        right = left = null;
    }

    void insert(int n){
      if(n < data){  // If the data is less then goes to left side
        if(left == null)
          left = new Node(n); // If there is no left node then insert it
        else
          left.insert(n); // If there is left node then recursively insert to the left node
      }
      else if(n > data){
        if(right == null)
          right = new Node(n);
        else
          right.insert(n);
      }
    }
}
