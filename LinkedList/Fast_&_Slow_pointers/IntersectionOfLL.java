	import structures.ListNode;

	public class IntersectionOfLL {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int a_count = 0, b_count = 0;

		ListNode a = headA;
		ListNode b = headB;
		
		while (a != null) {
			a_count++;
			a = a.next;
		}

		while (b != null) {
			b_count++;
			b = b.next;
		}

		while ( a_count > b_count) {
			a_count--;
			headA = headA.next;
		}

		while ( b_count > a_count) {
			b_count--;
			headB = headB.next;
		}

		while ( headA != headB ) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(9);
		headA.next.next = new ListNode(1);
		headA.next.next.next = new ListNode(2);
		headA.next.next.next.next = new ListNode(4);

		ListNode headB = new ListNode(3);
		headB.next = new ListNode(2);
		headB.next.next = new ListNode(4);

		ListNode ans = getIntersectionNode(headA, headB);

		System.out.println(ans);
	}
}
