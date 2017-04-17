import java.util.*;

// Get subsets from a set
public class Subsets{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;
    String line;
    char c;
    ArrayList<Integer> set = new ArrayList<>();
    ArrayList<ArrayList<Integer>> subsets;

    while((line = sc.nextLine()) != null){
      c = line.charAt(0);
      if(c == 'a'){
        n = new Integer(line.split(" ")[1]);
        set.add(n);
      }
      else if(c == 'p'){
        printSubset(set);
      }
      else if(c == 's'){
        subsets = getSubsets(set);
        for(int i=0; i<subsets.size(); i++)
          printSubset(subsets.get(i));
      }
    }
  }


  public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> elements){
      ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> currentSubset = new ArrayList<>();
      ArrayList<Integer> elementsCopy = new ArrayList<>(elements);
      addElement(0, elementsCopy, subsets, currentSubset);
      return subsets;
  }

  public static void addElement(int index, ArrayList<Integer> elements, ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> currentSubset){
      if(index < elements.size()){
          int element = elements.get(index);
          ArrayList<Integer> currentSubset2 = new ArrayList<>(currentSubset);
          currentSubset.add(element);
          addElement(index+1, elements, subsets, currentSubset);
          addElement(index+1, elements, subsets, currentSubset2);
      }
      else{
        if(currentSubset.size() > 0)
          subsets.add(currentSubset);
      }
  }

  public static void printSubset(ArrayList<Integer> subset){
      for(int i =0; i<subset.size(); i++)
          System.out.print("["+subset.get(i)+"] ");
      System.out.println();
  }

}
