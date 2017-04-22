import java.util.*;

// Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
// of n-pairs of parentheses.
public class Parentheses{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;

    while(true){
      n = sc.nextInt();
      printParentheses("(", 1, 0, n);
    }
  }

  public static void printParentheses(String s, int open, int close, int total){
    if(close == total) { return; }
    else if(open == total){
      System.out.print(s);
      for(int i=0; i< total-close; i++) { System.out.print(")"); }
      System.out.println();
      return;
    }
    else{
      printParentheses(s+"(", open+1, close, total);
      if(open > close)
        printParentheses(s+")", open, close+1, total);
    }
  }

}
