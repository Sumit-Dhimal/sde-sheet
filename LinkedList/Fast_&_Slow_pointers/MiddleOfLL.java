import structures.ListNode;

public class MiddleOfLL {
  
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


    ListNode mid = middleNode(head);
    
    System.out.println(mid.val);
  }
}
