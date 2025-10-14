package essential;

import myLinkedListRepresentation.ListNode;

public class RotateInPlaceByNthFromEnd {

    public void rotateInPlaceByNthFromEnd(ListNode head, int k) {
        ListNode tail = head;
        int n = 1;  // start from 1 since tail is already head

        // find tail and length
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // make it cyclic
        tail.next = head;

        // find new tail: at position n-k-1
        k = k % n;  // handle k > n
        int stepsToNewTail = n - k - 1;

        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        // now newHead is rotated list head
        head = newHead;

    }
}
