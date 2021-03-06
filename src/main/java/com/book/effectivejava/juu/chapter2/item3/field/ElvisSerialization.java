package com.book.effectivejava.juu.chapter2.item3.field;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//직렬화, 역직렬화
// 이렇게 복잡하게 쓸 바엔 스프링을 쓴다면 bean으로 등록해서 사용하면 스프링이 싱글톤을 보장하기 때문에 추천
public class ElvisSerialization {
	public static void main(String[] args) {
		//직렬화가 서버에서 클라이언트로 보내는 거
		//역직렬화가 클라이언트에서 서버로 받아오는 거
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
			out.writeObject(Elvis.INSTANCE); //역직렬화
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
			Elvis elvis3 = (Elvis)in.readObject();
			System.out.println(elvis3 == Elvis.INSTANCE);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
