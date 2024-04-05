# 🏠 CozyHouse - 당신이 갖게 될 아늑한 집을 위해

## 🗒️ 프로젝트 요약
- 주택 실거래 공공데이터를 활용해 나에게 딱 맞는 집을 찾도록 도와주는 플랫폼
- 삼성 청년 SW 아카데미(SSAFY) 11기 1학기 Back-End 관통 프로젝트
- 사용 데이터 : OpenAPI 내 "국토교통부 아파트매매 실거래 상세 데이터" 등

<br>

## ✔️ 프로젝트 목표

<br>

📌 Bootstrap, kakao API 등 Library 활용, 더욱 향상된 디자인 및 기능을 구현.  

📌 MVC 기반의 웹 프로젝트를 설계하고 구현.  

📌 DataBase를 구축하여 필요한 데이터를 관리.  

<br>

## ✔️ 프로젝트 일정  

2024-03-22 ~ 2024-03-25

<br>

## ✔️ 팀원
- 11기 광주캠퍼스 Java 전공반 박선홍
- 11기 광주캠퍼스 Java 전공반 황성민

<br>

## ✔️ 기술 스택 
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">

<br>
<br>
<br>

# 📋 전체 테이블 구조

![1.png](/resources/databaseERD/1.png)

![2.png](/resources/databaseERD/2.png)

### board 
![3.png](/resources/databaseERD/3.png)

### dongcode
![4.png](/resources/databaseERD/4.png)

### housedeal
![5.png](/resources/databaseERD/5.png)

### houseinfo
![6.png](/resources/databaseERD/6.png)

### uattention_table (찜 목록)
![7.png](/resources/databaseERD/7.png)

## userinfo 
![8.png](/resources/databaseERD/8.png)

<br>
<br>
<br>

# 💡 기능 구현 

## 1. 필수 기능

### 1.1 - 주택 실거래가 정보 수집
- SQL 파일을 적재하고 주택 실거래가 DTO, DAO를 활용한 데이터 전송

### 1.2 - 주택 실거래가 검색
- 행정동 및 날짜 기준으로 주택 실거래가 검색
- 검색결과는 Kakao Map API를 활용하여 지도에 Marker 찍고 면적, 거래금액 등 표시
- 검색 상세결과는 해당 주텍에 대한 자세한 정보를 볼 수 있게 함(심화 참조)
![01_주택 실거래가 검색](/resources/gif/01_주택_실거래가_검색.gif)


### 1.3 - 회원 관리
- 회원가입 기능 제공
![02_회원가입](/resources/gif/02_회원가입.gif)

- 회원정보 검색(마이페이지) 및 회원정보 수정, 삭제
![03_마이페이지_정보수정.gif](/resources/gif/03_마이페이지_정보수정.gif)

    
### 1.4 - 로그인 관리
- 로그인 및 로그아웃 기능
![04_로그인_로그아웃](/resources/gif/04_로그인_로그아웃.gif)


## 2. 추가 기능

### 2.1 - 주변 업종 정보 검색(카카오맵)
- Kakao Map API를 활용해 주택 근처 편의시설 검색 기능 제공
![05_키워드_주변_시설_검색](/resources/gif/05_키워드_주변_시설_검색.gif)


### 2.2 - 찜 기능
- 원하는 주택을 찜 해 놓는 기능 추가
- 찜한 목록을 마이페이지에서 볼 수 있도록 구현
- 찜 삭제 기능을 통해 마이페이지에서 찜 해 놓은 목록 삭제 가능
![06_찜기능](/resources/gif/06_찜기능.gif)

### 3. 심화 기능

### 3.1 -  공지사항 관리
- 공지사항 등록 등 기능 제공
![07_공지사항_공지작성](/resources/gif/07_공지사항_공지작성.gif)
### 3.2 상세페이지에 시세 정보 그래프 제공
- 상세보기를 선택한 주택의 지난 거래내역을 line-chart로 시각화
- m2를 평 수로 변환하여 더욱 쉽게 주택에 대해 정보를 알 수 있도록 함
- 평수별로 아파트 거래내역 그래프를 볼 수 있도록 기능 차별화
![08_심화_그래프_최고가_최저가.gif](/resources/gif/08_심화_그래프_최고가_최저가.gif)
  <br>
  <br>
  <br>

<hr>


