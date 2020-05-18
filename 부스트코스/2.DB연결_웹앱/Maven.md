# Maven

애플리케이션을 개발하기 위해 반복적으로 진행 해왔던 작업들을 지워하기 위해 등장한 도구

Maven을 이용하면 빌드,패키징,문서화, 테스트와 테스트 리포팅,git, 의존성 관리,svn 등과 같은 형상 관리 서버와 연동, 배포 등의 작업을 손쉽게 할 수 있다.

## CoC(Convention over Configuration)

Maven을 이해하려면 CoC에 대해 이해 해야한다. CoC는 일종의 관습이며 예를 들어 프로그램의 소스파일은 어떤 위치에 있어야하고, 소스가 컴파일된 파일들은 어떤 위치에 있는지를 미리 정해놨다는 의미이다.



## Maven의 장점

- 편리한 의존성 라이브러리 관리
- 설정파일에 몇 줄을 적어줌으로써 직접 다운로드 하지 않아도 라이브러리 사용가능
- 모든 개발자가 일관된 방식으로 빌드 가능
- 다양한 플러그인을 이용한 자동화 가능



## Maven  기본

Archetype(원형) 을 이용하여 Maven 기반 프로젝트를 생성할 경우 생성된 프로젝트 하위에 아래와 같은 pom.xml파일이 생성된다.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>kr.or.connect</groupId>
    <artifactId>examples</artifactId>
    <packaging>jar</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>mysample</name>
    <url>http://maven.apache.org</url>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### 각 태그의 의미

- #### project 

  pom.xml 파일의 최상위 루트 엘리먼트

- #### modelVersion

   POM model 의 버전

- #### groupId

  프로젝트를 생성하는 조직의 고유 아이디, 일반적으로 도메인의 이름은 거꾸로 작성

- #### artifactId 

  해당 프로젝트에 의해 생성되는 artifact의 고유 아이디를 결정한다. Maven을 통해  pom.xml을 빌드 할 경우 다음과 같은 규칙으로 artifact 가 생성된다. 위 예의 경우 빌드할 경우 examples-1.0-SNAPSHOT.jar 파일이 생성됩니다.

- #### packaging 

  해당 프로젝트를 어떤 형태로 packaging할 것 인지 결정한다. jar,war,ear 등이 있다.

- #### version 

  프로젝트의 현재버전.

- #### name

  프로젝트의 이름

- #### url

  프로젝트 사이트가 있다면 사이트 URL등록 가능

 