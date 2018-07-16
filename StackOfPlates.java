import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackOfPlates {
    /* Implement a data structure SetOfStacks that mimics this. Should be composed of several stacks and should create
    a new stack once the previous one exceeds capacity. Push and pop should behave identically to single stack().
    Follow up: implement a function popAt (int index) which performs a pop operation on a specific sub-stack
     */
    ArrayList<Stack> stackOfPlates;

    int capacity;
    public StackOfPlates(int capacity) {
        stackOfPlates = new ArrayList<Stack>();
        this.capacity = capacity;
    }
    public void push(int value) {
        Stack last = getLastStack();
        if (last != null && last.size() < capacity) {
            last.push(value);
        }
        else {
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(value);
            stackOfPlates.add(stack);
        }
    }
    public int pop() {
       Stack last = getLastStack();
       if (last == null) {
           throw new EmptyStackException();
       }
       int result = (int) last.pop();
       if (last.size() == 0) {
           stackOfPlates.remove(stackOfPlates.size()-1);
       }
       return result;

    }
    public int popAt(int index) {
        Stack stack = stackOfPlates.get(index);
        if (stack.size() == 0) {
            stackOfPlates.remove(index);
            throw new IllegalArgumentException();
        }
        else {
            int result = (int) stack.pop();
            return result;
        }

    }
    public Stack getLastStack() {
        if (stackOfPlates.size() == 0) {
            return null;
        }
        return stackOfPlates.get(stackOfPlates.size() -1);
    }
}
