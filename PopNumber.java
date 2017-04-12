import java.util.*;

// Gets an array of numbers and returns the most repetead
// If there is a tie, then returns the lower one
public class PopNumber{

  public static void main(String... args){
    Integer[] numbers = {1,3,3,5,5,5,3};
    Integer x = NumMasPopular(numbers, 4);
    System.out.println(x);
  }

  public static Integer NumMasPopular(Integer[] values, int n){
    Map<Integer, Integer> repetitions = new HashMap<>();
    Integer oldValue = -1;
    Integer maxRepetitions = 0;
    Integer newValue = 0;
    Integer maxRepited = -1;
    for(Integer value : values){
      oldValue = repetitions.get(value);
      if(oldValue == null){
        repetitions.put(value, 1);
        newValue = 1;
      }
      else{
        newValue = ((Integer) oldValue) + 1;
        repetitions.put(value, newValue);
      }

      if(newValue > maxRepetitions){
        maxRepetitions = newValue;
        maxRepited = value;
      }
      else if(newValue == maxRepetitions && maxRepited > value){
        maxRepetitions = newValue;
        maxRepited = value;
      }
    }
    return maxRepited;
  }

}
