
import structures.ListNode;



public class StartOfCycle {

    /**
     * Logic for this solution (this is self solved)
     * 
     *      - take fast, slow, and check pointer
     *      - fast moves with speed of 2, slow moves with speed of 1, 
     *      - check pointer is used as a checkpoint to check start of cycle
     *      - for every position check if the cycle starts from there or not
     */
    
    /*
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;


        ListNode check = head;
        ListNode fast = head;
        ListNode slow = head;

        while (check != null && check.next != null) {
            
            while (fast.next != null && fast.next.next != null) {
                
                slow = slow.next;
                fast = fast.next.next;
                
                if (check == fast || check == slow) {
                    return check;
                }
                
                // loop ender
                if (slow == fast) {
                    break;
                }
            }

            fast = check.next;
            slow = check.next;
            check = check.next;
        }

        return null;
    }
    */
    
    /*
        Time complexity: O(N^2)
        Space complexity: O(1)
    */


    // Floyd's cycle start algorithm
    
    /**
     * Logic:
     *      - find the meet point to make sure if it has cycle or not
     *      - think the mid point as middle of Linked List, as fast and slow can find mid point
     *      - now make the slow pointer point to start, leave the fast pointer where it is
     *      - then update both of them by 1. 
     * 
     * Simple: Half (meet point to loop start) + Half (start to loop start) = Full
     */

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //phase-1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                //phase-2: find the cycles starting point
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return slow;
            }
        }

        return null;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);

        // creating cycle
        head.next.next.next.next = head.next;
        
        System.out.println("Start of the cycle is: " + detectCycle(head).val);
    }
}
