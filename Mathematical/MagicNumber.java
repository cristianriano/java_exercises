import java.util.*;

// Kth number whos prime factors are 3,5,7
public class MagicNumber{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;

    while(true){
      n = sc.nextInt();
      System.out.println("Magic "+n+"th number: "+getKthMagicNumber(n));
    }
  }


  public static int getKthMagicNumber(int k){
    if(k <= 0){ return 0; }
    Queue<Integer> Q3 = new LinkedList<Integer>();
    Queue<Integer> Q5 = new LinkedList<Integer>();
    Queue<Integer> Q7 = new LinkedList<Integer>();
    Q3.add(3);
    Q5.add(5);
    Q7.add(7);
    int val = 1;
    for(k--; k>0; k--){
        val = Math.min(Q3.peek(), Math.min(Q5.peek(), Q7.peek()));
        if(val == Q7.peek()){
            Q7.remove();
        }
        else{
            if(val == Q5.peek()){
                Q5.remove();
            }
            else{
                Q3.remove();
                Q3.add(val * 3);
            }
            Q5.add(val * 5);
        }
        Q7.add(val * 7);
    }
    return val;
  }

}
