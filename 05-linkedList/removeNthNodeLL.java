
import structures.ListNode;
// Qn: Remove nth node from the end of the list

public class removeNthNodeLL {  

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    
    // 1. calculate len of the linked list
    ListNode curr = head;
    int size = 0;
    while (curr != null) {
      size++;
      curr = curr.next;
    }

    // 2. Edge case: Removing the head node
    if (n == size) {
      return head.next;
    }

    // 3. Traverse to the (size - n) th node 
    curr = head;
    for (int i = 1; i < size - n; i++) {
      curr = curr.next;
    }

    // 4. Unlink the target node
    curr.next = curr.next.next;
     
    return head;
  } 

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    // print list
    ListNode node = removeNthFromEnd(head, 2);
    while (node != null) {
      System.out.print(node.val);

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
 *    We are running the loop for n times
 * 
 * Space complexity: O(1)
 *    We are not using extra space
 */
