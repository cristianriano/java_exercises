import java.util.*;

// Penies, print all representations of n cents
// 1, 5, 10, 25
public class Cents{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;

    while(true){
      n = sc.nextInt();
      System.out.println("Ways: "+makeChange(n, 25));
    }
  }


  public static int makeChange(int n, int denom){
    int nextDenom = 0;
    switch(denom){
        case 25:
            nextDenom = 10;
            break;
        case 10:
            nextDenom = 5;
            break;
        case 5:
            nextDenom = 1;
            break;
        case 1:
            return 1;
    }
    int ways = 0;
    for(int i=0; i*denom <= n; i++)
        ways += makeChange(n - (i*denom), nextDenom);
    return ways;
  }

}
