import java.util.*;

// Swap numbers in place without tmp variables
public class SwapInPlace{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;
    int n,m;
    char c;

    System.out.println("Array size:");
    n = sc.nextInt();
    int[] array = new int[n];
    for(int i=0; i<n; i++){ array[i] = sc.nextInt();}
    sc.nextLine();

    while(true){
      line = sc.nextLine();
      c = line.charAt(0);

      if(c == 's'){  // Swap
        n = new Integer(line.split(" ")[1]);
        m = new Integer(line.split(" ")[2]);
        swap(array,n,m);
      }
      else if(c == 'p'){
        printArray(array);
      }

    }
  }


  public static void swap(int[] array, int x, int y){
    array[x] += array[y];
    array[y] = array[x] - array[y];
    array[x] = array[x] - array[y];
  }

  // Print array
  public static void printArray(int[] array){
      for(int i=0; i<array.length; i++){
        System.out.print("["+array[i]+"] ");
      }
      System.out.println();
    }

}
