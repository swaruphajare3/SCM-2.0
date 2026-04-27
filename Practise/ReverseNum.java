import java.util.Scanner;

public class ReverseNum {



	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc =new Scanner(System.in);
		int num=sc.nextInt();
		int reverse=0;
		while(num !=0){
				int digit = num % 10; // Extract last digit
				//System.out.print(digit);
            reverse = reverse * 10 + digit; // Build reversed number
           // System.out.println(reverse);
            num = num / 10;
            System.out.println(num);
            
		}
		System.out.print(reverse);
	}



}
