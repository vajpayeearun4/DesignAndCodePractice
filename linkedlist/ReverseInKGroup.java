package linkedlist;

public class ReverseInKGroup {
    public static void main(String[] args) {

    }

    LLNode reverseInKGroup(LLNode head, int k){
        if (head == null || head.next == null) {
            return head;
        }

        LLNode curr = head;
        LLNode newHead = null;
        LLNode tail= null;
        while (curr!=null) {
            LLNode groupHead = curr;
            LLNode prev = null;
            LLNode nextNode = null;
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
