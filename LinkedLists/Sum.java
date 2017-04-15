import java.util.*;

// Sum 2 linkedlists assuming each position is a single digit
public class Sum{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int[] values1 = {3,1,2};
    int[] values2 = {5,9,5};

    String line;
    Node list1 = new Node(2);
    Node list2 = new Node(4);
    // Load the list with costume values
    for(int n:values1)
      addNode(list1, n);
    for(int n:values2)
      addNode(list2, n);

    printList(list1);
    printList(list2);

    Node list3 = sumLinkedLists(list1, list2);
    printList(list3);

    // while((line = sc.nextLine()) != null){
    //   flag = isCasiPalindrome(line);
    //   System.out.println(flag);
    // }
  }

  public static Node sumLinkedLists(Node n1, Node n2){
    Node i = n1, j = n2;
    int extra = 0, tmp;
    Node sum, k;
    sum = new Node();
    k = sum;
    while(i != null && j != null){
        tmp = i.data + j.data + extra;
        k.data = tmp % 10;
        extra = tmp/10;
        i = i.next;
        j = j.next;
        k.next = new Node();
        k = k.next;
    }
    if(i != null){
        while(i != null){
            tmp = i.data + extra;
            k.data = tmp % 10;
            extra = tmp / 10;
            i = i.next;
            k.next = new Node();
            k = k.next;
        }
    }
    if(j != null){
        while(j != null){
            tmp = j.data + extra;
            k.data = tmp % 10;
            extra = tmp / 10;
            j = j.next;
            k.next = new Node();
            k = k.next;
        }
    }
    k.data = extra;
    return sum;
  }

  public static void addNode(Node node, int d){
    if(node.next == null)
      node.next = new Node(d);
    else
      addNode(node.next, d);
  }

  public static void printList(Node node){
    Node tmp = node;
    while(tmp != null){
      System.out.print("["+tmp.data+"] ");
      tmp = tmp.next;
    }
    System.out.println();
  }

}

class Node{
  Node next = null;
  int data;
  public Node() {}
  public Node(int d) {data = d;}
  public void addNode(int d){
    Node n = this;
    Node end = new Node(d);
    while(n.next != null) { n = n.next; }
    n.next = end;
  }
}
