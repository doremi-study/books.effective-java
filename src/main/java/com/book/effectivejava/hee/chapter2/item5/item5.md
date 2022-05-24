# 아이템5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
#### 사용하는 자원에 따라 동작이 달라지는 클래스의 경우, DI/IoC (객체주입) 을 사용하라

자원에 의존하는 클래스   
-> 정적 유틸리티 혹은 싱글턴을 이용하여 구현하는 경우가 많다.   
-> 이는 자원을 단 하나만 사용한다는 가정 하에만 유효. 테스트용 자원을 사용하기에도 불편하다.   
-> 따라서, 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리니 클래스나 싱글턴 방식이 적합하지 않다.   

클래스가 여러 자원에 대한 인스턴스를 지원하고, 클라이언트가 원하는 자원을 사용할 수 있어야한다.      
-> "인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식" 의 패턴을 사용한다   
=> "의존 객체 주입"의 한 형태로, 자원을 사용하는 클래스를 생성할 때, 의존 객체를 주입한다


### 의존 객체 주입 패턴의 장점
1. **자원의 개수와 의존 관계에 상관없이** 잘 작동한다.
2. **불변을 보장**하여 같은 자원을 사용하는 여러 클라이언트가 의존 객체들을 안심하고 공유할 수 있다.
3. 생성자, 정적 팩터리, 빌더 모두에 똑같이 응용 가능하다.
4. 유연성과 테스트 용이성을 좋게 한다.

#### 의존 객체 주입 패턴의 변형
1. 생성자에 자원 팩터리를 넘겨주어, 팩터리 메서드 패턴을 구현할 수 있다.
cf. **팩터리 : 호출할 때마다 특정 타입의 인스턴스를 반복해서 만들어주는 객체.** (ex. Supplier<T> 인터페이스)

### 의존 객체 주입 패턴의 단점
1. 의존성이 수천 개나 되는 큰 프로젝트에서는 코드를 어지럽게 만든다.
-> 해결 : 의존 객체 주입 프레임워크 (ex. Spring) 를 사용한다.

---

- 사용하는 자원에 따라 동작이 달라지는 클래스(IoC, DI를 사용하라)는 정적 유틸리티 클래스나 싱글턴 방식이 적합하지 않다.
- 의존 객체 주입 : 인스턴스를 생성할 때 필요한 자원을 넘겨주는 방식
- 이 방식의 변형으로 생성자에 자원 팩터리를 넘겨줄 수 있다
- 의존 객체 주입을 사용하면 클래스의 유연성, 재사용성, 테스트 용이성을 개선할 수 있다.

Util성 클래스??? : static 한 메서드로 이루어진 클래스?