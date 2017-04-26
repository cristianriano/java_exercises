import java.util.*;
import java.lang.Math;

// Random subset
public class RandomSet{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;

    ArrayList<Integer> array = new ArrayList<>();
    int n;

    while((line = sc.nextLine()) != null){
      char c = line.charAt(0);

      if(c == 'a'){     // Add value
        n = new Integer(line.split(" ")[1]);
        array.add(n);
      }
      else if(c == 'p'){    // Print list
        printList(array);
      }
      else if(c == 's'){     // Subset
        n = new Integer(line.split(" ")[1]);

        printList(randSet(array, n));
      }
    }

  }

  public static ArrayList<Integer> randSet(List<Integer> array, int n){
    int index=0,tmp;
    int length = array.size();
    ArrayList<Integer> subset = new ArrayList<>();
    while(index < n){
        tmp = (int)(Math.random() * (length-index) + index);
        subset.add(array.get(tmp));
        array.set(tmp, array.get(index));
        array.set(index, subset.get(index));
        index++;
    }
    return subset;
  }

  public static void printList(ArrayList<Integer> list){
    for(int i=0; i<list.size(); i++){
      System.out.print("["+list.get(i)+"]");
    }
    System.out.println();
  }

}
