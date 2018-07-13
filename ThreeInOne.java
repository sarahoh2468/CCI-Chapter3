public class ThreeInOne {
    /* Describe how you could use a single array to implement three stacks */
    public static int numStacks = 3;
    public static int sizeOfStack;
    public static Integer[] values;
    public ThreeInOne(int size) {
        sizeOfStack = size;
        values = new Integer[numStacks*sizeOfStack];

    }
    public void push(int value, int stackNum) {
        if (!isEmpty(stackNum)) {
            throw new IllegalArgumentException();
        }
        int place = (stackNum -1)*sizeOfStack;
        while (values[place] != null) {
            place++;
        }
        values[place] = value;
    }
    public int pop(int stackNum) {
        int place = (stackNum-1)*sizeOfStack;
        int deleted;
        if (!isEmpty(stackNum)) {
            deleted = values[sizeOfStack*stackNum];
            values[sizeOfStack*stackNum] = null;
            return deleted;
        }
        while (values[place+1] != null) {
            place++;
        }
        deleted = values[place];
        values[place] = null;
        return deleted;
    }
    public int peek(int stackNum) {
        int place = (stackNum-1)*sizeOfStack;
        while (values[place] != null) {
            place++;
        }
        return values[place-1];
    }
    public boolean isEmpty(int stackNum) {
        if (values[sizeOfStack*stackNum] != null) {
            return false;
        }
        return true;
    }
}
