package essential;

import myLinkedListRepresentation.ListNode;

public class RotateList {

    public static void main(String[] args) {
        ListNode l1 = ListNode.createSampleLinkedList();

        ListNode res = rotateFromRight_NthElem(l1, 2);
        System.out.println("end");

        ListNode reversed = reverseMet(ListNode.createSampleLinkedList());
        System.out.println("reversed");
    }

    public static ListNode rotateFromRight_NthElem(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        // find length and tail
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k = k % n;
        if (k == 0) return head;


        // make cycle
        tail.next = head;


        // find new tail: move n-k-1 steps from head (or n-k steps with different indexing)
        ListNode newTail = head;
        for (int i = 1; i < n - k; i++) newTail = newTail.next;

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }



    public static ListNode reverseMet(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;

            curr.next = prev;

            prev = curr;

            curr = tmp;
        }

        return prev;
    }
}
