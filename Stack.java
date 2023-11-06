import java.util.EmptyStackException;
import java.util.*;

public class newStack<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;
    private int size;

    public stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            result.append(current.data);
            current = current.next;
            if (current != null) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        newStack<Integer> stack = new newStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack: " + stack);
        System.out.println("Size: " + stack.size());
        System.out.println("Top Element: " + stack.peek());

        int popped = stack.pop();
        System.out.println("Popped Element: " + popped);
        System.out.println("Stack after popping: " + stack);
    }
}
