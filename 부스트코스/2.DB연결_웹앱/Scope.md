# Scope

## 1.Scope란?

### Scope 종류

1. #### page 

   - 페이지 내부의 지역변수 처럼 사용

   - 서블릿,JSP 관계없이 선언한 그 페이지 내부에서만 사용 

     

2. #### request

   - http요청을 WAS가 받아서 웹 브라우저에게 응답할 때 까지 유지되는 경우 사용

   - 클라이언트로부터 요청이 들어와서 서버가 어떤 일들을 수행한 다음에 응답을 보낼 때 까지 계속 사용가능한  Scope

   - servlet1에서 servlet2파일로 포워딩 시키는 경우 request영역은 같다. 하지만 page영역은 다르다

     

3. #### session

   - 웹 브라우저 별로 변수가 관리되는 경우 사용

   - 세션객체가 생성되어 소멸될 때까지 즉, 요청이 하나가 아니라 여러 개의 요청이 들어와도 계속 남아있을 수 있다.

   - 상태유지 사용할때 관련이 있다

     

4. #### application

   - 웹 어플리케이션이 시작되고 종료될 때 까지 변수가 유지되는 경우 사용

     

   ![img](https://cphinf.pstatic.net/mooc/20180129_297/1517205425406SvaC6_JPEG/2_5_1_scope_.jpg)

출처 http://inheritingjava.blogspot.kr/2011/04/chapter-42-scope-of-javabeans-in-jsp.html





## 2. Page Scope

- PageContext라는 추상클래스를 사용한다.

- JSP 페이지에서는  pageContext라는 내장 객체를 사용하면 된다.   **따로 객체생성할 필요가 없다.**

  ex)pageContext.setAttribute,  pageContext.getAttribute

- 포워드가 될때 Page Scope에 지정된 변수는 사용할 수 없다.

- 사용법은  다른 Scope들과 동일

- **지역변수**처럼 사용된다는 것이 다른 Scope들과의 차이점

- jsp에서 pageScope에 값을 저장 한 후 해당 값을  EL표기법등에서 사용할 때 사용된다.

- 지역 변수처럼 해당 jsp,서블릿 이 실행되는 동안에만 정보를 유지하고자 할 떄 사용된다.





## 3. Request Scope

- Http 요청을 WAS가 받아 웹 브라우저에게 응답할 때까지 변수 값을 유지하고자 할 경우 사용한다.
- HttpServletRequest 객체를 사용한다.
- JSP에서는 request 내장 변수를 사용한다.  **따로 객체생성할 필요가 없다.**
- 서블릿에서는 HttpServletRequest  객체를 사용한다. 
- 값을 저장할 때는  request객체의 setAttribute() 메소드를 사용한다.
- 값을 읽어 들일 때는 request객체의 getAttribute() 메소드를 사용한다.
- **forward 시 값을 유지하고자 사용한다.**





## 4. Session Scope

- 세션은 클라이언트마다 각각 관리해주는 객체다.
- 웹 브라우저 별로 변수를 관리하고자 할 경우 사용한다.
- 웹 브라우저간의 탭 간에는 세션정보가 공유되기 때문에, 각각의 탭에서는 같은 세션정보를 사용할 수 있다.
- HttpSession 인터페이스를 구현한 객체를 사용한다.
- JSP에서는 session 내장 변수를 사용한다.  **따로 객체생성할 필요가 없다.**
- 서블릿에서는 HttpServletRequest의 getSession()메소드를 이용하여 session 객체를 얻는다.
- 값을 저장할 때는 session 객체의 setAttribute() 메소드를 사용한다.
- 값을 읽어 들일 때는 session 객체의 getAttribute()메소드를 사용한다.
- 장바구니처럼 사용자별로 유지가 되어여할 정보가 있을 때 사용한다.



## 5. Application Scope

- 이클립스에서 만드는 Dynamic Web Project 하나가 하나의 웹 Application이다. 이 때의 Web Application  내부에 객체 하나
- 하나의 서버에는 여러개의 Web Application이 존재할 수 있다.
- 웹 어플리케이션이 시작되고 종료될 때까지 변수를 사용할 수 있다.
- ServletContext 인터페이스를 구현한 객체를 사용한다.
- JSP에서는 Application 내장 객체를 사용한다. **따로 객체생성할 필요가 없다.**
- 서블릿의 경우 getServletContext()메소드를 이용하여 Application객체를 이용한다.
- 웹 어플리케이션 하나당 하나의 application객체가 사용된다
- 값을 저장할 때는 application객체의 setAttribute()메소드를 사용한다.
- 값을 읽어 들일 때는 application객체의 getAttribute()메소드를 사용한다.
- **하나의 웹 어플리케이션 내부에 모든 클라이언트가 공통으로 사용해야 할 값이 있을 때 사용한다.**

