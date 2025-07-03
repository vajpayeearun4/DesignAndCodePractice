package leetcode.array;

//169. Majority Element
public class MajorityElement {

    public static void main(String[] args) {

    }

    int findMajorityEl(int[] arr){
        int count =0, candidate=0;
        for (int el: arr){
            if(count == 0){
                candidate = el;
            }
            count+=(el == candidate)?1:-1;
        }
        return candidate;
    }
}
