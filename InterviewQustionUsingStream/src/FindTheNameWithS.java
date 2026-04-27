import java.util.List;

public class FindTheNameWithS {

	public static void main(String[] args) {
		List<String> list=List.of("Swarup","Ganesh","Sonu","Shubham");
		
		List<String> list2=list.stream().filter(s -> s.startsWith("S")).toList();
		System.out.println(list2);

	}

}
