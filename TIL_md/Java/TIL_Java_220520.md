# TIL_Java_220520

---

###### 책 - 이것이 자바다 신용권의 Java 프로그래밍 정복 1(p.108 ~ p.124)

---

#### 4.2.1 if문

- 조건식에는 true 또는 false값을 산출할 수 있는 연산식이나, boolean 변수가 올 수 있음
- 조건식이 true면 블록을 실행하고 false이면 블록을 실행하지 않음

``` java
public class IfExample{
    public static void main(String[] args){
        int score = 93;
        
        if(score>=90){
            System.out.println("점수가 90점보다 큽니다.");
            System.out.println("등급은 A 입니다.");
        }
        if(score < 90)
        	System.out.println("점수가 90보다 작습니다.");
        	System.out.println("등급은 B 입니다.");
    }
}
```

실행결과

``` html
점수가 90보다 큽니다.
등급은 A 입니다.
등급은 B 입니다.
```

---

#### 4.2.2 if-else문

- if문은 else 블록과 함께 사용되어 조건식의 결과에 따라 실행 블록을 선택
- if문의 조건식이 true이면 if문의 블록이 실행되고, false이면 else 블록이 실행

``` java
public class IfElseExample{
    public static void main(String[] args){
        int score = 85;
        
        if(score>=90){
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A 입니다.");
        }else {
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B 입니다.");
        }
    }
}
```

실행결과

``` html
점수가 90보다 작습니다.
등급은 B 입니다.
```

---

#### 4.2.3 if-else if-else문

- 조건문이 여러 개인 if문도 있음
- 처음 if문의 조건식이 false일 경우 다른 조건식의 결과에 따라 실행 블록을 선택할 수 있는데, if 블록의 끝에 else if문을 붙이면 됨
- 모든 조건식이 false일 경우 else 블록을 실행하고 if문을 벗어남

``` java
public class IfElseIfElseExample{
    public static void main(String[] args){
        int score = 75;
        
        if(score>=90){
            System.out.println("점수가 100~90 입니다.");
            System.out.println("등급은 A 입니다.");
        } else if(score>=80){
            System.out.println("점수가 80~89 입니다.");
            System.out.println("등급은 B 입니다.");
        } else if(score>=70){
            System.out.println("점수가 70~79 입니다.");
            System.out.println("등급은 C 입니다.");
        } else{
            System.out.println("점수가 70 미만 입니다.");
            System.out.println("등급은 D 입니다.");
        }
    }
}
```

실행결과

``` html
점수가 70~79 입니다.
등급은 C 입니다.
```

- Math.random() 메소드 : 임의의 정수를 뽑는 방법

``` java
public class IfDiceExample{
    public static void main(String[] args){
        int num = (int)(Math.random()*6) + 1;
        
        if(num==1){
            System.out.println("1번이 나왔습니다.");
        } else if(num==2){
            System.out.println("2번이 나왔습니다.");
        } else if(num==3){
            System.out.println("3번이 나왔습니다.");
        } else if(num==4){
            System.out.println("4번이 나왔습니다.");
        } else if(num==5){
            System.out.println("5번이 나왔습니다.");
        } else if(num==6){
            System.out.println("6번이 나왔습니다.");
        }
    }
}
```

실행결과

``` html
4번이 나왔습니다. // 랜덤하게 나옴
```

---

#### 4.2.4 중첩 if문

- if문의 블록 내부에 또 다른 if문을 사용 할 수 있음 => 중첩 if문
- if문 이외에도 switch문, for문, while문, do-while문 또한 서로 중첩시킬 수 있음

``` java
public class IfNestedExample{
    public static void main(String[] args){
        int socre = (int)(Math.random()*20) + 81;
        System.out.println("점수 : " + score);
        
        String grade;
        
        if(score>=90){
            if(score>=95){
                grade = "A+";
            } else {
                grade = "A";
            } 
         } else {
            if(score>=85){
                 grade = "B+";
            } else {
                 grade = "B";
            } 
         }
         System.out.println("학점 : " + grade);
    }
}
```

실행결과

``` html
점수 : 84
학점 : B
```

---

#### 4.2.5 switch문

- switch문은 if문처럼 조건식이 true일 경우에 블록 내부의 실행문을 실행하는 것이 아니라, 변수가 어떤 값을 갖는냐에 따라 실행문이 선택 됨
- switch문은 괄호 안의 값과 동일한 값을 갖는 case로 가서 실행문을 실행시킴

``` java
public class SwitchExample{
    public static void main(String[] args){
        int num = (int)(Math.random()*6) + 1;
        
        Switch(num){
            case 1:
            	System.out.println("1번이 나왔습니다.");
            	break;
            case 2:
            	System.out.println("2번이 나왔습니다.");
            	break;
            case 3:
            	System.out.println("3번이 나왔습니다.");
            	break;
            case 4:
            	System.out.println("4번이 나왔습니다.");
            	break;
            case 5:
            	System.out.println("5번이 나왔습니다.");
            	break;
            default:
            	System.out.println("6번이 나왔습니다.");
            	break;
        }
    }
}
```

실행 결과

``` html
5번이 나왔습니다.  // 랜덤하게 나옴
```

- case 끝에 break가 붙어 있는 이유는 다음 case를 실행하지 말고 switch문을 빠져나가기 위해서 사용함
- break가 없으면 case문을 연달아 실행시킴

``` java
public class SwitchCharExample{
    public static void main(String[] args){
    	char grade = 'B';
    
    	switch(grade){
                case 'A';
                case 'a';
                	System.out.println("우수 회원입니다.");
                	break;
                case 'B';
                case 'b';
                	System.out.println("일반 회원입니다.");
                	break;
                default;
                	System.out.println("손님입니다.");
        }
    }
}
```

실행결과

``` html
일반 회원입니다.
```

---

### 4.3 반복문(for문, while문, do-while문)

- 반복문은 어떤 작업이 반복적으로 실행되도록 할 때 사용
- for문은 반복 횟수를 알고 있을 때 주로 사용
- while문은 조건에 따라 반복할 때 주로 사용

---

#### 4.3.1 for문

- 주어진 횟수만큼 실행문을 반복 실행할 때 적합한 반복 제어문

``` java
public class ForPrintFrom1To10Example{
    public static void main(String[] args){
        for(int i=1; i<=10; i++){
            System.out.println(i);
        }
    }
}
```

실행결과

``` html
1
2
3
4
5
6
7
8
9
10
```

- 초기화식의 역할은 조건식과 실행문, 증감식에서 사용할 변수를 초기화하는 역할
- 초기화식에 선언된 변수는 for문 블록 내부에서 사용되는 로컬 변수
- for문은 또 다른 for문을 내포할 수 있는데, 이것을 중첩된 for문이라고 함

``` java
public class ForMultiplicationTableExample{
    public static void main(String[] args){
        for(int m=2; m<=9; m++){
            System.out.println("*** " + m + "단 ***");
            for(int n=1; n<=9; n++){
                System.out.println(m + " X " + n + " = " + (m*n));
            }
        }
    }
}
```

실행 결과

``` html
*** 2단 ***
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
```