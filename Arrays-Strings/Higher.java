import java.util.*;
import java.util.Collections;

class Higher {

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;

    while(true){
      n = sc.nextInt();
      System.out.println(solution(n));
      // System.out.println(n);
    }
  }

  public static int solution(int n) {
        if(n < 10) {return n;}

        ArrayList<Integer> digits = new ArrayList<>();
        int digit,tmp = n;
        while(tmp > 0){
            digit = tmp % 10;
            tmp = tmp/10;
            digits.add(digit);
        }
        int size = digits.size()-1;
        Collections.sort(digits);
        Collections.reverse(digits);
        int max = 0;

        for(int i=0; i<digits.size(); i++){
          max += digits.get(i) * ((int) Math.pow(10, size));
          size--;
        }

        return max;
    }

    public static void printArray(ArrayList<Integer> array){
      for(int i=0; i<array.size(); i++){
        System.out.print("["+array.get(i)+"] ");
      }
    }
}
