package leetcode.linkedlist;


import java.util.List;

//https://leetcode.com/problems/add-two-numbers/description/?envType=problem-list-v2&envId=linked-list&
public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        int carry = 0;
        while (temp1 != null || temp2 != null || carry != 0) {
            int sum = carry;
            if (temp1 != null) {
                sum += temp1.data;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                sum += temp2.data;
                temp1 = temp2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            ;
            current = current.next;
        }
        return dummy.next;
    }


}
