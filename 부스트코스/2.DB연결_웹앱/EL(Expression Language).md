# EL(Expression Language)

값을 표현하는 데 사용되는 스크립트 언어로서 JSP의 기본 문법을 보완하는 역할을 한다.





## 기능

- JSP의 스코프에 맞는 속성사용
- 집합 객체에 대한 접근 방법 제공
- 수치 연산, 관계 연산, 논리 연산자 제공
- 자바 클래스 메소드 호출 기능 제공
- 표현언어만의 기본객체 제공



## 표현방법

#### ${expr}

<jsp:include page ="/module/${skin.id}"/header.jsp" flush="true"/>

<b>${sessionScope.member.id}/</b> 님 환영합니다.



## 표현언어 기본객체

![img](https://cphinf.pstatic.net/mooc/20180130_153/1517281495386qOuqH_PNG/2_6_1__.PNG)





![img](https://cphinf.pstatic.net/mooc/20180130_68/1517282068498tAlQM_PNG/2_6_1____.PNG)





## EL의 데이터 타입

- boolean
- 정수
- 실수
- 문자열
- null



## 객체 접근 규칙

![img](https://cphinf.pstatic.net/mooc/20180130_27/1517286832617YwnDB_PNG/2_6_1_.PNG)

- 표현 1이나 표현 2가 null이면 null을 반환한다.
- 표현1이 Map이라면 표현2를 key로 반환
- 표현 1이 List,배열이면 표현2가 정수일 경우 해당 정수 번째 index에 해당하는 값을 반환한다.
- 만약 정수가 아닐경우 오류가 발생
- 표현 1이 객체인 경우 표현2에  해당하는 getter메소드에 해당하는 메소드를 호출한 결과를 반환한다.



## 연산자

### 수치 연산자

-  + : 덧셈
- \- : 뺄셈
- \* : 곱셈
- / 또는 div : 나눗셈
- % 또는 mod : 나머지
- 숫자가 아닌 객체와 수치 연산자를 사용할 경우 객체를 숫자 값으로 변환 후 연산자를 수행 : ${"10"+1} → ${10+1}
- 숫자로 변환할 수 없는 객체와 수치 연산자를 함께 사용하면 에러를 발생 : ${"열"+1} → 에러
- 수치 연산자에서 사용되는 객체가 null이면 0으로 처리 : ${null + 1} → ${0+1}




### 비교 연산자

- == 또는 eq
- != 또는 ne
- < 또는 lt
- \> 또는 gt
- <= 또는 le
- \>= 또는 ge
- 문자열 비교: ${str == '값'} str.compareTo("값") == 0 과 동일




### 논리 연산자

- && 또는 and
- || 또는 or
- ! 또는 not




### empty연산자, 비교선택 연산자

![img](https://cphinf.pstatic.net/mooc/20180130_17/1517287228502gEf9g_PNG/2_6_1_empty_%2C__.PNG)

