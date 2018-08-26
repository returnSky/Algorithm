package com.voidsky.algorithm.list;

public interface MyList {
	
	//获取线性表的元素个数
	public int getLength();
	
	//判断线性表是否为空
	public boolean isEmpty();
	
	//清空线性表
	public void clearList();
	
	//根据位置获取指定位置的元素
	public Object getByIndex(int index) throws Exception;
	
	//插入元素到指定位置
	public void insert(Object obj, int index) throws Exception;
	
	//删除指定位置的元素
	public void delete(int index) throws Exception;
}
