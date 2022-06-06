package com.citiustech.multi;

interface Bag<E> {
	void add(E e);
	E[] elements();
	
	default void shuffle() {
		E[] e = elements();
		//some code here to shuffle all the elements
		System.out.println("shuffle method of Bag");
	}
}

interface RandomAccess<E> {
	E get(int index);
	E[] elements();
	
	default void shuffle() {
		E[] e = elements();
		//some code here to shuffle all the elements
		System.out.println("shuffle method of RandomAccess");
	}
}

class LuggageBag<E> implements Bag<E>, RandomAccess<E> {

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E[] elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		RandomAccess.super.shuffle();
	}
	
}

public class Example2 {

}
