import java.util.Stack;

public class SortStack<T> {
    /* Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary
    stack, but you may not copy the elements into any other data structure
     */
    void sort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int hold = stack.pop();
            while (!temp.isEmpty() && temp.peek() > hold) {
                stack.push(temp.pop());
            }
            temp.push(hold);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}
