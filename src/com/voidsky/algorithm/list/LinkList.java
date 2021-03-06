package com.voidsky.algorithm.list;

public class LinkList implements MyList {
	private Node head;  	//头指针
	private Node current;	//当前结点对象
	private int length;		//元素个数

	/**
	 * 构造带有头结点的空的链表
	 */
	public LinkList() {
		this.current = this.head = new Node(null);
		this.length = 0;
	}
	
	/**
	 * 定位函数,寻找第index个结点
	 * @param index
	 */
	private void indexNode(int index) {
		if (index == 0) { //第一个数据元素结点的下标是0
			return;
		}
		this.current = this.head.getNext();
		int j = 1;
		while (this.current!=null&&j<index) {
			this.current = this.current.getNext();
			j++;
		}
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
		this.current = this.head.getNext(); //指向第一个结点
		while (this.current!=null) {
			Node temp = this.current.getNext();
			this.current = null;
			this.current = temp;
			this.length--;
		}
		this.head.setNext(null);   //头结点指针域设为空
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

	/**
	 * 查找:O(n),插入:O(1)
	 */
	@Override
	public void insert(Object obj, int index) throws Exception {
//		if(index<0 || index>this.length+1) {  //检查index插入位置是否合法 [1,length+1]
//			throw new RuntimeException("The paramter has error:" + index);
//		}
//		this.indexNode(index-1);  //[0,length]
		
		int j = 1;  //计数器
		this.current = this.head;
		while (this.current!=null && j < index) {  //寻找第 index-1 个结点 
			this.current = this.current.getNext();
			j++;
		}
		
		if (this.current==null||j > index) {
			throw new RuntimeException("The paramter has error:" + index);
		}
		
		//生成结点,并且把第 index-1个结点所指向的结点赋值给该节点的 next
		Node node = new Node(obj, this.current.getNext());
		//把第 index-1个结点的后继结点指向新结点
		this.current.setNext(node);
		this.length++;
	}

	/**
	 * 查找:O(n),删除:O(1)
	 */
	@Override
	public void delete(int index) throws Exception {
		int j = 1; //计数器
		this.current = this.head;
		while (this.current.getNext()!=null && j < index) {  //寻找第index-1个结点
			this.current = this.current.getNext();
			++j;
		}
		
		if (this.current == null || j > index) {
			throw new RuntimeException("The paramter has error:" + index);
		}
		
		//获得第index个结点
		Node node = this.current.getNext();
		//将第index个结点的后继赋值给第index-1个结点
		this.current.setNext(node.getNext());
		
		node = null;
		this.length--;
	}

}
