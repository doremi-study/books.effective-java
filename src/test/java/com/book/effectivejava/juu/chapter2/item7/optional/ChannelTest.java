package com.book.effectivejava.juu.chapter2.item7.optional;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class ChannelTest {
	@Test
	void name() {
		Channel channel = new Channel();
		Optional<MemberShip> optionalMemberShip = channel.defaultMemberShip();
		//if(memberShip != null) -> 이렇게 변환
		optionalMemberShip.ifPresent(MemberShip::hello);

		// 여기서부터 에러남
		// MemberShip memberShip = optionalMemberShip.get();

		// 매개변수 타입으로 optional을 쓰는 건 의미가 없다. return 값만 사용하자
		// Optional로 collection을 감싸지 말자
		// optional 쓰고 null로 리턴하지 말자. -> Optional.empty();
		// primitive 타입은 옵셔널로 감싸지 말고 OptionalLong 이런 거 쓰자



	}
}