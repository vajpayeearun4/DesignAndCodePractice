package linkedlist;

public class TestLL {
    public static void main(String[] args) {
        //Delete last occurrence of an item from linked list
        LLNode head = new LLNode(1);
        deleteLastOcc(1,head);

    }

   static void deleteLastOcc(int givenKey, LLNode head) {
        if (head.data == givenKey) {
            if(head.next == null){
                head = null;
            }else {
                head = head.next;
            }
            return;
        }
        LLNode temp = head;
        LLNode lastOcc = null;
        while (temp.next!=null) {
            if(temp.next.data == givenKey){
                lastOcc = temp;
            }
        }
       lastOcc.next = lastOcc.next.next;

    }

}


