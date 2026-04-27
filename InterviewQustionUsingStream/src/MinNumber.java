import java.util.List;

public class MinNumber {

	public static void main(String[] args) {
		List<Integer>num=List.of(65,98,66,77,45,107,99);
		int min=num.stream().min(Integer::compare).orElseThrow();		
		System.out.println(min);
	}

}
