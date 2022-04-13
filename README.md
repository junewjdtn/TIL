# TIL (Today I Learned)
- 오늘 공부한 내용을 남깁니다.

# 내용정리


### CLI 기본 명령어

>* $ cd (폴더명) => 폴더 이동
>* $ cd ..  => 이전 폴더로 이동
>* $ pwd  => 현재 경로를 알려줌
>* $ touch (파일명) =>  파일 생성
>* $ mkdir (폴더명) => 폴더 생성
>* $ ls => 파일 리스트 보기
>* $ ls -a => 숨김파일까지 리스트 보기
>* $ rm (파일) => 파일 완전히 삭제
>* $ mv (파일) (폴더위치)=> 파일 이동
>* $ mv(파일) (폴더가 없는 경우) => 파일 이름을 바꾸는 기능
>* Ctrl + l => 화면 지우기
>* $ start . => 현재 위치한 경로를 GUI에서 열어줌
>* $ cd ~ => 최상위 부모 폴더로 이동


### Markdown

Ctrl + / => 실습한 내용 보는 방법


## vscode 실습

##### 터미널 명령어

>* $ git config --global user.name " 유저명" => 유저명 설정
>* $ git config --global user.email " 유저이메일" => 유저이메일 설정
>* $ git config --global --list => 유저명과 유저 이메일 확인 법
>* $ git init => 폴더를 저장소로 만들기
>* Ctrl + ` => 터미널 창 열기
>* Ctrl + s => 파일 저장
>* $ git add (파일명) => 무대위로 올린다. (staging area)
>* $ git status => 파일의 상태를 확인
>* $ git commit -m "커밋 메시지" => 변경사항을 기록 (commits)
>* $ git log => 변경사항의 내역을 보고 싶어!
>* $ git add . => 현재 위치에 있는 모든 파일을 git에 추가한다
>* $ git log --oneline => 변경사항을 한줄로 보고 싶어!
>* q => 터미널 창에서 명령어 사용하는 창이 뜨지 않을 경우 사용
>* $ git remote add origin (내 github 주소) => 내 깃허브의 주소를 추가해 주는 단계
>* $ git remote -v => github의 주소를 확인하는 방법
>* $ git remote rm origin => github의 주소를 삭제하는 방법
>* $ git push origin master => github에 파일을 업로드 하는 방법
> (로그인 창이 뜸 -> 본인 확인 절차 후(로그인 후) -> 등록하면 완성)

## Typora 실습1
# 제목

- 목록 (-)
  + 목록 (+)
    * 순서가 없는 목록 (*)

1. 순서가 있는 목록
2. 아래에는 자동 목록 생성
   1. 수준 낮추어서 진행 (Tab)

기울임: *글자*  ( * ) (글자) ( * )

굵게 : **글자**  ( ** ) (글자) ( ** )

취소선 : ~~취소선~~  ( ~~ ) (글자) ( ~~ ) 

` 코드

`인라인 코드`

블록 코드 : 

``` git init dasdasdas
git initasd
```

 	

링크 : [표시글자](https://www.youtube.com/)

![대체텍스트]()

인용

> 인용문을 작성한다.
>
> > 겹쳐서도 사용 가능하네요!



표 

Ctrl + t

표 원본 소스 보기

Ctrl + /

| 파충류 | 포유류 | 조류 | 다리갯수 |
| ------ | ------ | ---- | -------- |
|        |        |      |          |
|        |        |      |          |
|        |        |      |          |
|        |        |      |          |

| 1    | 2    | 3    | 4    |
| ---- | ---- | ---- | ---- |
|      |      |      |      |



구분선 ( - ) x3

글을 구분할때,

---

구분합니다.

### Typora 실습2
# Java



## 1. 개요

![](https://blog.kakaocdn.net/dn/cZsyTw/btq0u5VBWge/F7xmauYA6r8nnbXSz2vJhK/img.png)

자바(영어:java)는 썬 마이크로시스템즈의 제임스 고슬링(James Gosling)과 다른 연구원들이 개발한 객체 지향적 프로그래밍 언어이다. 1991년 그린 프로젝트(Green Project)라는 이름으로 시작해 1995년에 발표했다.

>객체 지향 프로그래밍은 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러 개의 독립된 단위, 즉"객체"들의 모임으로 파악하고자 하는 것이다.


## 2. 특징

1. 자바 언어는 다음 5가지 핵심 목표를 지니고 있다.

   - 객체 지향 방법론을 사용해야 한다.
   - 같은 프로그램(바이트코드)이 여러 운영 체제(마이크로프로세서)에서 실행될 수 있어야 한다.
   - 컴퓨터 네트워크 접근 기능이 기본으로 탑재되어 있어야 한다.
   - 원격 코드를 안전하게 실행할 수 있어야 한다.
   - 다른 객체 지향 언어들의 좋은 부분만 가지고 와서 사용하기 편해야 한다.


2. 자바 예제


```java
public class HelloWorldApp {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
```

3.  공식문서

[자바 공식문서 링크](https://docs.oracle.com/javase/8/docs/api/)