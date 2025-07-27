package leetcode.linkedlist;

import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/description/?envType=problem-list-v2&envId=linked-list
public class MergeKSortedList {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                minHeap.offer(min.next);
            }
        }
        return dummy.next;


    }
}
