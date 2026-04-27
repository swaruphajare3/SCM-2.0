import java.util.Scanner;

public class PrimeNoWithRange {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        sc.close();

	        for (int num = 2; num <= N; num++) {
	            if (isPrime(num)) {
	                System.out.println(num);
	            }
	        }
	    }

	    public static boolean isPrime(int num) {
	        if (num < 2) 
	        	return false; // No prime number less than 2
	        
	        for (int i = 2; i * i <= num; i++) { // Check divisibility from 2 to sqrt(num)
	            if (num % i == 0) {
	                return false; // If divisible, it's not prime
	            }
	        }
	        return true; // If not

	}

}
