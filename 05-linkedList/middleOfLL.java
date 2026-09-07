public class middleOfLL {

  public static ListNode middleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(5);

    ListNode mid = middleNode(head);
    
    System.out.println(mid.data);
  }
}

/**
 * Time complexity: O(N)
 * 
 * Space complexity: O(N)
 */
