

# TIL_Java_220524

---

###### 책 - 이것이 자바다 신용권의 Java 프로그래밍 정복 1 (p.124 ~ p.136)

---

#### 4.3.2 while문

- while문은 조건식이 true일 경우에 계속해서 반복

``` java
public class WhilePrintFrom1To10Example{
    public static void main(String[] args){
        int i = 1;
        while (i<=10){
            System.out.println(i);
            i++;
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

``` java
public class WhilePrintFrom1To10Example{
    public static void main(String[] args){
        boolean run = true;
        int speed = 0;
        int keyCode = 0;
        
        while(run){
            if(keyCode!=13 && keyCode!=10){
                System.out.println("-------------------------");
                System.out.println("1.증속 | 2.감속 | 3.중지");
                System.out.println("-------------------------");
                System.out.println("선택: ");
            }
            
            keyCode = System.in.read();
            
            if(keyCode==49){
                speed++;
                System.out.println("현재 속도 =" + speed);
            }else if(keyCode == 50){
                speed--;
                System.out.println("현재 속도 =" + speed);
            }else if(keyCode == 51){
                run false;
            }
        }
        
        System.out.println("프로그램 종료");
    }
}
```

---

#### 4.3.3 do-while문

- 조건식에 의해 반복 실행한다는 점에서는 while문과 동일
- 블록 내부의 실행문을 우선 실행시키고 실행 결과에 따라서 반복 실행을 계속할지 결정하는 경우 발생
- 작성 시 주의할 점은 while() 뒤에 반드시 세미콜론(;)을 붙여야 함

---

#### 4.3.4 break문

- break문은 반복문인 for문, while문, do-while문을 실행 중지할 때 사용

``` java
public class WhilePrintFrom1To10Example{
    public static void main(String[] args){
        while(true){
            int num = (int)(Math.random()*6)+1;
            System.out.println(num);
            if(num == 6){
                break;
            }
        }
        System.out.println("프로그램 종료");
    }
}
```

실행결과

``` html
1
5
6
프로그램 종료
```

- 만약 반복문이 중첩되어 있을 경우 break문은 가장 가까운 반복문만 종료하고 바깥쪽 반복문은 종료시키지 않음

---

#### 4.3.5 continue문

- 블록 내부에서 continue문이 실행되면 for문의 증감식 또는 while문, do-while문의 조건식으로 이동
- 반복문을 종료하지 않고 계속 반복을 수행함

``` java
public class WhilePrintFrom1To10Example{
    public static void main(String[] args){
        for(int i=1; i<=10; i++){
            if(i%2 != 0){
                continue;
            }
            System.out.println(i);
        }
    }
}
```

실행결과

``` html
2
4
6
8
10
```

#### 확인문제

3. [Exercise03.java]

``` java
public class WhilePrintFrom1To10Example{
    public static void main(String[] args){
        int sum = 0;
        for(int i=0; i<=10; i++){
            if(i%3 ==0){
                sum += i;
            }
            System.out.println("3의 배수의 합: " + sum);
        }
    }
}
```
4. [Exercise04.java]

``` java
public class WhilePrintFrom1To10Example{
    public static void main(String[] args){
        int num1 = 0;
        int num2 = 0;
        while(num1 + num2 != 5){
            num1 = (int))(Math.random()*6)+1;
            num2 = (int))(Math.random()*6)+1;
            
            System.out.println("(" + num1 + ", " + num2 + ")");
        }
    }
}
```
5. [Exercise05.java]

``` java
public class WhilePrintFrom1To10Example{
    public static void main(String[] args){
        for(int x=1; x<=10; x++){
            for(int y=1; y<=10; y++){
                if((4*x)+(5*y) == 60){
                    System.out.println("(" + x + ", " + y + ")");
                }
            }
        }
    }
}
```
6. [Exercise06.java]

``` java
public class WhilePrintFrom1To10Example{
    public static void main(String[] args){
        for(int i=1; i<=5; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```
