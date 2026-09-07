
public class AddTwoNumber {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    int carry = 0;
    // 1. Add all numbers and add to curr and update carry when needed
    while (l1 != null && l2 != null) {
      int sum = l1.data + l2.data + carry; 

      if (sum >= 10) {
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        carry = 1;
      }
      else {
        curr.next = new ListNode(sum);
        curr = curr.next;
        carry = 0;
      }
      
      l1 = l1.next;
      l2 = l2.next;
    }

    // 3. Add remaning of l1
    while (l1 != null) {
      int sum = l1.data + carry;

      if (sum >= 10) {
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        carry = 1;
      } 
      else {
        curr.next = new ListNode(sum);
        curr = curr.next;
        carry = 0;
      }

      l1 = l1.next;
    }

    // 4. ADD remaining node of l2
    while (l2 != null) {
      int sum = l2.data + carry;

      if (sum >= 10) {
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        carry = 1;
      } 
      else {
        curr.next = new ListNode(sum);
        curr = curr.next;
        carry = 0;
      }

      l2 = l2.next;
    }

    // 5. If last element produces carry then add 1 on the end
    if (carry == 1) {
      curr.next = new ListNode(1);
      curr = curr.next;
    }

    // 6. Re-initialize the pointer
    curr = dummy.next;
    return curr;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(9);
    l1.next.next = new ListNode(9);
    l1.next.next.next = new ListNode(9);

    ListNode l2 = new ListNode(9);
    l2.next = new ListNode(9);
    l2.next.next = new ListNode(9);

    ListNode node = addTwoNumbers(l1, l2);
    // print list
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
 * Time complexity: O(n)
 *    We are running loop for n times.
 * 
 * Space complexity: O(1)
 *    If we do not consider the ans linked list, where we create new list in each iteration.
 */
