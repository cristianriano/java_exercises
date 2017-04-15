import java.util.*;

// Hanoi Towers
public class Hanoi{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;

    int towersNumber = 3;


    while(true){
      System.out.println("Enter disks number:");
      int disks = sc.nextInt();
      Tower[] towers = new Tower[3];
      for(int i=0; i<3; i++) towers[i] = new Tower(i+1);
      for(int i=disks; i > 0; i--) towers[0].addDisk(i);
      towers[0].moveDisks(disks, towers[2], towers[1]);
    }

  }
}

class Tower{
  Stack<Integer> disks;
  int index;
  public Tower(int n){
    index = n;
    disks = new Stack<Integer>();
  }

  public void addDisk(int n){
    if(!disks.isEmpty() && disks.peek() < n)
      System.out.println("Can't move "+n+" to tower "+index);
    else
      disks.push(n);
  }

  public void moveTopTo(Tower destination){
    int disk = disks.pop();
    destination.addDisk(disk);
    System.out.println("Move disk "+disk+" from "+index+" to "+destination.index);
  }

  public void moveDisks(int disks, Tower destination, Tower buffer){
    if(disks > 0){
      moveDisks(disks - 1, buffer, destination);
      moveTopTo(destination);
      buffer.moveDisks(disks - 1, destination, this);
    }
  }
}
