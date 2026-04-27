import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int num= sc.nextInt();
		boolean flag=false;
		
		for(int i=23;i<num;i++) {
			if(i%2==0) {
				flag= true;
				break;
			}
		}
		
		if(flag == true){
			System.out.println("It's a prime Number");
		}else {
			System.out.println("It's not a prime Number");
		}

	}

}
