package linkedlist;

import leetcode.linkedlist.ListNode;

public class ReverseInKGroup {
    public static void main(String[] args) {

    }

    ListNode reverseInKGroup(ListNode head, int k){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode newHead = null;
        ListNode tail= null;
        while (curr!=null) {
            ListNode groupHead = curr;
            ListNode prev = null;
            ListNode nextNode = null;
            int count =0;

            while (curr!=null && count < k){
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }

            if (newHead ==null) {
                newHead = prev;
            }

            if (tail!=null) {
                tail.next = prev;
            }

            tail = groupHead;
        }

        return newHead;
    }
}
