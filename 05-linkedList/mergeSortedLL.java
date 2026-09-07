public class mergeSortedLL {

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    
    while (list1 != null && list2 != null) {
      
      // if list1 data is smaller or equal to list2 data add data of list 1
      if (list1.data <= list2.data) {
        curr.next = new ListNode(list1.data);
        list1 = list1.next;
      }

      // if data of list2 data is smaller add data of list 2
      else {
        curr.next = new ListNode(list2.data);
        list2 = list2.next;
      }
      curr = curr.next;
    }

    // add remaining from list
    while (list1 != null) {
      curr.next = new ListNode(list1.data);
      list1 = list1.next;
      curr = curr.next;
    }

    while (list2 != null) {
      curr.next = new ListNode(list2.data);
      list2 = list2.next;
      curr = curr.next;
    }

    return dummy.next;
  }


  public static void main(String[] args) {
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(4);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);

    // print list
    ListNode node = mergeTwoLists(list1, list2);
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
 * Time complexity: O(m + n) => O(N)
 *    While loop runs till the size of largest linkedList.
 * 
 * Space complexity: O(m + n) => O(N)
 *    Dummy will hold size of n + m
 */
