package essential;

import myLinkedListRepresentation.ListNode;

public class DeleteMiddle {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null) return null;

        if (head.next == null) {
            return null;
        }

        // in order to delete element we have to find middle point and the element before
        // and connect prev
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next; // while condition just prevents null pointer
        }

        prev.next = slow.next;

        return head;
    }
}
