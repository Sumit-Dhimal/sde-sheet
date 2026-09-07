
public class DeleteNodeInLL {

  public static void deleteNode(ListNode node) {
    node.data = node.next.data;

    node.next = node.next.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(4);    
    head.next = new ListNode(5);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(9);

    deleteNode(head.next);

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