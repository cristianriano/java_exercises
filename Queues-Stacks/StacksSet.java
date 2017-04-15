import java.util.*;

// Use a set of stacks that behave as a single stack. They should have a max capacity
public class StacksSet{

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    String line;

    System.out.println("Enter the threshold:");
    int threshold = sc.nextInt(), n;
    char option;
    SetOfStacks stack = new SetOfStacks(threshold);
    sc.nextLine();
    while((line = sc.nextLine()) != null){
      option = line.charAt(0);
      if(option == 'a'){
        n = new Integer(line.split(" ")[1]);
        stack.push(n);
      }
      else if(option == 'p'){
        System.out.println("Pop: "+ (int) stack.pop());
      }
    }
  }
}

class SetOfStacks{
    int currentStackIndex, threshold;
    Stack<Object> currentStack;
    List<Stack<Object>> stacks;
    public SetOfStacks(int threshold){
        this.threshold = threshold;
        currentStack = new Stack<Object>();
        stacks = new ArrayList<Stack<Object>>();
        stacks.add(currentStack);
        currentStackIndex = 0;
    }

    public void push(Object o){
        if(currentStack.size() == threshold){
            currentStack = new Stack<Object>();
            currentStackIndex++;
            stacks.add(currentStack);
        }
        currentStack.push(o);
    }

    public Object pop(){
        if(currentStackIndex == 0 && currentStack.isEmpty())
            return null;
        if(currentStack.isEmpty()){
            currentStackIndex--;
            currentStack = stacks.get(currentStackIndex);
            stacks.remove(currentStackIndex + 1);
        }
        return currentStack.pop();
    }

    public Object popAt(int n){
        if(n > currentStackIndex)
            return null;
        return stacks.get(n).pop();
    }
}
