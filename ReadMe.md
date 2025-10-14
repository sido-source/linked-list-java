technics:


1) Only read and iteration init LinkedList
Używamy referencji curr, która tylko iteruje — nie modyfikuje oryginalnej listy.

// input: myLinkedListRepresentation.ListNode head
myLinkedListRepresentation.ListNode curr = head;

while (curr != null) {
System.out.println(curr.val);  // tylko odczyt
curr = curr.next;              // przechodzimy do następnego
}

// head nadal wskazuje na pierwszy element
// bo w Javie przekazujemy referencję przez wartość (kopię referencji)


2) Add element to end of LinkedList

// input: myLinkedListRepresentation.ListNode head, int valueToAppend
if (head == null) {
head = new myLinkedListRepresentation.ListNode(valueToAppend);
return head;
}

myLinkedListRepresentation.ListNode curr = head;
while (curr.next != null) {    // idziemy do ostatniego węzła
curr = curr.next;
}

// teraz curr jest ogonem (tail)
curr.next = new myLinkedListRepresentation.ListNode(valueToAppend);  // mutujemy listę, dodajemy nowy element
return head;  // zwracamy głowę (niezmienioną)


3) Detect cycle

/ detect cycle
public static boolean hasCycle(myLinkedListRepresentation.ListNode head) {
myLinkedListRepresentation.ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
slow = slow.next;
fast = fast.next.next;
if (slow == fast) return true;
}
return false;
}

4) Find cycle point

// find cycle start (returns node or null)
public static myLinkedListRepresentation.ListNode findCycleStart(myLinkedListRepresentation.ListNode head) {
myLinkedListRepresentation.ListNode slow = head, fast = head;
boolean found = false;
while (fast != null && fast.next != null) {
slow = slow.next;
fast = fast.next.next;
if (slow == fast) { found = true; break; }
}
if (!found) return null;
myLinkedListRepresentation.ListNode ptr = head;
while (ptr != slow) {
ptr = ptr.next;
slow = slow.next;
}
return ptr; // start of cycle
}




3) Removing given element from LinkedList (we need: dummyHead, curr - curr element of list, prev- reference to prev element to be able change its reference after removing curr  )

// input: myLinkedListRepresentation.ListNode head, int target
myLinkedListRepresentation.ListNode dummy = new myLinkedListRepresentation.ListNode(0);   // sztuczna głowa
dummy.next = head;                  // dummy -> head, making dummy as first element

myLinkedListRepresentation.ListNode prev = dummy; // previous is our dummyNode in case we want to remove first element from init List
myLinkedListRepresentation.ListNode curr = head;  // curr is started from 1 element of init List so from head

while (curr != null) {
if (curr.val == target) {
prev.next = curr.next;   // pomijamy curr (usuwamy go)
break;                   // lub continue, jeśli chcemy usuwać wiele
}
prev = curr;
curr = curr.next;
}

// dummy.next to prawdziwa głowa (mogła się zmienić)
head = dummy.next;
return head;


save next element (List of next elems) curr.next and modificate the current one as curr
two-pointer (slow and fast pointer) - Floyd’s Cycle Detection Algorithm
track last elem or some element as a new reference for example "newTail" to later be able to make some computations
make a cycle on a LinkedList and then try to unlink using ref as "newTail"
merge sort


save ref to head
in for loop find the tail
tail.next = head  (making cycle)
in for loop based on head which is our pointer find place to unlink cycle
