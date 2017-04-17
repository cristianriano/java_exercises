import java.util.*;

// Fibonacci of number n
public class Fibonacci{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;

    while(true){
      n = sc.nextInt();
      System.out.println("Fibonacci: "+fibonacciOf(n));
    }
  }

  public static int fibonacciOf(int n){
    if(n == 0) return 0;
    else if(n == 1) {return 1;}
    else if(n > 1) {return fibonacciOf(n-1)+fibonacciOf(n-2);}
    else {return -1;}
  }

}
