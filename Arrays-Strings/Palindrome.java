import java.util.*;

// Returns true is a word is Palindrome if you change just one letter
public class Palindrome{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);

    String line;
    boolean flag;

    while((line = sc.nextLine()) != null){
      flag = isCasiPalindrome(line);
      System.out.println(flag);
    }
  }

  public static boolean isCasiPalindrome(String s){
    int l = s.length() - 1;
    int fails = 0;
    for(int x=0; x< l/2; x++){
      if(s.charAt(x) != s.charAt(l-x))
        fails ++;
      if(fails >= 2)
        return false;
    }
    return true;
  }

}
