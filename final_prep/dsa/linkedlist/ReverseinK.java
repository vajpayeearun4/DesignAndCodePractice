package final_prep.dsa.linkedlist;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseinK {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kthNode = groupPrev;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) {
                    return dummy.next;
                }
            }

            ListNode curr = groupPrev.next;
            ListNode groupNext = kthNode.next;
            ListNode prev = groupNext;
            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode groupStart = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = groupStart;
        }
    }
}
