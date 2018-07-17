import java.util.Stack;

public class QueueViaStacks {
    /* implement a myqueue class which implements a queue using two stacks */
    Stack<Integer> newer;
    Stack<Integer> older;

    public QueueViaStacks() {
        newer = new Stack<Integer>();
        older = new Stack<Integer>();
    }

    public void add(Integer value) {
        newer.push(value);
    }
    private void shiftStacks() {
        if (older.isEmpty()) {
            while (!newer.isEmpty()) {
                older.push(newer.pop());
            }
        }
    }
    public int peek() {
        shiftStacks();
        return older.peek();
    }
    public int remove() {
        shiftStacks();
        return older.pop();
    }
}
