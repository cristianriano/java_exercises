
import java.util.*;

// Returns true is a word is Palindrome if you change just one letter
public class RepeatCharacters{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);

    String line;
    boolean flag;

    while((line = sc.nextLine()) != null){
      System.out.println(removeDupChars(line.toCharArray()));
    }
  }

  // Remove repeated chars
  public static String removeDupChars(char[] array){
      if(array == null) return null;
      if(array.length < 2) return new String(array);


      for(int i=0; i<array.length; i++){
          for(int j=i+1; j<array.length; j++){
              if(array[i] == array[j]){
                  array[j] = '0';
              }
          }
      }
      return new String(array);
  }

}
