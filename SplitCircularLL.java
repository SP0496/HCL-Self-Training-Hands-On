class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SplitCircularLL {

    public static void splitList(Node head) {
        if (head == null || head.next == head) {
            return;
        }

        Node slow = head;
        Node fast = head;

        // Find midpoint
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For even number of nodes
        if (fast.next.next == head) {
            fast = fast.next;
        }

        // Set heads of two halves
        Node head1 = head;
        Node head2 = slow.next;

        // Break into two circular lists
        fast.next = head2;
        slow.next = head1;

        // Print both lists
        System.out.println("First half:");
        printList(head1);

        System.out.println("Second half:");
        printList(head2);
    }

    // Helper to print circular list
    public static void printList(Node head) {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        // Create circular list: 1->2->3->4->5->(back to 1)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Make it circular
        head.next.next.next.next.next = head;

        splitList(head);
    }
}