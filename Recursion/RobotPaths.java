import java.util.*;

// Given a NxN grid, a robot on the top left corner that can only move right and down
// Give possible paths, how many
public class RobotPaths{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n;

    while(true){
      n = sc.nextInt();
      System.out.println("Possible paths: "+getPathsNumber(n,n));
      printPaths(n,n,"");
    }
  }

  public static void printPaths(int n, int m, String prevPath){
    if(n == 1 && m == 1) { return; }
    else if(n == 1){
        System.out.print(prevPath);
        while(m > 1){
            System.out.print(" right");
            m--;
        }
        System.out.println();
    }
    else if(m == 1){
        System.out.print(prevPath);
        while(n > 1){
            System.out.print(" down");
            n--;
        }
        System.out.println();
    }
    else{
        printPaths(n-1, m, prevPath + " down");
        printPaths(n, m-1, prevPath + " right");
    }
  }

  public static int getPathsNumber(int n, int m){
    if(n == 1 && m == 1) {return 0;}
    else if(n == 1) { return 1;}
    else if(m == 1) { return 1;}
    else{
        return getPathsNumber(n-1,m)+getPathsNumber(n,m-1);
    }
  }

}
