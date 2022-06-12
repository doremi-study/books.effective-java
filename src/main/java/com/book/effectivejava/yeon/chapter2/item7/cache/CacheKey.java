package com.book.effectivejava.yeon.chapter2.item7.cache;

import java.time.LocalDateTime;

public class CacheKey {

    private Integer value;

    private LocalDateTime created;

    public CacheKey(Integer value) {
        this.value = value;
        this.created = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "CacheKey{" +
                "value=" + value +
                ", created=" + created +
                '}';
    }

    /*
    WeakHashMap
    더이상 사용하지 않는 객체를 GC할 때 자동으로 삭제해주는 Map

    Reference 종류
    String, Soft, Weak, Phantom

    - Key가 더이상 강하게 Strong 참조하는 곳이 없고, weak reference로 참조되는 경우 해당 엔트리를 제거한다.
    - 맵의 엔트리를 맵의 value가 아니라 key에 의존해야 하는 경우에 사용할 수 있다.
        ㄴ 엔트리..? :
            ㄴ key, value의 쌍.
        ㄴ 엔트리를 value에 의존한다..?
            ㄴ 맵에 넣는 데이터의 중요성이 어디에 달려있는지 봐야 함
            ㄴ value 보전에 집중할것인지, key에 집중할 것인지
            ㄴ Key가 중요한 경우, 즉 Key가 유효하지 않아지면 value도 무의미해지는 경우에 WeakhashMap을 사용할 수 있다.
    - 캐시를 구현하는데 사용하기도 하지만, 캐시를 직접 구현하는 것은 권장하지 않는다.
     */
    /*String, primitive 사용하면 JVM내부에 일부 값들이 캐싱된다.
    해당 값을 reference하는 변수를 null로 만든다 해도 String reference가 남아있다고 생각해서
    지워지지 않는다.*/


}
