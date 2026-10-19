import structures.ListNode;

public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = 0;
        ListNode curr = head;

        while( curr != null) {
            curr = curr.next;
            size++;
        }

        if (size == n) {
            return head.next;
        }

        curr = head;
        for (int i = 1; i < size-n; i++) {
            curr = curr.next;
        }

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
