import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		List<String> result = new ArrayList<>();
		result.add("arun");
		result.add("sarika");
		//String finalResult =String.join(",", result);
		String finalResult =result.stream().collect(Collectors.joining(","));
		System.out.println(result.toString());
	}

}
