#ππΏ Item1
# μ μ  ν©ν λ¦¬ λ©μλ

<aside>
π‘ μΈμ€ν΄μ€ μμ± μ κ°μ²΄μ νΉμ±, κ°μ²΄μ μλ―Έλ₯Ό λ μ λ³΄μ¬μ€ μ μλ€. μ§κ΄μ μΌλ‘

</aside>

νλμ μκ·Έλμ²λ‘λ μμ±μλ₯Ό νλλ§ λ§λ€ μ μλ€.

> ν ν΄λμ€μ μκ·Έλμ²κ° κ°μ μμ±μκ° μ¬λ¬ κ° νμν  κ² κ°μΌλ©΄,
μμ±μλ₯Ό μ μ  ν©ν λ¦¬ λ©μλλ‘ λ°κΎΈκ³  κ°κ°μ μ°¨μ΄λ₯Ό μ λλ¬λ΄λ μ΄λ¦μ μ§μ κ².
>

## μ μ  ν©ν λ¦¬ λ©μλλ₯Ό κ°μ§ Class

```java
public class Coffee {

	private String bean;
	private String water;

	private Coffee(String bean) {
		this.bean = bean;
	}

	private Coffee(String bean, String water) {
		this.bean = bean;
		this.water = water;
	}

	public static Coffee of(String bean) {
		return new Coffee(bean);
	}

	public static Coffee of(String bean, String water) {
		return new Coffee(bean, water);
	}
}
```

## μ μ  ν©ν λ¦¬ λ©μλλ‘ μΈμ€ν΄μ€λ₯Ό μμ±νλ Fatory Class

```java
public class CoffeeFactory {

	public static makeCoffee(boolean isEspresso, CoffeeIngredientDTO ingredient) {
		if (isEspresso) {
			return Coffee.of(ingredient.getBean());
		}
		return Coffee.of(ingredient.getBean(), ingredient.getWater());
	}
}
```

# λΆνμν κ°μ²΄ μμ±μ μ€μ΄μ.

> νΈμΆλ  λλ§λ€ μΈμ€ν΄μ€λ₯Ό μλ‘ μμ±νμ§λ μμλ λλ€.
>

## λΆλ³ ν΄λμ€

- μΈμ€ν΄μ€λ₯Ό λ―Έλ¦¬ λ§λ€μ΄λκ±°λ
- μλ‘ μμ±ν μΈμ€ν΄μ€λ₯Ό μΊμ±νμ¬ μ¬νμ©νλ μμΌλ‘ κ°μ²΄ μμ±μ νΌν  μ μλ€.

## κ΅¬μ‘° ν¨ν΄μ μ¬μ©ν΄μ κ°μ²΄ μμ±μ μ€μ΄λ λ°©λ²λ μλ€.

<aside>
π‘ κ΅¬μ‘° ν¨ν΄ Structural Pattern
μμ ν΄λμ€λ€μ μμκ³Ό ν©μ±μ μ΄μ©νμ¬ λ ν° ν΄λμ¬γΉ μμ±νλ λ°©λ²μ μ κ³΅νλ ν¨ν΄μ΄λ€.
μ»΄νμΌ λ¨κ³μμκ° μλ λ°νμ λ¨κ³μμ λ³΅ν© λ°©λ²μ΄λ λμμ λ³κ²½ν  μ μλ€λ μ μμ μ μ°μ±μ κ°λλ€.

</aside>

### μμ

- Facade Pattern
- Adapter Pattern
- Decorator Pattern

### λ°νμ μμ μμ λμμ λ³κ²½ν  μ μλ€.

```java
public class Wage{

	public static createWage(boolean isProbation) {
		if (isProbation) {
			return ProbationWage.of();//μμ΅ κΈμ¬
		}
		return NormalWage.of();//μΌλ° κΈμ¬
	}
}
```

### Decorator Pattern

```java
public class Espresso() implements Coffee {

	//...

	public double make() {
		return machine + bean;
	}
}
```

```java
public class Americano() implements Coffee {
	
	public static Americano of(Coffee coffee) {
		this.coffee = coffee;
	}

	public double make() {
		return coffee.make() + water;
	}
}
```

```java
public class CoffeeFactory {

	public static Wage createCoffee(boolean isAmericano) {
		Espresso espresso = Espresso.of();
		if (isAmericano) {
			return Americano.of(espresso);
		}
		return espresso;
	}
}
```

## λ°μ± ν΄λμ€ μ€λͺμ΄ κΈ°μ΅μ λ¨μ

> κΈ°λ³Έ νμμ booleanμ μΈμλ‘ λ°μ Boolean κ°μ²΄ μ°Έμ‘°λ‘ λ³ννκ³  μλ€.
κ°μ²΄λ‘!
>

# λ°ν νμμ νμ νμ κ°μ²΄λ₯Ό λ°νν  μ μλ λ₯λ ₯μ΄ μλ€.

> κ΅¬ν ν΄λμ€λ₯Ό κ³΅κ°νμ§ μκ³ λ κ·Έ κ°μ²΄λ₯Ό λ°νν  μ μλ€.
>

## κΆκΈνλ κ²λ€ β¬οΈ

### ν΄λμ€λ₯Ό κ³΅κ°νμ§ μλλ€.

μ κ·Ό μ μ΄μκ° public protectedκ° μλλ€.

μ κ·Όμ μ΄μλ₯Ό private, package-privateμΌλ‘ λκ³  λ€λ₯Έ ν΄λμ€μμ λμ  μμ±ν΄μ returnνλλ‘ νλ κ²½μ°λ μλ€.

### apiκ° μλ€

μ΄λ€ λ‘μ§μ A ν΄λμ€ λ΄λΆμ μ¨κ²¨λκ³  μ¬μ©μλ λ‘μ§ κ΅¬νμ λν κ³ λ―Όμμ΄ A ν΄λμ€μ λ©μλ νΈμΆνλ κ²λ§μΌλ‘λ νμν λ‘μ§μ μ¬μ©ν  μ μλ€.

### λλ° ν΄λμ€

ν΄λΉ ν΄λμ€μ κ΄λ ¨λ μ νΈμ± λ©μλλ₯Ό λͺ¨μλμ ν΄λμ€

- Arrayμ Arrays
- Collectionκ³Ό Collections

# μ μ  ν©ν λ¦¬ λ©μλλ₯Ό μμ±νλ μμ μλ λ°νν  κ°μ²΄μ ν΄λμ€κ° μ‘΄μ¬νμ§ μμλ λλ€.

Coffeeκ° μμΌλ©΄, Vanilla Latte κ°μ²΄λ λ©λ΄μ μΆκ°νκΈ°λ‘ ν μμ μ κ΅¬ννλ©΄ λλ€λ μλ―ΈμΈ κ² κ°μ