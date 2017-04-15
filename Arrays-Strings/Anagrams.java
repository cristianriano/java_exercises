
import java.util.*;

// Without using a buffer evaluate if one word is an anagram of another
public class Anagrams{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);

    String line, line2;
    boolean flag;

    while(true){
      line = sc.nextLine();
      line2 = sc.nextLine();

      flag = areAnagrams(line, line2);
      System.out.println(flag);
    }
  }

  // Two strings are anagrams or not
  public static boolean areAnagrams(String s1, String s2){
      if(s1.length() != s2.length()) return false;
      char[] array1 = s1.toCharArray();
      char[] array2 = s2.toCharArray();
      quick(0, array1.length - 1, array1);
      printArray(array1);
      quick(0, array2.length - 1, array2);
      printArray(array2);
      String s1Sorted = new String(array1);
      String s2Sorted = new String(array2);

      return s1Sorted.equals(s2Sorted);
  }

  // Quicksort
  public static void quick(int first, int last, char[] array){
    int i=first,j=last;
    char tmp;
    int pivot = (first+last)/2;
    while(i<=j){
        while(array[i] < array[pivot]) i++;
        while(array[j] > array[pivot]) j--;

        if(i<=j){
          tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
          i++;
          j--;
        }
    }
    if(first<j)
      quick(first, j, array);
    if(i<last)
      quick(i, last, array);
  }

  // Print array
  public static void printArray(char[] array){
      for(int i=0; i<array.length; i++){
        System.out.print("["+Character.getNumericValue(array[i])+"] ");
      }
      System.out.println();
    }
}
