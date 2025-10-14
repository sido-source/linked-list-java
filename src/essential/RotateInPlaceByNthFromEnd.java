package essential;

import myLinkedListRepresentation.ListNode;

public class RotateInPlaceByNthFromEnd {

    public static void main(String[] args) {
        ListNode head = ListNode.createSampleLinkedList();
        ListNode listNode = rotateInPlaceByNthFromEnd(head, 1);
        ListNode.printList(listNode);
    }

    public static ListNode rotateInPlaceByNthFromEnd(ListNode head, int k) {
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
        // int stepsToNewTail = n - k - 1; - if we count from 0 but I would rather count from 1

        int stepsToNewTail = n - k;
        ListNode newTail = head; // as head i our first elem
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        // now newHead is rotated list head
        return newHead;

    }
}
