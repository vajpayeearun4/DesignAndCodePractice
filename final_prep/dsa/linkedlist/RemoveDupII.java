package final_prep.dsa.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDupII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                while (curr.next!=null && curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                }
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }

            curr = curr.next;

        }
        return dummy.next;
    }
}
