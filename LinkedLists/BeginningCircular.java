// Start node on Circular Linked List
public static Node getBeginning(Node first){
    Node n1 = first;
    Node n2 = first;

    while(n2.next != null && n2 != null){
        n1 = n1.next;
        n2 = n2.next.next;
        if(n1 == n2)
            break;
    }

    if(n2 == null || n2.next == null)
        return null;

    n1 = first;
    while(n1 != n2){
        n1 = n1.next;
        n2 = n2.next;
    }
    return n2;
}
