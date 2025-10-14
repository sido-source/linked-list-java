package essential;

import myLinkedListRepresentation.ListNode;

public class MergeSortLinkedList {

    public static void main(String[] args) {

        ListNode res = sortList(ListNode.createShuffledLinkedList());
        System.out.println("finish");
        ListNode.printList(res);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1; l1 = l1.next;
            } else {
                tail.next = l2; l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }


    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // use find middle elem template with prev to cut list
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }


        prev.next = null; // cut into two lists: head and slow


        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoLists(l1, l2);
    }

}
