import java.util.Scanner;

public class SumOfArray {

	public static void main(String[] args) {
		int a=0;
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[5];
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enetr the index of vale "+ i +" Value : ");
			arr[i]=sc.nextInt();
			
		}
		for(int i:arr) {
			System.out.println(i);
		}
		
		for(int i=0;i<arr.length;i++) {
			 a=a+arr[i];
		}
		
		System.out.println(a);

	}

}
