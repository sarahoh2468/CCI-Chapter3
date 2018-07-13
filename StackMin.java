import java.util.Stack;

public class StackMin {
    /* How would you design a stack which, in addition to push and pop, has a function min which returns the minimum
    element? Push, pop and min should all operate in O(1) time
     */
    Stack<Integer> stack;
    Integer min;

    public StackMin() {
        stack = new Stack<Integer>();
    }
    public void push(Integer value) {
        if (stack.isEmpty()) {
            min = value;
            stack.push(value);
            return;
        }
        if (value < min) {
            stack.push(2*value - min);
            min = value;
        }
        else {
            stack.push(value);
        }
    }
    public Integer pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Integer deleted = stack.pop();
        if (deleted < min) {
            min = 2*min - deleted;
        }
        return deleted;
    }
    public Integer peek() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Integer result = stack.peek();
        if (result < min) {
            result = min;
        }
        else {
            return result;
        }
    }
    public Integer getMin() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }
        else {
            return min;
        }
    }
}