
public class MaxInArray {

	public static void main(String[] args) {
		int arr[]= {12,4,65,77,34,23,98,76};
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > max) {
				max=arr[i];
			}
		}
		System.out.println(max);
	}

}
