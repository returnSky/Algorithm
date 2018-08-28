package com.voidsky.algorithm.list;

import java.util.Arrays;

public class SequenceList implements MyList {
	
	private final int DEFAULT_LENGTH = 20;
	private int maxSize;
	private int length;
	private Object[] array;
	
	public SequenceList() {
		this.initList(DEFAULT_LENGTH);
	}

	public SequenceList(int length) {
		this.initList(length);
	}

	private void initList(int length) {
		this.length = 0;
		this.maxSize = length;
		this.array = new Object[maxSize];
	}
	
	private void initList(Object[] objs) {
		this.length = 0;
		this.maxSize = objs.length;
		this.array = objs;
	}
	
	@Override
	public int getLength() {
		return this.length;
	}

	@Override
	public boolean isEmpty() {
		return this.length == 0?true:false;
	}

	@Override
	public void clearList() {
		this.array = null;
		this.length = 0;
	}

	/*
	 * 时间复杂度：O(1)
	 * @see com.voidsky.algorithm.list.MyList#getByIndex(int)
	 */
	@Override
	public Object getByIndex(int index) throws Exception {
		if (this.length == 0 || index < 0 || index > this.length) {
			throw new RuntimeException("The paramter has error:" + index);
		}
		return this.array[index-1];
	}

	/*
	 * 时间复杂度：O(n)
	 * @see com.voidsky.algorithm.list.MyList#insert(java.lang.Object, int)
	 */
	@Override
	public void insert(Object obj, int index) throws Exception {
		if (this.length == this.maxSize) {  //若线性表已经满
			throw new RuntimeException("This list is already full.");
		} else if (index < 1 || index > this.length+1) { //若index不在范围内[1,length+1]
			throw new RuntimeException("The paramter has error:" + index);
		} else if (index <= this.length) {  //若插入位置不在线性表末尾
			for (int k = this.length-1; k >= index-1; k--) {
				this.array[k+1] = this.array[k];  //将要插入位置后的数据元素向后移动一位
			}
		}
		
		this.array[index-1] = obj; //插入新元素
		this.length++;
	}

	@Override
	public void delete(int index) {
		if (this.isEmpty()) {  //若线性表已经空
			throw new RuntimeException("This list is already empty.");
		} else if (index < 1 || index > this.length) {  //若index不在范围内[1,length]
			throw new RuntimeException("The paramter has error:" + index);
		} else if (index < this.length) { //若删除位置不在最后位置
			for (int i = index; i < this.length; i++) {
				this.array[i-1] = this.array[i];  //将删除位置后的数据元素向前移动一位
			}
		}
		this.array[--this.length] = null;
	}

	@Override
	public String toString() {
		return "SequenceList [DEFAULT_LENGTH=" + DEFAULT_LENGTH + ", maxSize=" + maxSize + ", length=" + length
				+ ", array=" + Arrays.toString(array) + "]";
	}
	
}
