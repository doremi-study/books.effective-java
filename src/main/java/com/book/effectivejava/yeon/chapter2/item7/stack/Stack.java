package com.book.effectivejava.yeon.chapter2.item7.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    /*
    List, Set, Array 등 직접 메모리 쌓아두는 로직을 개발한다면,
    메모리 누수에 주의할 것!
    언제 쌓이고, 언제 참조를 없애야할지 생각

    메모리가 쌓일 수 있는 경우 3가지
    Stack, Cache, Listener 혹은 callback

    쌓인 메모리 해결하는 방법 3가지
    null 처리, Weak Reference 사용(Weak Reference를 key로 사용하는 WeakHashMap)
    , 특정한 자료구조를 사용(LRU Cache-최근에 사용한것만 남긴다)
    , 백그라운드 thread 를 실행해서 클린을 해주는 방법
     */
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

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];//return만 해줄 뿐 배열에서 제거하는게 아님
    }

    public Object correctPop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;// 다 쓴 객체 참조 해제
        return result;
    }

    /*
    원소를 위한 공간을 적어도 하나는 확보해야 한다.
    배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args) {
            stack.push(arg);
        }
        while (true)
            System.err.println(stack.pop());
    }
}
