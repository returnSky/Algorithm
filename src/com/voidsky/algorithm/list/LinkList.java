package com.voidsky.algorithm.list;

public class LinkList implements MyList {
	private Node head;  	//头指针
	private Node current;	//当前结点对象
	private int length;		//元素个数

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
		this.head = null;
		this.length = 0;
	}

	@Override
	public Object getByIndex(int index) throws Exception {
		if (this.length == 0) {
			throw new RuntimeException("This list is already empty.");
		} else if (index < 0 || index > this.length) {
			throw new RuntimeException("The paramter has error:" + index);
		} else {
			int j = 1;  //计数器
			this.current = this.head.getNext();  //当前结点指向第一个结点
			while (this.current!=null && j<index) {  //current不为空，且计数还小于index
				this.current = this.current.getNext();
				++j;
			}
			
			return this.current.getElement();
		}
	}

	@Override
	public void insert(Object obj, int index) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub

	}

}
