# TIL_Java_220519

---

###### 책 - 이것이 자바다 신용권의 Java 프로그래밍 정복 1 (p.57 ~ p. )

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

```markdown
| First Header  | Second Header | Third Header         |
| :------------ | :-----------: | -------------------: |
| First row     | Data          | Very long data entry |
| Second row    | **Cell**      | *Cell*               |
| Third row     | Cell that spans across two columns  ||
```





```html
| First Header  | Second Header | Third Header         |
| :------------ | :-----------: | -------------------: |
| First row     | Data          | Very long data entry |
| Second row    | **Cell**      | *Cell*               |
| Third row     | Cell that spans across two columns  ||
[Table caption, works as a reference][section-mmd-tables-table1]
```

