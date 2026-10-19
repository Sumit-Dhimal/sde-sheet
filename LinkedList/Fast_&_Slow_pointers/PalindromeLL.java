import structures.ListNode;

/**
 * Logic: 
 *      - Find the middle of the linked list
 *      - Divide the linked list into two halves
 *      - Reverse the second half
 *      - Compare first half and second half (reversed)
 *      - if similar palindrome otherwise not
 */

public class PalindromeLL {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next; // dummy

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        
        // base case
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode reversedSecondHalf = reverseList(slow.next);
        ListNode firstHalf = head;
        ListNode secondHalf = reversedSecondHalf;
        
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        slow.next = reverseList(reversedSecondHalf); // making it in its original form

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println( "The linked list is palindrome: " + isPalindrome(head));
    }
}
