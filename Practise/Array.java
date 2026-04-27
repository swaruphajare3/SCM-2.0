import java.util.Scanner;

public class Array {
	


	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int []arr=new int[10];
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enter the vale of"+ i + "Vale : ");
			arr[i]=scanner.nextInt();			
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
		
		

	}

}
