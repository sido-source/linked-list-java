package essential;

import myLinkedListRepresentation.ListNode;

public class RemoveElement {

    public static void main(String[] args) {
        ListNode listNode = removeNthFromEnd(ListNode.createSampleLinkedList(), 1);
        ListNode.printList(listNode);
    }

    // remove nth node from end (1-based n)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null; // invalid input

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy, prev = dummy;

        // Move `first` n steps ahead
        for (int i = 1; i < n; i++) {
            first = first.next;
            if (first == null) {
                return null; // n is larger than the length of the list
            }
        }

        // Move both pointers until `first` reaches the last node
        while (first.next != null) {
            first = first.next;
            prev = second;
            second = second.next;
        }

        // Remove `second` node
        prev.next = second.next;
        return dummy.next;
    }


}
