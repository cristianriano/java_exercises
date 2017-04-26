import java.util.*;

// Guess a sequence of 4 values red (R), yellow (Y), green (G) or blue (B).
public class Hits{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String solution = "YYGB";
    String guess;

    while(true){
      guess = sc.nextLine();
      getHitsAndPseudoHits(solution, guess);
    }
  }

  public static void getHitsAndPseudoHits(String solution, String guess){
    int hits=0, pseudoHits=0;
    char c;
    for(int i=0; i<solution.length(); i++){
        c = guess.charAt(i);
        if(solution.charAt(i) == c){ hits++;}
        if(solution.contains(String.valueOf(c))) {pseudoHits++;}
    }
    pseudoHits -= hits;
    System.out.println("Hits: "+hits);
    System.out.println("Pseudo-hits: "+pseudoHits);
    System.out.println("Solution: "+solution);
  }

}
