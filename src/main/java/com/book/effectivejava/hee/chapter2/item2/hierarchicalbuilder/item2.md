# [Item2] 생성자에 매개변수가 많다면 빌더를 고려하라.

### POINT
``` 
Item2 을 제대로 이해하기 위해서 알아야 할 부분
- 자바빈즈, 게터, 세터
- 객체 얼리기 (freezing)
- 빌더패턴
- IllegalArgumentException
- 가변인수 매개변수를 여러 개 사용할 수 있다.
```

###선택 매개변수가 많을 때의 대응방법

1. 점층적 생성자 패턴 (telescoping constructor pattern) - 확장하기 어렵다!

   필수 매개변수만 받는 생성자, 필수 매개변수와 선택 매개변수 1개를 받는 생성자, 선택 매개변수를 2개 받는 생성자, ... 형태로 선택 매개변수를 전부 다 받는 생성자까지 늘려가는 방식

   ⇒ 점층적 생성자 패턴도 쓸 수는 있지만, 매개변수 개수가 많아지면 읽기 어렵다 !


2. 자바빈즈 패턴 (JavaBeans pattern) - 일관성이 깨지고, 불변객체로 만들 수 없다

   매개변수가 없는 생성자로 객체를 만든 후, setter를 호출해 원하는 매개변수의 값을 설정하는 방식

   ⇒ 객체 하나를 만들려면 메서드를 여러 개 ( 변경해줄 field값의 갯수만큼) 호출해야 하고, 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태에 놓이게 된다.

>    🌀 일관성이 깨진 객체의 문제
    버그를 심은 코드와 그 버그 때문에 런타임에 문제를 겪는 코드가 물리적으로 멀리 떨어져 있을 것이므로 디버깅이 어렵다
    일관성이 무너진 상태에서는 클래스를 불변으로 만들 수 없다(?) 스레드 안전성이 무너진다(?)


3. 빌더 패턴 (Builder pattern) - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다.
    1. 필요한 객체를 직접 만드는 대신, 필수 매개변수만으로 생성자 (혹은 정적 팩터리)를 호출해 빌더 객체를 얻는다.
    2. 빌더 객체가 제공하는 일종의 setter 메서드들로 원하는 선택 매개변수를 설정한다.
    3. 매개변수가 없는 build 메서드를 호출해서 객체를 얻는다 (이때 보통은 불변 객체를 얻게 된다)
    
>    🌀 빌더는 생성할 클래스 안에 정적 멤버 클래스로 만들어두는 게 일반적이다

    
    public class NutritionFacts {
    	private final int servingSize;
    	private final int servings;
    	private final int calories;
    	private final int fat;
    	private final int sodium;
    	private final int carbohydrate;
    
    	public static class Builder {
    		// 필수 매개변수
    		private final int servingSize;
    		private final int servings;
    		
    		// 선택 매개변수 - 기본값으로 초기화
    		private int calories     = 0;
    		private int fat          = 0;
    		private int sodium       = 0;
    		private int carbohydrate = 0;
    
    		public Builder(int servingSize, int servings) {
    			this.servingSize = servingSize;
    			this.servings    = servings;
    		}
    
    		// 빌더의 세터 메서드 : 빌더 자신을 반환하여 메서드 연쇄(method chaining) = fluent API 방식으로 호출가능!
    		public Builder calories(int val)     { calorises    = val; return this; }       //질문 !!!! 왜,  this.calories = val 이 아닌거임?!?!?!?!
    		public Builder fat(int val)          { fat          = val; return this; }
    		public Builder sodium(int val)       { sodium       = val; return this; }
    		public Builder carbohydrate(int val) { carbohydrate = val; return this; }
    
    		public NutritionFacts build() {
    			return new NutritionFacts(this);
    		}
    
    		private NutritionFacts(Builder builder) {
    			servingSize  = builder.servingSize;
    			servings     = builder.serving;
    			calories     = builder.calories;
    			fat          = builder.fat;
    			sodium       = builder.sodium;
    			carbohydrate = builder.carbohydrate;
    		}
    	}
    }
    
    // 빌더의 사용 예시
    NutritionFacts cocaCola = new NutiritionFacts.Builder(240, 8)
    															.calories(100)
    															.sodium(35)
    															.carbohydrate(27)
    															.build();
    ```

   Q) “NutritionFacts 클래스는 불변이며, 모든 매개변수의 기본값들을 한 곳에 모아 뒀다”  라는 문장이 이해가 안 가!

   <img src="immutable.png" width="500">


   빌더 패턴은 **계층적으로 설계된 클래스**와 함께 쓰기에 좋다 ⇒ 계층적으로 설계??? ⇒ 아! 상속구조를 의미하는 건가? 추상클래스 얘기가 나오는 걸 보니까!

   각 계층의 클래스에 관련 빌더를 멤버로 정의 : 추상 클래스 → 추상 빌더 / 구체 클레스(concrete class) → 구체 빌더

   생성자 패턴과 비교할 때, 빌더는 가변인수 매개변수를 여러 개 사용 가능(?) : 각각을 적절한 메서드로 나눠 선언 or 메서드를 여러 번 호출하도록 하고 각 호출 때 넘겨진 매개변수를 하나의 필드로 모을 수 있음 (?)

   빌더 패턴의 유연함 ! ⇒ 빌더 하나로 여러 객체를 순회가 가능 , 빌더에 넘기는 매개변수에 따라 다른 객체 생성이 가능 , 객체마다 부여되는 일련번호와 같은 특정 필드는 빌더가 알아서 채우도록 할 수 있음


빌더패턴의 단점

1. 객체를 만들기 전, 빌더를 만들어야한다.
2. 빌더생성비용이 크지는 않지만 성능에 민감한 상황은 고려해야한다.
3. 점층적 생성자 패턴과 비교하면 코드가 복잡 → 매개변수 4개 이상일 때 가성비 ! ( BUT ! API는 시간이 지날수록 매개변수가 늘어나는 경향이 있으니 나쁘지 않은 초이스 ! )


> 🌀 결론  : **생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는 게 낫다.**   
매개변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더 그렇다.     
> 빌더는 점층적 생성자보다 클라이언트 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈보다 훨씬 안전하다 !
