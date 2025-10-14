package essential;

import myLinkedListRepresentation.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        reverseFirstK(ListNode.createSampleLinkedList(), 3);
    }


    public ListNode easiestWayOfReverse(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            // we modificate head list so we are saving its state
            ListNode temp = head.next;

            head.next = prev;
            prev = head;

            head = temp;
        }

        return prev;
    }

    public static ListNode reverseCleanVersion(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
        }
        return prev; // new head
    }


    // Reverse first k nodes and return new head of the whole list (head.next is connected to rest)
    public static ListNode reverseFirstK(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode prev = null;
        ListNode curr = head;
        int cnt = 1;

        while (cnt <= k && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }

        // prev = new head of reversed part (e.g. 3 -> 2 -> 1)
        // head = original head -> now tail of reversed part (1)
        // curr = start of remaining list (4 -> 5)

        head.next = curr;   // connect tail of reversed part to the rest
        return prev;        // return new head (3)
    }

    // init state
    //head -> 1 -> 2 -> 3 -> 4 -> 5
    //curr -> 1 -> 2 -> 3 -> 4 -> 5
    //prev -> null

    //ListNode next = curr.next; // next = 2
    //curr.next = prev;          // 1.next -> null
    //prev = curr;               // prev -> 1
    //curr = next;               // curr -> 2

    // state after first iteration
    //prev -> 1 -> null
    //curr -> 2 -> 3 -> 4 -> 5
    //head -> 1 -> null  (same node as prev points to)



    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // check k nodes ahead
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) kth = kth.next;
            if (kth == null) break; // less than k nodes left

            ListNode groupStart = groupPrev.next;
            ListNode nextGroup = kth.next;

            // reverse [groupStart ... kth]
            ListNode prev = nextGroup;
            ListNode curr = groupStart;
            while (curr != nextGroup) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // connect
            groupPrev.next = kth;
            groupPrev = groupStart; // new prev for next group
        }

        return dummy.next;
    }


}
