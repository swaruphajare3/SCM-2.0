import java.util.List;

public class UpperCase {

	public static void main(String[] args) {
		List<String> name=List.of("Swarup","Ganesh","Hajare");
		List<String>upper= name.stream().map(String::toUpperCase).toList();
		System.out.println(upper);
		
	}

}
