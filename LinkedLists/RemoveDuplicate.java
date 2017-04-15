import java.util.*;

// Without a buffer. Remove duplicates on an unsroted LinkedList
public class RemoveDuplicate{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int[] values = {4,2,1,7,5,9,1,9,3,8};

    String line;
    Node head = new Node(1);
    // Load the list with costume values
    for(int n:values)
      head.addNode(n);

    printList(head);

    removeDup(head);
    printList(head);
    // while((line = sc.nextLine()) != null){
    //   flag = isCasiPalindrome(line);
    //   System.out.println(flag);
    // }
  }

  // Remove duplicates on unsroted LinkedList
  public static void removeDup(Node head){
      Node i = head, tmp, prev;
      while(i != null){
          tmp = i.next;
          prev = i;
          while(tmp != null){
              if(i.data == tmp.data){
                  prev.next = tmp.next;
                  tmp = tmp.next;
              }
              else{
                  prev = prev.next;
                  tmp = tmp.next;
              }

          }
          i = i.next;
      }
  }

  // public static void addNode(Node head, int d){
  //   System.out.println(d);
  //   if(head == null){
  //     head = new Node(d);
  //     return;
  //   }
  //   if(head.next == null)
  //     head.next = new Node(d);
  //   else
  //     addNode(head.next, d);
  // }

  public static void printList(Node head){
    Node tmp = head;
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
  public Node(int d) {data = d;}
  public void addNode(int d){
    Node n = this;
    Node end = new Node(d);
    while(n.next != null) { n = n.next; }
    n.next = end;
  }
}
