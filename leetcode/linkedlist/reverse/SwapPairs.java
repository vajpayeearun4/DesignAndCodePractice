package leetcode.linkedlist.reverse;

import leetcode.linkedlist.ListNode;

//https://leetcode.com/problems/swap-nodes-in-pairs/?envType=problem-list-v2&envId=linked-list
public class SwapPairs {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummmy = new ListNode(0);
        dummmy.next = head;
        ListNode prev = dummmy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
            head = head.next;
        }
        return dummmy.next;
    }
}
