package essential.cycle;

import myLinkedListRepresentation.ListNode;

public class FindCyclePoint {

    public ListNode findCyclePoint(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast) break;
        }

        // if there is no cycle
        if (fast != null && fast.next != null) return null;

        // there is a cycle and we have to find the element where is the cycle
        // as for now we only find that there is a cycle but we dont know where
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
