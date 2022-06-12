package com.book.effectivejava.yeon.chapter2.item7.listener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoom {

    /*
    reference 예시를 위해 이렇게 썼지만,
    이렇게 쓰면 안됨!
    삭제가 안돼~
     */
    private List<WeakReference<User>> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(new WeakReference<>(user));
    }

    public void sendMessage(String message) {
        users.forEach(wr -> Objects.requireNonNull(wr.get()).receive(message));
    }

    public List<WeakReference<User>> getUsers() {
        return users;
    }
}
