package final_prep.dsa.linkedlist;

//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class MaxTwinSum {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        int maxSum = 0;
        ListNode first = head, second = prev;
        while (first.next != null) {
            maxSum = Math.max(maxSum, (first.val + second.val));
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
}
