import java.util.List;

public class MaxNumber {

	public static void main(String[] args) {
		List<Integer> num=List.of(65,98,66,77,45,107,99);
		
		int max1=num.stream().max(Integer::compare).orElseThrow();
		System.out.println(max1);

	}

}
