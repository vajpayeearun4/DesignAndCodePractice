package final_prep.dsa.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/2146758183/
public class RemoveDup {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
