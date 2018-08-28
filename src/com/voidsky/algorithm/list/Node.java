package com.voidsky.algorithm.list;

public class Node {
	private Object element;  //数据域
	private Node next;		//指针域
	
	//头结点构造
	public Node(Node next) {
		this.next = next;
		this.element = null;
	}

	//非头结点的构造
	public Node(Object element, Node next) {
		super();
		this.element = element;
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
