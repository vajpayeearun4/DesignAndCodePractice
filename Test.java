import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
		kidsWithCandies(new int[]{2,3,5,1,3}, 3);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = 0;
		for(int cand: candies){
			max = Math.max(max, cand);
		}
		Boolean[] result = new Boolean[candies.length];
		Arrays.fill(result, false);
		for(int i=0;i< candies.length;i++){
			if(candies[i]+ extraCandies >= max){
				result[i] = true;
			}
		}
		return List.of(result);
    }

}
