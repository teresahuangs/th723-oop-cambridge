public class SinglyLinkedList {

    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(int element) {
        if (head == null) {
            head = new Node(element);
        } else {
            head = new Node(element, head);
        }
        size++;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public int getHead() {
        if (head != null) {
            return head.value;
        } else {
            throw new IllegalStateException("The list is empty.");
        }
    }

    public int getNthElement(int n) {
        if (n < 0 || n >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        Node current = head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int getLength() {
        return size;
    }

    public boolean hasCycle() {
        if (head == null || head.next == null) {
            return false; 
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 

            if (slow == fast) {
                return true;
            }
        }

        return false; 
}

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.value);
            current = current.next;
            if (current != null) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(5);
        list.addFirst(10);
        list.addFirst(15);

        System.out.println("List: " + list);
        System.out.println("Length: " + list.getLength());
        System.out.println("Head: " + list.getHead());
        System.out.println("2nd Element: " + list.getNthElement(1));

        list.removeFirst();
        System.out.println("List after removing the head: " + list);
    }
}
