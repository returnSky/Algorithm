package com.voidsky.algorithm.sort;

public class InsertingSort {
	/**
	 * 直接插入排序
	 * @param array
	 */
	public static void insertingSortDirectly(int[] array) {
		int j;
		//前i个元素是已排序的
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];  //暂存第i个元素
			//第i个元素依次和之前的元素比较，如果比第i个元素大，那就往后挪
			for (j = i-1; j>=0&&temp<array[j]; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = temp;
		}
	}
}
