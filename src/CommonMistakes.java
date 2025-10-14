import myLinkedListRepresentation.ListNode;

public class CommonMistakes {


    // It’s better not to have two pointers to the same myLinkedListRepresentation.ListNode
    // as if we change myLinkedListRepresentation.ListNode in one place it will be changed for both pointers
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = null;
        ListNode next = head.next;

        while (next != null) {
            ListNode curr = head; // here we have two pointers for the same myLinkedListRepresentation.ListNode
            curr.next = result; // here we change this myLinkedListRepresentation.ListNode using one pointer to null
            result = curr;        // Update result to the new head of reversed part

            next = next.next;     // ❌ WRONG: you already lost access to head.next earlier
            head = head.next;     // ❌ now head.next was changed to result (null or reversed part)
        }

        return result;
    }
}
