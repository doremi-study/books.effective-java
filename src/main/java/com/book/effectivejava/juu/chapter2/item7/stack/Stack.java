package com.book.effectivejava.juu.chapter2.item7.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

// 코드 7-1 메모리 누수가 이렁나는 위치는 어디인가? (36쪽)
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	// public Object pop() {
	// 	if (size == 0) {
	// 		throw new EmptyStackException();
	// 	}
	// 	return elements[--size]; //이렇게 하면 언젠가 메모리 누수가 발생(OOM) -> 해당 index에 있는 값을 리턴만 하지.. 배열 자체에서 빼낸 게 아니기 때문에
	// }

	/**
	 * 원소를 위한 공간을 적어도 하나 이상 확보한다.
	 * 배열 크기를 늘려야 할 때 마다 대략 두배씩 늘린다.
	 */
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements[size] = null; //빼낸 값을 null로 비워줌 ( 다 쓴 참조 해제 )
		return result;
	}

	public static void main(String[] args) {
		// set, 배열, map, collection 객체들 -> 우리가 직접 메모리 관리
		// 메모리 누수에 신경 써야 한다.

		Stack stack = new Stack();
		for (String arg : args) {
			stack.push(arg);
		}

		while (true) {
			System.out.println(stack.pop());
		}
	}
}
