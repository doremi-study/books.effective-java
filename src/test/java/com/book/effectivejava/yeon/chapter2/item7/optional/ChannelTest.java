package com.book.effectivejava.yeon.chapter2.item7.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChannelTest {

    @Test
    void npe() {
        Channel channel = new Channel();
        Optional<MemberShip> optional = channel.defaultMemberShip();
        optional.ifPresent(m -> {
            m.hello();
        });
        optional.ifPresent(MemberShip::hello);
    }
}