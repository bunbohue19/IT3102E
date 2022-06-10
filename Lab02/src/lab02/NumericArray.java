package lab02;

import java.util.Arrays;

public class NumericArray {
	public static void main(String[] args) {
		double my_array1[] = new double[] {1789, 2035, 1899, 1456, 2013};
		for (int i = 0; i < my_array1.length; i++) {
			System.out.print(my_array1[i] + " ");
		}
		
		Arrays.sort(my_array1);
		
		System.out.println("\n");
		
		for (int i = 0; i < my_array1.length; i++) {
			System.out.print(my_array1[i] + " ");
		}
	}
}
