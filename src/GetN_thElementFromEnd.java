import myLinkedListRepresentation.ListNode;

public class GetN_thElementFromEnd {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode nthNode = getNthFromEnd(head, n);
        if (nthNode != null) {
            System.out.println(n + "th node from the end is: " + nthNode.val);
        } else {
            System.out.println("The list is shorter than " + n + " nodes.");
        }
    }

    public static ListNode getNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        // Move first pointer n steps ahead
        // Important that we would start with pointers at:
        // first -> 3 so onl when first reaches null, second would be at n-th from end
        // second -> 1
        for (int i = 1; i < n; i++) {
            if (first == null) {
                return null; // n is greater than the length of the list
            }
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second; // second is now the nth node from the end
    }
}
