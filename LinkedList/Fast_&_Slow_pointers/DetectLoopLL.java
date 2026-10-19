import structures.ListNode;

public class DetectLoopLL {
    
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);

        // loop creation - last --> second
        head.next.next.next.next = head.next;

        System.out.println("Linked List has loop: " + hasCycle(head));
    }
}
