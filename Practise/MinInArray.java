
public class MinInArray {
	public static int minimum_element(int[] arr) {
		int min = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - 1; j++) {
				if (arr[i] >= arr[j]) {
					min = arr[i];
				} else
					min = arr[j];

			}

		}

		return min;

	}
	
}
