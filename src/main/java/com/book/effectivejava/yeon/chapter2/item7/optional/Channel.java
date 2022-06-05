package com.book.effectivejava.yeon.chapter2.item7.optional;

import java.util.Optional;

public class Channel {

    private int numOfSubscribers;

    public Optional<MemberShip> defaultMemberShip() {
        /*
        Optional은 매개변수로는 사용하지 않는다.
        크게 의미가 없음
        Optional로 받아서 있는지 없는지, Optional 안에 내용이 있는지 없는지 확인하는 과정이 들어가야하기 때문에
        의미가 없음.
        Collection 틀래스도 Optional로 감쌀 필요가 없다.
        이미 COllection 안에 비어있는지 아닌지 체크하는 로직을 가지고 있기 때문에

        primitive type을 Optional로 감싸서 쓰고싶을 때는,
        전용 Optional 구현되어 있으니 쓸것
        OptionalInt 등
        */
        if (this.numOfSubscribers < 2000) {
//            return null;
            return Optional.empty();
        } else {
//            return new MemberShip();
            return Optional.of(new MemberShip());
        }
    }
}
