import java.util.*;

// Print a number from 0 - 999.999 in english
public class NumberInEnglish{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;

    while(true){
      n = sc.nextInt();
      printNumberInEnglish(n);
    }
  }

  public static void printNumberInEnglish(int n){
    if(n == 0){
      System.out.println("cero");
      return;
    }
    for(int i=100000; i>0; i = i/10){
        if(n/i != 0){
          if(i == 10000 || i == 10){
              if(n/i != 1)
                System.out.print(tensInEnglish(n/i)+" ");
              else{
                i = i/10;
                System.out.print(tensInEnglish(n/i)+" ");
              }
          }
          else{
              System.out.print(unitsInEnglish(n/i)+" ");
          }
          if(i==100 || i == 100000) {System.out.print("hundred ");}
          else if(i == 1000) {System.out.print("thousand ");}
          n -= (n/i) * i;
        }
    }
    System.out.println();
  }

  public static String tensInEnglish(int n){
    switch(n){
        case 2:
            return "twenty";
        case 3:
            return "thirty";
        case 4:
            return "fourty";
        case 5:
            return "fivety";
        case 6:
            return "sixty";
        case 7:
            return "seventy";
        case 8:
            return "eighty";
        case 9:
            return "ninety";
        case 10:
            return "ten";
        case 11:
            return "eleveen";
        case 12:
            return "twelve";
        case 13:
            return "thirteen";
        case 14:
            return "fourteen";
        case 15:
            return "fiveteen";
        case 16:
            return "sixteen";
        case 17:
            return "seventeen";
        case 18:
            return "eighteen";
        case 19:
            return "nineteen";
        default:
            return "";
    }
  }

  public static String unitsInEnglish(int n){
    switch(n){
        case 1:
            return "one";
        case 2:
            return "two";
        case 3:
            return "three";
        case 4:
            return "four";
        case 5:
            return "five";
        case 6:
            return "six";
        case 7:
            return "seven";
        case 8:
            return "eight";
        case 9:
            return "nine";
        default:
            return "";
    }
  }

}
