import java.util.*;

// Number of twos until n
public class NumberTwos{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;

    System.out.println("35: "+numberOfTwos(35));
    System.out.println("88: "+numberOfTwos(88));
    System.out.println("150: "+numberOfTwos(150));
    System.out.println("1999: "+numberOfTwos(1999));
    System.out.println("301: "+numberOfTwos(301));
    System.out.println("25: "+numberOfTwos(25));
    System.out.println("222: "+numberOfTwos(222));

  }


  public static int numberOfTwos(int n){
    if(n == 0){ return 0; }
    int scale = 1;
    while(10 * scale < n){ scale *= 10; }

    int value = n/scale;
    int remainder = n%scale;
    int twos = 0, otherTwos;

    if(value > 2) twos += scale;
    else if(value == 2) twos += remainder + 1;

    otherTwos = value * numberOfTwos(scale - 1) + numberOfTwos(remainder);

    return twos + otherTwos;
  }

}
