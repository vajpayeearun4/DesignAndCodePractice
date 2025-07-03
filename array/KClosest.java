package array;

import java.util.Arrays;
import java.util.List;

public class KClosest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4,7};
        getCount();

    }

   static int getCount(){
       try {
           System.out.println("inside try");
           return 2;
       } finally {
           System.out.println("finally");
       }
   }
}
