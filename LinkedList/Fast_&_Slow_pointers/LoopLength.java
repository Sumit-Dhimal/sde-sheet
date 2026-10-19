
import structures.Node;

/**
 * Find length of the loop
 * 
 * Logic:
 *      - First detect if the cycle exists or not.
 *      - If the cycle exists, 
 *          take a curr node and initialize with the next of meet point of fast and slow
 *      - Then update curr and also keep count, until (slow/fast) equals to curr
 * 
 * Complexity:
 *      Time = O(N), because loop runs till n times
 *      Space = O(1), we are not using any external space
 * 
 */

public class LoopLength {
    
    public static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int loopCount = 0;

        // phase-1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // loop exists
            if (slow == fast) {

                // phase-2: Find start of cycle
                Node curr = slow.next;
                loopCount = 1;
                while (curr != slow) {
                    curr = curr.next;
                    loopCount++;
                }

                return loopCount;
            }
        }

        return loopCount;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Loop creation
        head.next.next.next.next = head.next;

        System.out.println("Length of loop: " + lengthOfLoop(head));
    }
    
}