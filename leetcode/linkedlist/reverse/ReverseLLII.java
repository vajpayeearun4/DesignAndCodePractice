package leetcode.linkedlist.reverse;

import leetcode.linkedlist.ListNode;

import java.util.List;

//https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=problem-list-v2&envId=linked-list
public class ReverseLLII {

    public ListNode reverseLL(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode newHead = null;
        ListNode tail = null;
        while (curr != null) {
            ListNode groupHead = curr;
            ListNode prev = null;
            ListNode nextNode = null;
            int count = 0;

            while (curr != null && count < k) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }

            if (newHead == null) {
                newHead = prev;
            }

            if (tail != null) {
                tail.next = prev;
            }

            tail = groupHead;
        }

        return newHead;
    }
}
