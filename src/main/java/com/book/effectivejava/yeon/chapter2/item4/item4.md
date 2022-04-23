# 아이템4 - 인스턴스화와 private 생성자

# 인스턴스화를 막으려거든 private 생성자를 사용하라

- 기본 생성자
- 상속 클래스는 상위  클래스의 기본 생성자를 호출한다.
- AssertionError

## static 메서드

> Class 멤버인지 Obect 멤버인지 구분하는 자바 키워드인 `static` !
>

static 메서드는 클래스를 통해 접근할 수 있다.

```java
public class UtilityClass {
	
	public static String hello() {
		return "hello";
	}

	public static void main(String args[]) {
		UtilityClass.hello();
	}
}
```

⬇️ 이런 static 메서드들은 클래스의 인스턴스를 통해서도 접근이 가능하지만

`Util성 클래스`와 같이 *인스턴스로 사용하는 것이 목적인 클래스가 아니라면 불필요하다*.

```java
public class UtilityClass {
	
	public static String hello() {
		return "hello";
	}

	public static void main(String args[]) {
		UtilityClass utilityClass = new UtilityClass();
		utilityClass.hello();//자동완성은 안되지만, 문법적으로 가능한 코드
	}
}
```

문법적으로는 인스턴스화해서 static 메서드를 쓰는 것이 가능하지만

<aside>
💡 인스턴스 목적으로 쓸 메서드인지, static 목적으로 사용할 메서드인지 헷갈리게 할 수 있으니 아예 인스턴스화를 방지해두는 것이 낫다.

</aside>

## 방지1 : abstract 클래스

```java
public abstract class UtilityClass {

	public UtilityClass() {
		System.out.println("Constructor");
	}

	public static void main(String args[]) {
		UtilityClass utilityClass = new UtilityClass();
	}
}
```
<img width="702" alt="abstract_인스턴스화방지" src="https://user-images.githubusercontent.com/47437757/164872947-c2cad649-2d46-424b-aec6-79d2d4482a77.png">


추상 클래스로 설정한다면 인스턴스 생성을 막을 수 있다.

```java
public class DefaultUtilityClass extends UtilityClass {

    public static void main(String[] args) {
        DefaultUtilityClass utilityClass = new DefaultUtilityClass();
    }
}
```

하지만, 자식 클래스를 구현하고 그곳에서 인스턴스를 생성할 경우

기본 생성자에서 부모 클래스의 생성자 또한 호출하기 때문에

*abstract 클래스로 두는 것이 인스턴스 생성을 완전히 막아주지는 않는다*.

> 모든 생성자는 명시적이든 묵시적이든 상위 클래스의 생성자를 호출하게 된다.
>

또한, *상속을 사용하기 위한 클래스인지 목적을 헷갈리게 만들 수 있다*.

## 방지2 : private 생성자

```java
public class UtilityClass {

	/**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
	private UtilityClass() {
		throw new AssertionError();
	}

	public static void main(String args[]) {
		UtilityClass utilityClass = new UtilityClass();
	}
}
```

```java
Execution failed for task ':UtilityClass.main()'.
> Process 'command '/.../azul-16.0.2/Contents/Home/bin/java'' finished with non-zero exit value 1

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.
```
<img width="610" alt="private생성자_인스턴스화방지" src="https://user-images.githubusercontent.com/47437757/164872955-a28d71bd-1284-4f97-b776-44398ae98359.png">

private 생성자를 사용해서 인스턴스화를 막을 수 있다.

외부 인스턴스화만을 막아주고, 내부 인스턴스화는 막아주지 않기 때문에

AssertionError를 활용한다면 내부 인스턴스화까지 막아둘 수 있다.

## 참고

> 자바의 외부 라이브러리 Util 클래스들에서 모두 private 생성자로 인스턴스화를 막아둔 것은 아니다.
>

⬇️ 아래 `AnnotationConfigUtils` 처럼 abstract 클래스로 두어 인스턴스화를 간단히 막아두고 있다.

하지만 앞서 말한대로, 상속한 자식 클래스의 생성자를 통해 인스턴스화가 가능하다.

<aside>
💡 그럼 클래스 파일 타고 들어갈 때, 상속 목적의 abstract인지 인스턴스화 막기 위한 목적의 abstract 클래스인지 알아볼 수 있어야 하겠네 ... 어떻게든 되겠지..

</aside>
<img width="628" alt="annotationConfigUtils" src="https://user-images.githubusercontent.com/47437757/164872952-3526bf2c-0026-4bfd-86be-f072b1faf995.png">

⬇️ 아래처럼 기본 생성자를 두고 아무런 작업이 없다는 의미로 `/* no-op */` 주석을 달기도 하는 것 같다.  
<img width="318" alt="no_op" src="https://user-images.githubusercontent.com/47437757/164872953-0158abdf-a6ad-4340-9b8a-bebccbfc0788.png">
