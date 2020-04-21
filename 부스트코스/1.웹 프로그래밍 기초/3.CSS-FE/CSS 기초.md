# CSS 기초

## 1. CSS선언

```markup
span {
  color : red;
  }
```

- span : selector(선택자)
- color : property
- red : value



### style을 HTML에 적용하는 3가지

1. **inline**

   ```markup
   <p style="border:1px solid gray;color:red;font-size:2em;">
   ```

2. **internal**

   ```markup
   <head>
   <style>
   p  {
     font-size : 2em;
     border:1px solid gray;
     color: red;
   }
   </style>
   </head>
   
   <body>
   <div>...</div>
   </body>
   ```

3. **external**

   ```markup
   <html>
   	<head>
   		<link rel="stylesheet" href="style.css">
   	</head>
   	<body>
   		<div>
   			<p>
   				<ul>
   					<li></li>
   					<li></li>
   					<li></li>
   					<li></li>
   				</ul>
   			</p>
   		</div>
   	</body>
   </html>
   ```

inline은 우선순위를 가지고 inline과 external은 동등한 우선순위를 가진다.



## 2.상속과 우선순위

```markup
<head>
<style>div { color:red; }</style>
<link rel="stylesheet" href="css.css">
</head>
```

```markup
<div id="a" class="b">
	text....
</div>
```



```css
#a{
 color : red;
}

.b{
 color : blue;
}

div{
 color : green;
}
```

**ID > CLASS > ELEMENT 순으로 반영**



## 3.CSS선택자

- tag로 지정하기

```markup
<style>
     span {
       color : red;
     }
 </style>
```

- id로 지정하기

```markup
<style>
     #spantag {
       color : red;
     }
</style>

<body>
     <span id="spantag"> HELLO World! </span>
</body>
```

- class로 지정하기

```markup
<style>
     .spanClass {
     color : red
     }
</style>

<body>
     <span class="spanClass"> HELLO World! </span>
</body>
```





### **CSS Selector의 다양한 활용**

- id, class 요소 선택자와 함께 활용

```css
#myid { color : red }
div.myclassname { color : red }
```

- 그룹 선택 (여러 개 셀렉터에 같은 style을 적용해야 한다면)

```css
h1, span, div { color : red }
h1, span, div#id { color : red }
h1.span, div.classname { color : red }
```

- 요소 선택 (공백) : 자손요소
- 아래 모든 span태그에 red색상이 적용됨

```markup
<div id="jisu">
  <div>
    <span> span tag </span>
  </div>
  <span> span tag 2 </span>
</div>
#jisu span { color : red }
```

- 자식 선택 (>) : 자식은 바로 하위엘리먼트를 가리킵니다.
- 아래는 span tag 2만 red 색상이 적용됩니다.

```markup
<div id="jisu">
  <div>
    <span> span tag </span>
  </div>
  <span> span tag 2 </span>
</div>
#jisu > span { color : red }
```

- n번째 자식요소를 선택합니다. (nth-child)
- 첫번째 단락에 red 색상이 적용됩니다.

```markup
<div id="jisu">
  <h2>단락 선택</h2>
  <p>첫번째 단락입니다</p>
  <p>두번째 단락입니다</p>
  <p>세번째 단락입니다</p>
  <p>네번째 단락입니다</p>
</div>
#jisu > p:nth-child(2) { color : red }
```



## 4.CSS기본 style 변경

**font 색상 변경**

- color : red;
- color : rgba(255, 0, 0, 0.5);
- color : #ff0000;  //16진수 표기법으로 가장 많이 사용되는 방법이죠.

 

**font 사이즈 변경**

- font-size : 16px;
- font-size : 1em;

 

**배경색** 

- background-color : #ff0;
- background-image, position, repeat 등의 속성이 있습니다.
- background : #0000ff url(“.../gif”) no-repeat center top; //한 줄로 정의도 가능

 

**글씨체/글꼴**

- font-family:"Gulim";
- font-family : monospace;



```markup
 <div> 안녕하세요 &#x263a;</div> //☺  웹 화면에는 웃음 표시가 표현되는 코드입니다.
```







## 5.Element 배치 방법

**엘리먼트가 배치되는 방식**

엘리먼트를 화면에 배치하는 것을 layout 작업이라고도 하고, Rendering 과정이라고도 합니다.



```css
display(block, inline, inline-block)
position(static, absolute, relative, fixed)
float(left, right)
```

이 속성을 중심으로 엘리먼트의 배치를 이해할 겁니다.


**엘리먼트가 배치되는 방식 - (display:block)**

display속성이 block이거나 inline-block인 경우 그 엘리먼트는 벽돌을 쌓든 블록을 가지고 쌓입니다.

```markup
<div>block1</div>
<p>block2</p>
<div>block3</div>
```


**엘리먼트가 배치되는 방식 - (display:inline)**

display 속성이 inline인 경우는 우측으로, 그리고 아래쪽으로 빈자리를 차지하며 흐릅니다.

높이와 넓이를 지정해도 반영이 되지 않습니다.

```markup
<div>
  <span>나는 어떻게 배치되나요?</span>
  <span>좌우로 배치되는군요</span>
  <a>링크는요?</a>
  <strong>링크도 강조도 모두 좌우로 흐르는군요</strong>
  모두다 display속성이 inline인 엘리먼트이기 때문입니다.
</div>
```





**엘리먼트가 배치되는 방식 (position:static, relative, absolute)**

엘리먼트 배치가 순서대로만 위아래로 또는 좌우로 흐르면서 쌓이기만 하면, 다양한 배치를 하기 어렵습니다.

position 속성을 사용하면 상대적/절대적으로 어떤 위치에 엘리먼트를 배치하는 것이 수월합니다.

 

**1. position 속성으로 특별한 배치를 할 수 있습니다.**

position 속성은 기본 static입니다.

그냥 순서대로 배치됩니다.

 

**2. absolute는 기준점에 따라서 특별한 위치에 위치합니다.**

top / left / right / bottom 으로 설정합니다.

기준점을 상위엘리먼트로 단계적으로 찾아가는데 static이 아닌 position이 기준점입니다.

 

**3. relative는 원래 자신이 위치해야 할 곳을 기준으로 이동합니다.**

top / left / right / bottom로 설정합니다.

 

**4 fixed는 viewport(전체화면) 좌측, 맨 위를 기준으로 동작합니다.**

[code 바로가기](http://jsbin.com/vegowut/edit?html,css,output)


**엘리먼트가 배치되는 방식 (margin:10px)**

margin으로 배치가 달라질 수 있습니다.

margin은 위 / 아래 / 좌 / 우 엘리먼트와 본인 간의 간격입니다.

따라서 그 간격만큼 내 위치가 달라집니다.


**엘리먼트가 배치되는 방식 (float:left)**

float 속성으로 원래 flow에서 벗어날 수 있고 둥둥 떠다닐 수 있습니다.

일반적인 배치에 따라서 배치된 상태에서 float는 벗어난 형태로 특별히 배치됩니다.

따라서 뒤에 block엘리먼트가 float 된 엘리먼트를 의식하지 못하고 중첩돼서 배치됩니다.

[code 바로가기](http://jsbin.com/cutivij/2/edit?html,css,output)

float의 속성은 이런 특이성 때문에 웹사이트의 전체 레이아웃 배치에서 유용하게 활용됩니다.


**엘리먼트가 배치되는 방식 (box-model)**

블록 엘리먼트의 경우 box의 크기와 간격에 관한 속성으로 배치를 추가 결정합니다.

margin, padding, border, outline으로 생성되는 것입니다.

[code 바로가기](https://www.w3schools.com/css/css_boxmodel.asp)

box-shadow 속성도 box-model에 포함지어 설명할 수 있습니다.

box-shadow는 border 밖에 테두리를 그릴 수 있는 속성입니다.


**엘리먼트의 크기**

block엘리먼트의 크기는 기본적으로는 부모의 크기만큼을 가집니다.

예를 들어, width:100%는 부모의 크기만큼을 다 갖는 것과 같습니다.


**box-sizing과 padding**

padding 속성을 늘리면 엘리먼트의 크기가 달라질 수 있습니다.

box-sizing 속성으로 이를 컨트롤 할 수 있습니다.

box-sizing 속성을 border-box로 설정하면 엘리먼트의 크기를 고정하면서 padding 값만 늘릴 수 있습니다.

[code 바로가기](http://jsbin.com/wosuwop/edit?html,css,output)

 

**layout 구현방법은?**

전체 레이아웃은 float를 잘 사용해서 2단, 3단 컬럼 배치를 구현합니다.

최근에는 css-grid나 flex 속성 등 layout을 위한 속성을 사용하기 시작했으며 브라우저 지원범위를 확인해서 사용하도록 합니다.

특별한 위치에 배치하기 위해서는 position absolute를 사용하고, 기준점을 relative로 설정합니다.

네비게이션과 같은 엘리먼트는 block 엘리먼트를 inline-block으로 변경해서 가로로 배치하기도 합니다.

엘리먼트안의 텍스트의 간격과 다른 엘리먼트간의 간격은 padding과 margin 속성을 잘 활용해서 위치시킵니다.





## 6.float 기반 샘플 화면 레이아웃 구성

html 

```markup
<header>Boost Course is really helpful.</header>
<div id="wrap">
   <nav class="left">
      <ul>
         <li>menu</li>
         <li>home</li>
         <li>name</li>
      </ul>
   </nav>
   <div class="right">
      <h2>
         <span>반가워요!</span>
         <div class="emoticon">:-)</div>
      </h2>
   <ul>
      <li>crong</li>
      <li>jk</li>
      <li>honux</li>
      <li>pobi</li>
   </ul>
   </div>
   <div class="realright">
      oh~ right
   </div>
</div>
<footer>코드스쿼드(주)</footer>
```

css

```css
li {
   list-style:none;
}

header {
   background-color : #eee;
}

#wrap {
   overflow:auto;
   margin:20px 0px;
}

.left, .right, .realright {
   float:left;
   height: 200px;
}

.left {
   width:17%;
   margin-right:3%;
   background-color : #47c;
}

.right {
   width : 60%;
   text-align:center;
   background-color : #47c;
}

.realright {
   width: 17%;
   margin-left:3%;
   background-color : #67c;
}

.right > h2 {
   position:relative;
}

.right .emoticon {
   position:absolute;
   top:0px;
   right:5%;
   color:#fff;
}

footer {
   background-color : #eee;
   clear:left;
}
```