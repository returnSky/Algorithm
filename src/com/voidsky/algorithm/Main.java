package com.voidsky.algorithm;

import com.voidsky.algorithm.sort.InsertingSort;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] {17,2,13,4,5,8,7};
		InsertingSort.insertingSortDirectly(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

}
