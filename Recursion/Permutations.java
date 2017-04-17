import java.util.*;

// Permutations of a String
public class Permutations{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;

    while(true){
      line = sc.nextLine();
      System.out.println("----");
      printPermutations("", line);
    }
  }



  public static void printPermutations(String prev, String s){
    if(s == null || s.length() < 1) { return;}
    else if(s.length() == 1){
        System.out.print(prev);
        System.out.print(s);
        System.out.println();
    }
    else{
        String tmp, substring;
        for(int i=0; i<s.length(); i++){
            tmp = s.substring(i, i+1);
            substring = s.substring(0,i) + s.substring(i+1, s.length());
            printPermutations(prev+tmp, substring);
        }
    }
  }

}
