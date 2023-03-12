import java.util.*;

/**
 * This class uses only one queue to implement a stack.
 */
class Stack {
    Queue<String> queue = new LinkedList<>();

    /**
     * Implementation of push operation of stack using single queue.
     * This method pushes the item into the queue
     * and then pops all the items already present in the queue from the front (excluding latest inserted item)
     * and pushes them to back of the queue.
     *
     * @param item - item to be pushed in the queue
     */
    void push(String item) {
        int size = queue.size();
        queue.add(item);
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    /**
     * Pops one element from top of the stack and returns it.
     */
    void pop() {
        if (queue.isEmpty())
            return;
        queue.remove();
    }

    /**
     * @return top most item in the stack.
     */
    String top() {
        if (queue.isEmpty())
            return null;
        return queue.peek();
    }

    /**
     * @return size of the stack.
     */
    int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("Purchase Milk");
        System.out.println(s.top());
        s.push("Do laundry");
        System.out.println(s.top());
        s.pop();
        System.out.println("current size of the stack: " + s.size());
        System.out.println(s.top());
        s.push("Learn coding");
        s.pop();
        System.out.println("current size of the stack: " + s.size());
    }
}
