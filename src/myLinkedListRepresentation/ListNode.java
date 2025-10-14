package myLinkedListRepresentation;

public class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      void printList() {

            while (next != null) {
                  System.out.print(val + " ");
                  next = next.next;
            }

            System.out.println("\n");
      }

      public static void printList(ListNode head) {

            // not change the initial head
            ListNode curr = head;
            while (curr != null) {
                  System.out.print(curr.val + " ");
                  curr = curr.next;
            }
            System.out.println();
      }


      public static ListNode createSampleLinkedList() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            return head;
      }

      public static ListNode createShuffledLinkedList() {
            ListNode head = new ListNode(4);
            head.next = new ListNode(3);
            head.next.next = new ListNode(1);
            head.next.next.next = new ListNode(5);
            head.next.next.next.next = new ListNode(2);

            return head;
      }
}