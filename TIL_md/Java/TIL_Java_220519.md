# TIL_Java_220519

---

###### 책 - 이것이 자바다 신용권의 Java 프로그래밍 정복 1 (p.57 ~ p.108)

---

#### 2.3.3 연산식에서의 자동 타입 변환

- 연산 : 기본적으로 같은 타입의 피연산자(operand) 간에만 수행되기 때문에 서로 다른 타입의 피연산자가 있을 경우 두 피연산자 중 크기가 큰 타입으로 자동 변환된 후 연산을 수행
- 자바는 정수 연산일 경우 int 타입으로 기본으로 함

---

### 3.1 연산자와 연산식

- 프로그램에서 데이터를 처리하여 결과를 산출하는 것을 연산(operations)이라 함
- 연산에 사용되는 표시나 기호를 연산자(operator)라고 함
- 연산되는 데이터는 피연산자(operand)라고 함
- 연산자와 피연산자를 이용하여 연산의 과정을 기술한 것을 연산식(expressions)이라고 함
- 산술 연산자일 경우 숫자 타입(byte, short, int, long, float, double)으로 결과값이 나오고, 비교연산자와 논리 연산자는 논리(boolean)타입으로 나옴
- 연산자는 필요로 하는 피연산자의 수에 따라 단항, 이항, 삼항 연산자로 구분
- 연산식은 반드시 하나의 값을 산출함

---

### 3.2 연산의 방향과 우선순위

- 산술 연산식에서 +, -보다는  *, /연산자가 우선 처리가 됨
- 대부분의 연산자는 왼쪽에서부터 오른쪽으로 연산을 시작
- 하지만 단항 연산자(++, --, ~, !), 부호 연산자(+, -), 대입 연산자(=, +=, -=)는 오른쪽에서 왼쪽으로 연산
- 먼저 처리해야 할 연산식이 있으면 괄호 ( )를 사용함 

``` markdown
1. 단항, 이항, 삼항 연산자 순으로 우선순위를 가짐
2. 산술, 비교, 논리, 대입 연산자 순으로 우선순위를 가짐
3. 단항과 대입 연산자를 제외한 모든 연산의 방향은 왼쪽에서 오른쪽
4. 복잡한 연산식에는 괄호 ( )를 사용해서 우선순위를 정해줌
```

---

### 3.3 단항 연산자

- 단항 연산자는 피연산자가 단 하나뿐인 연산자를 말함

---

#### 3.3.1 부호 연산자(+, -)

- 부호 연산자는 양수 및 음수를 표시하는 +, - 를 말함

| 연산식 |          | 설명                 |
| :----: | :------: | :------------------- |
|   +    | 피연산자 | 피연산자의 부호 유지 |
|   -    | 피연산자 | 피연산자의 부호 변경 |

- 부호 연산자를 사용할 때 주의할 점은 부호 연산자의 산출 타입은 int 타입

---

#### 3.3.2 증감 연산자(++, --)

- 증감 연산자는 변수의 값을 1 증가(++)시키거나 1 감소(--)시키는 연산자를 말함

|  연산식  |          | 설명                                                 |
| :------: | :------: | :--------------------------------------------------- |
|    ++    | 피연산자 | 다른 연산을 수행하기 전에 피연산자의 값을 1 증가시킴 |
|    --    | 피연산자 | 다른 연산을 수행하기 전에 피연산자의 값을 1 감소시킴 |
| 피연산자 |    ++    | 다른 연산을 수행한 후에 피연산자의 값을 1 증가시킴   |
| 피연산자 |    --    | 다른 연산을 수행한 후에 피연산자의 값을 1 감소시킴   |

---

#### 3.3.3 논리 부정 연산자(!)

- 논리 부정 연산자는 true를 false로, false를 true로 변경하기 떄문에 boolean 타입에만 사용함

| 연산식 |          | 설명                                                         |
| :----: | :------: | ------------------------------------------------------------ |
|   !    | 피연산자 | 피연산자가 true이면 false 값을 산출 <br>피연산자가 false이면 true 값을 산출 |

- 논리 부정 연산자는 조건문과 제어문에서 사용되어 조건식의 값을 부정하도록 해서 실행 흐름을 제어할 때 주로 사용

---

#### 3.3.4 비트 반전 연산자(~)

- 비트 반전 연산자는 정수 타입의 피연산자에만 사용되며, 피연산자를 2진수로 표현했을 때 비트값인 0을 1로, 1은 0으로 반전

---

### 3.4 이항 연산자

- 이항 연산자는 피연산자가 두 개인 연산자를 말함

---

#### 3.4.1 산술 연산자(+, -, *, /, %)

- 산술 연산자는 boolean 타입을 제외한 모든 기본 타입에 사용할 수 있음

|  연산식  |      |          | 설명                                                      |
| :------: | :--: | :------: | --------------------------------------------------------- |
| 피연산자 |  +   | 피연산자 | 덧셈 연산                                                 |
| 피연산자 |  -   | 피연산자 | 뺄셈 연산                                                 |
| 피연산자 |  *   | 피연산자 | 곱셈 연산                                                 |
| 피연산자 |  /   | 피연산자 | 좌측 피연산자를 우측 피연산자로 나눗셈 연산               |
| 피연산자 |  %   | 피연산자 | 좌측 피연산자를 우측 피연산자로 나눈 나머지를 구하는 연산 |

##### 오버플로우 탐지

- 산술 연산을 할 때 연산 후의 산출값이 산출 타입으로 충분히 표현 가능한지 살펴봐야 함
- 산출 타입으로 표현할 수 없는 값이 산출되었을 경우 오버플로우가 발생하고 쓰레기값(엉뚱한 값)을 얻음

---

#### 3.4.2 문자열 연결 연산자(+)

- 문자열 연결 연산자인 +는 문자열을 서로 결합하는 연산자
- 피연산자 중 한쪽이 문자열이면 + 연산자는 문자열 연결 연산자로 사용되어 다른 피연산자를 문자열로 변환하고 서로 결합 함

``` java
"JDK" + 3 + 3.0; 	// JDK33.0
3 + 3.0 + "JDK"		// 6.0JDK
```

---

#### 3.4.3 비교 연산자(<, <=, >, >=, ==, !=)

- 비교 연산자는 비교해서 boolean 타입인 true/false를 산출
- 대소(<, <=, >, >=) 연산자는 boolean 타입을 제외한 기본 타입에 사용할 수 있고, 동등(==, !=) 연산자는 모든 타입에 사용 가능
- 주로 조건문, 반복문에서 사용함

| 구분 |  연산식   |      |           | 설명                             |
| :--: | :-------: | :--: | :-------: | -------------------------------- |
| 동등 | 피연산자1 |  ==  | 피연산자2 | 두 피연산자의 값이 같은지를 검사 |
| 비교 | 피연산자1 |  !=  | 피연산자2 | 두 피연산자의 값이 다른지를 검사 |
|      | 피연산자1 |  >   | 피연산자2 | 피연산자1이 큰지를 검사          |
| 크기 | 피연산자1 |  >=  | 피연산자2 | 피연산자1이 크거나 같은지를 검사 |
| 비교 | 피연산자1 |  <   | 피연산자2 | 피연산자1이 작은지를 검사        |
|      | 피연산자1 |  <=  | 피연산자2 | 피연산자1이 작거나 같은지를 검사 |

- 만약 피연산자가 char 타입이면 유니코드 값으로 비교 연산을 수행
- 비교 연산자에서도 연산을 수행하기 전에 타입 변환을 통해 피연산자의 타입을 일치 시킴

``` java
String strVar1 = "신용권";
String strVar2 = "신용권";
String strVar3 = new String("신용권");
```

- 자바는 문자열 리터럴이 동일하다면 동일한 String 객체를 참조하도록 되어 있음
- strVal1과 strVal2는 동일한 String 객체의 번지값을 가지고 있음
- 변수 strVar3은 객체 생성 연산자인 new로 생성한 새로운 String 객체의 번지값을 가지고 있음

``` java
strVal1 == strVar2 // true
strVar2 == strVar3 // false
```

- 동일한 String 객체이건 다른 String 객체이건 상관없이 String 객체의 문자열만을 비교하고 싶다면 equals() 메소드를 사용해야 함
- equals() 메소드는 원본 문자열과 매개값으로 주어진 비교 문자열이 동일한지 비교한 후 true 또는 false를 리턴

``` java
strVar1.equals(strVar2)	//true
strVar2.equals(strVar3)	//true
```

---

#### 3.4.4 논리 연산자(&&, ||, &, |, ^, !)

- 논리 연산자는 논리곲(&&), 논리합(||), 배타적 논리합(^), 논리 부정(!) 연산을 수행

- 논리 연산자의 피연산자는 boolean 타입만 사용 가능

|      구분      | 연산식 |      |       | 결과  | 설명                                   |
| :------------: | :----: | :--: | :---: | :---: | -------------------------------------- |
|                |  true  |      | true  | true  |                                        |
|      AND       |  true  |  &&  | false | false | 피연산자 모두가 true일 경우에만 연산   |
|    (논리곱)    | false  | 또는 | true  | false | 결과는 true                            |
|                | false  |  &   | false | false |                                        |
|                |  true  |      | true  | true  |                                        |
|       OR       |  true  | \|\| | false | true  | 피연산자 중 하나만 true이면 연산       |
|    (논리합)    | false  | 또는 | true  | true  | 결과는 true                            |
|                | false  |  \|  | false | false |                                        |
|                |  true  |      | true  | false |                                        |
|      XOR       |  true  |  ^   | false | true  | 피연산자가 하나는 true이고 다른 하나가 |
| (배타적논리합) | false  |      | true  | true  | false일 경우에만 연산 결과는 true      |
|                | false  |      | false | false |                                        |
|      NOT       |        |  !   | true  | false | 피연산자의 논리값을 바꿈               |
|   (논리부정)   |        |      | false | true  |                                        |

---

#### 3.4.5 비트 연산자

- 비트 연산자는 데이터를 비트(bit) 단위로 연산

---

#### 3.4.6 대입 연산자

- 대입 연산자는 오른쪽 피연산자의 값을 좌측 피연산자인 변수에 저장

| 구분             | 연산식 |      |          | 설명                                                         |
| ---------------- | ------ | ---- | -------- | ------------------------------------------------------------ |
| 단순 대입 연산자 | 변수   | =    | 피연산자 | 우측의 피연산자의 값을 변수에 저장                           |
|                  | 변수   | +=   | 피연산자 | 우측의 피연산자의 값을 변수의 값과 더한 후에 <br>다시 변수에 저장(변수 = 변수 + 피연산자 와 동일) |
|                  | 변수   | -=   | 피연산자 | 우측의 피연산자의 값을 변수의 값에서 뺀 후에 <br>다시 변수에 저장(변수 = 변수 - 피연산자 와 동일) |
|                  | 변수   | *=   | 피연산자 | 우측의 피연산자의 값을 변수의 값과 곱한 후에<br/>다시 변수에 저장(변수 = 변수 * 피연산자 와 동일) |
|                  | 변수   | /=   | 피연산자 | 우측의 피연산자의 값으로 변수의 값을 나눈 후 <br/>다시 변수에 저장(변수 = 변수 / 피연산자 와 동일) |
|                  | 변수   | %=   | 피연산자 | 우측의 피연산자의 값으로 변수의 값을 나눈 후 <br/>나머지를 변수에 저장(변수 = 변수 % 피연산자 와 동일) |
| 복합 대입 연산자 | 변수   | &=   | 피연산자 | 우측의 피연산자의 값과 변수의 값을 & 연산 후 <br> 결과를 변수에 저장(변수 = 변수 & 피연산자 와 동일) |
|                  | 변수   | \|=  | 피연산자 | 우측의 피연산자의 값과 변수의 값을 \| 연산 후 <br/>결과를 변수에 저장(변수 = 변수 \| 피연산자 와 동일) |
|                  | 변수   | ^=   | 피연산자 | 우측의 피연산자의 값과 변수의 값을 ^ 연산 후 <br/>결과를 변수에 저장(변수 = 변수 ^ 피연산자 와 동일) |
|                  | 변수   | <<=  | 피연산자 | 우측의 피연산자의 값과 변수의 값을 << 연산 후 <br/>결과를 변수에 저장(변수 = 변수 << 피연산자 와 동일) |
|                  | 변수   | >>=  | 피연산자 | 우측의 피연산자의 값과 변수의 값을 >> 연산 후 <br/>결과를 변수에 저장(변수 = 변수 >> 피연산자 와 동일) |
|                  | 변수   | >>>= | 피연산자 | 우측의 피연산자의 값과 변수의 값을 >>> 연산 후<br/>결과를 변수에 저장(변수 = 변수 >>> 피연산자 와 동일) |

---

### 3.5 삼항 연산자

- 삼항 연산자(?:)는 세 개의 피연산자를 필요로 하는 연산자를 말함
- 삼항 연산자는 ? 앞의 조건식에 따라 콜론(:) 앞뒤의 피연산자가 선택되고 해서 조건 연산식이라고 부르기도 함

---

### 4.1 코드 실행 흐름 제어

- 자바 프로그램을 시작하면 main() 메소드의 시작 중괄호 { 에서 시작해서 끝 중괄호 } 까지 위에서부터 아래로 실행하는 흐름을 가지고 있음
- 실행 흐름을 개발자가 원하는 방향으로 바꿀수 있도록 해주는 것이 흐름 제어문 (간단히 제어문이라 함)
- 조건식의 연산 결과에 따라 블록 내부의 실행 여부가 결정됨
- 조건문에는 if문, switch문이 있고, 반복문에는 for문, while문, do-while문이 있음
