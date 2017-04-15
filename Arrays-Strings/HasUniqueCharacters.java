
import java.util.*;

// Return true if all characters in a String are unique
public class hasUniqueCharacters{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);

    String line;
    boolean flag;

    while((line = sc.nextLine()) != null){
      flag = hasUniqChars(line);
      System.out.println(flag);
    }
  }

  // A string has all unique characters
  public static boolean hasUniqChars(String s){
      Map occurrences = new HashMap<Character, Integer>();
      char c;
      for(int i=0; i<s.length(); i++){
          c = s.charAt(i);
          if(occurrences.containsKey(c))
              return false;
          else
              occurrences.put(c,0);
      }
      return true;
  }

}
