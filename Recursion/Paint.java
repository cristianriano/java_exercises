import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

// Given a point start painting from there until you find a point of that color
public class Paint{

  static int[][] screen;
  static int width;
  static int height;

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int x,y, color;
    String line;

    System.out.println("Screen height: ");
    height = sc.nextInt();
    System.out.println("Screen width: ");
    width = sc.nextInt();

    screen = new int[height][width];
    fillRandom();

    sc.nextLine();
    while((line = sc.nextLine()) != null){
      char c = line.charAt(0);

      if(c == 'p') { printScreen(); }
      else if(c == 'f'){
        x = new Integer(line.split(" ")[1]);
        y = new Integer(line.split(" ")[2]);
        color = new Integer(line.split(" ")[3]);

        paintFill(x,y,color, screen[y][x]);
        printScreen();
      }
      else if(c == 'r')
        fillRandom();
    }
  }

  public static void paintFill(int x, int y, int color, int oldColor){
    if(x < 0 || y < 0 || x >= width || y >= height) { return; }
    else if(screen[y][x] == color) { return; }
    else if(screen[y][x] == oldColor){
        screen[y][x] = color;
        paintFill(x+1, y, color, oldColor);
        paintFill(x-1, y, color, oldColor);
        paintFill(x, y+1, color, oldColor);
        paintFill(x, y-1, color, oldColor);
    }
  }

  public static void printScreen(){
    for(int i=0; i<height; i++){
      for(int j=0; j<width; j++){
        System.out.print("["+screen[i][j]+"] ");
      }
      System.out.println();
    }
  }

  public static void fillRandom(){
    for(int i=0; i<height; i++){
      for(int j=0; j<width; j++){
        screen[i][j] = ThreadLocalRandom.current().nextInt(1, 6);
      }
    }
  }

}
