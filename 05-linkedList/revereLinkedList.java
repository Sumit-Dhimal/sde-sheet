

public class revereLinkedList {
  public static ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    ListNode next;
    
    // Traverse all nodes of the linked list
    while (curr != null) {

      // store next
      next = curr.next;

      // reverse node's next pointer
      curr.next = prev;

      // move pointer one position ahead
      prev = curr;
      curr = next;
    }

    return prev;
  }

  public static void main(String[] args) {
    
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(5);

    head = reverseList(head);
    
    // print list
    ListNode node = head;
    while (node != null) {
      System.out.print(node.data);

      if (node.next != null) {
        System.out.print("->");
      }
      
      // increment node
      node = node.next;
    }
  }  
}

/**
 * Time complexity: O(N)
 * 
 * Space complexity: O(N)
 */
