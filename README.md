# 4월 8일 2인 DB 연동 실습과제
### 요구사항

- 회원 Entity를 포함한 최소 2개 이상의 Entity 설계
- 최소 두 개의 Entity는 Relation을 가지고 있음
- 기능은 기본적인 CRUD 기능을 가지고 있음
- 회원과 관련된 주제는 본인(팀원)과 협의 후 아이디어 선정하여 개발
- 객체지향, 자료구조, 디자인패턴, 예외처리 등 기본 기능 외 추가하거나 보완사항 발표내용 포함
- 주제 및 기능정의, 설계외 협업과정과 협의내용등도 발표 포함

### ERD
<img width="622" alt="image" src="https://github.com/Jyebin/shinhan-academy/assets/108725996/aac658a2-f6b7-4f99-919e-66f0f680218d">

### Table
| 테이블 | 컬럼 이름 | 데이터 타입 |
|--------|-----------|------------|
| USERS  | USER_ID   | NUMBER(10) |
|        | USER_NAME | VARCHAR2(10) |
|        | PW        | VARCHAR(20) |
|        | BIRTH     | VARCHAR2(8) |
|        | EMAIL     | VARCHAR2(30) |
|        | ADDRESS   | VARCHAR2(30) |
|        | SEX_CODE  | NUMBER(1) |
|        | ACCOUNT_NUM | NUMBER(12) |


| 테이블 | 컬럼 이름 | 데이터 타입 |
|--------|-----------|------------|
| ACCOUNT| ACCOUNT_ID | NUMBER(10) |
|        | OPEN_DATE | DATE |
|        | OPEN_POINT| VARCHAR2(20) |
|        | ACCOUNT_OWNER | VARCHAR2(10) |
|        | BALANCE   | NUMBER(15) |
|        | IS_OPEN_BANK | VARCHAR2(1) |
|        | ACCOUNT_NUM | VARCHAR2(15) |


| 테이블 | 컬럼 이름 | 데이터 타입 |
|--------|-----------|------------|
| BANK   | BANK_ID   | NUMBER(10) |
|        | BANK_NAME | VARCHAR2(20) |
|        | BANK_TEL  | VARCHAR2(20) |
|        | BANK_LOCATION | VARCHAR2(20) |
|        | ACCOUNT_ID| NUMBER(10) |

### Coding Conventions
- Class, Method : PascalCase
- Function, Variable : camelCase
- SQL : snake_case, UPPER_CASE

### Design Pattern
- DAO Pattern 사용

### 기능
- 사용자 생성, 조회, 삭제
- 계좌 생성, 조회, 삭제
- 은행 생성, 조회, 삭제

### UI
- 유니코드 사용
<img width="202" alt="image" src="https://github.com/Jyebin/shinhan-academy/assets/108725996/38f02d85-8ff5-4a0e-b58e-5ea502d3abdf">
<img width="198" alt="image" src="https://github.com/Jyebin/shinhan-academy/assets/108725996/99698ab8-8bbb-4607-bc10-98d5a07d2241">
