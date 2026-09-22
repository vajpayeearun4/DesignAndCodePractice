package final_prep.dsa.linkedlist;

//https://leetcode.com/problems/rotate-list/submissions/2146840408/?envType=study-plan-v2&envId=top-interview-150
public class RightRotation {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;
        tail.next = head;
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}
