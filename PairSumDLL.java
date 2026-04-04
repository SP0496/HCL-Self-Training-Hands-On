class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class PairSumDLL {

    public static void findPairs(Node head, int target) {
        if (head == null) return;

        Node left = head;
        Node right = head;

        // Move right to last node
        while (right.next != null) {
            right = right.next;
        }

        // Two-pointer search
        while (left != right && right.next != left) {
            int sum = left.data + right.data;

            if (sum == target) {
                System.out.println("(" + left.data + ", " + right.data + ")");
                left = left.next;
                right = right.prev;
            } 
            else if (sum < target) {
                left = left.next;
            } 
            else {
                right = right.prev;
            }
        }
    }

    public static void main(String[] args) {
        // Create DLL: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        int target = 5;

        findPairs(head, target);
    }
}