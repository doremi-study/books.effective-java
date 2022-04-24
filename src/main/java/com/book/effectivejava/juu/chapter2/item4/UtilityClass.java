package com.book.effectivejava.juu.chapter2.item4;
//abstract를 쓰면 상송을 해야하나..? 하고 착각을 일으킴
public class UtilityClass {
	// public UtilityClass() {
	// 	System.out.println("constructor");
	// }

	//왜 굳이 못쓰는 코드를 사용하는 걸까..?

	/**
	 * 이 클래스는 인스턴스를 만들 수 없습니다.
	 */
	private UtilityClass() {
		//만나지 않길 바라는 에러.. 이게 나오면 무조건 잘못된 거다!!
		//이 방법은 스프링에도 잘 적응이 안되어 있음.
		throw new AssertionError();
	}

	public static String hello() {
		return "hello";
	}

	public static void main(String[] args) {
		String hello = UtilityClass.hello();
		UtilityClass utilityClass = new UtilityClass();
		utilityClass.hello();;
	}

}
