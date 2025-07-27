package leetcode.linkedlist;

public class MergeTwoSortedLL {

    public static void main(String[] args) {

    }

    ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list1 != null) {
            if (list1.data < list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
        }
        curr.next = list1 != null ? list1 : list2;
        return dummy.next;

    }
}
