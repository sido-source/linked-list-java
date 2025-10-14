package essential;

public class EssentialPatterns {

    //int n = 1;  // start from 1 since tail is already head

    // someime we want to end on
    // while (head.next != null) -> then we not include last element
    // while (head != null) -> we include last elem

    // if we count from 0 then should be while(head != null) cnt++
    // if we count from 1 then should be while(head.next != null) cnt++

    //        // find tail and length
    //        while (tail.next != null) {
    //            tail = tail.next;
    //            n++;
    //        }

//    ListNode slow = head, fast = head, prev = null; // prev is only used to cut
//        while (fast != null && fast.next != null) {
//        prev = slow;
//        slow = slow.next;
//        fast = fast.next.next;
//    }
}
