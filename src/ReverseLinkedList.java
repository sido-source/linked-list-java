import myLinkedListRepresentation.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");

        ListNode reversedHead = reverseListClean(head);
        ListNode reversedHead1 = reverseList1(head);

//        System.out.println("Reversed list:" + reversedHead);
//        reversedHead.printList();
//        System.out.println("Reversed list:" + reversedHead1);
//        reversedHead1.printList();
    }

    // head | -> 1 -> 2 -> 3 -> 4
    // curr -> head
    // prev -> null ->

    public static ListNode reverseListClean(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 1) Save next node BEFORE changing pointers/making some changes
            curr.next = prev;              // 2) To the current node we have to attach previous nodes
            prev = curr;                   // 3) We save changes that were made / we have to update prev variable
            curr = nextTemp;               // 4) Move curr forward
        }

        return prev; // prev is the new head
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextTemp = head.next; // 1) Save next node BEFORE changing pointers/making some changes
            head.next = prev;              // 2) To the current node we have to attach previous nodes
            prev = head;                   // 3) We save changes that were made / we have to update prev variable
            head = nextTemp;               // 4) Move curr forward
        }

        return prev; // prev is the new head
    }

}
