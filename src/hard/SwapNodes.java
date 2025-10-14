package hard;

import myLinkedListRepresentation.ListNode;

public class SwapNodes {


    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0, head);

        // Find k-th node from start and its previous node
        ListNode prev1 = dummy;
        ListNode n1 = head;
        for (int i = 1; i < k; i++) {   // note i < k (not <=)
            prev1 = n1;
            n1 = n1.next;
        }

        // Use a runner to find k-th from end:
        ListNode runner = n1;            // already at k-th from start
        ListNode prev2 = dummy;
        ListNode n2 = head;
        while (runner.next != null) {
            runner = runner.next;
            prev2 = n2;
            n2 = n2.next;
        }

        // If they are the same node, nothing to do
        if (n1 == n2) return dummy.next;

        // Now swap nodes n1 and n2 by changing prev pointers and next pointers.
        // Handle adjacency separately for clarity.
        if (n1.next == n2) {
            // n1 immediately before n2
            prev1.next = n2;
            n1.next = n2.next;
            n2.next = n1;
        } else if (n2.next == n1) {
            // n2 immediately before n1
            prev2.next = n1;
            n2.next = n1.next;
            n1.next = n2;
        } else {
            // general non-adjacent case
            ListNode tmp1 = n1.next;
            ListNode tmp2 = n2.next;

            prev1.next = n2;
            n2.next = tmp1;

            prev2.next = n1;
            n1.next = tmp2;
        }

        return dummy.next;
    }
}
