# qanda

『점프 투 스프링부트』를 따라 질문·답변 게시판(SBB)을 구현하는 프로젝트.

- 교재: [점프 투 스프링부트](https://wikidocs.net/book/7601)
- 환경: Spring Boot 4.1.2, Java 25, Gradle 9.8.2 (Kotlin DSL)
- 커밋 번호: 교재 절 번호 + 세부 작업 번호 (예: 1-03 → 103-01)

## 작업내역

### 102-01 프로젝트 생성, 스프링 프로젝트 기본 설정
- [링크](https://github.com/SqueezeTheLemon/qanda/commit/59cb0e79935afd41d34035054a813556aa6dfa97)
- 작업: 교재 1-02에 따라 프로젝트를 생성했다. 의존성은 Web MVC, Thymeleaf, JPA, H2, Lombok, Devtools. 홈 폴더 저장소와 분리된 qanda 전용 git 저장소를 만들었다.
- 이유: SBB 구현을 시작할 기본 뼈대 준비
- 결과: git 루트가 qanda로 잡히고 테스트 통과 확인 완료

### 102-02 프로젝트 생성, README 작업내역 추가
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/102-02)
- 작업: README를 만들고 작업내역 섹션에 102-01 기록을 추가했다.
- 이유: 모든 작업을 README에 누적 기록하기 위해
- 결과: 작업내역 섹션 생성 완료

### 103-01 스프링부트 맛보기, HelloController 추가
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/103-01)
- 작업: 교재 1-03에 따라 HelloController를 만들고, /hello 요청에 Hello World 문자열을 그대로 응답하도록 했다.
- 이유: URL 요청이 컨트롤러 메서드로 연결되는 기본 흐름 확인
- 결과: 실행 후 브라우저(`localhost:8080/hello`)에 접속하여 텍스트 출력 확인 완료
- 질문:
  - Q. qanda 패키지 안에 다른 패키지를 더 만들어야 하나?
    - A. 아직 필요 없다. 1장은 메인 패키지에 바로 두고, 하위 패키지는 2-06 "도메인별로 분류하기"에서 처음 나눈다.
  - Q. ServletInitializer는 꼭 필요한가?
    - A. 프로젝트 생성 때 war 패키징을 골라서 생긴 파일로, 외부 톰캣에 war로 배포할 때만 쓴다. 교재는 jar와 내장 톰캣을 쓰므로 필요 없다. 그래서 jar로 바꾸기로 했다.
  - Q. Docker를 켜야 하나?
    - A. 필요 없다. H2는 애플리케이션 안에서 함께 도는 내장 DB라 별도 DB 서버가 필요 없다.
  - Q. 실행할 때 "Port 8080 was already in use" 오류가 난다.
    - A. 검증용으로 띄워둔 서버가 8080 포트를 쓰고 있었다. 같은 포트로 서버를 두 개 띄울 수 없어서 생긴 오류로, 기존 서버를 끄고 해결했다.

### 102-03 프로젝트 생성, war에서 jar 패키징으로 전환
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/102-03)
- 작업: 빌드 설정에서 war 플러그인과 외부 톰캣용 의존성을 지우고, ServletInitializer를 삭제했다.
- 이유: 교재와 같은 jar + 내장 톰캣 방식으로 맞추기 위해
- 결과: 빌드·테스트 통과, jar 파일 생성 및 jar 직접 실행 후 /hello 응답 확인 완료

### 104-01 스프링부트 도구 설치하기, Devtools 자동 재시작 확인
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/104-01)
- 작업: 교재 1-04에 따라 /hello 응답을 Hello sbb로 바꾸고 Devtools 자동 재시작을 확인했다. Devtools 의존성은 프로젝트 생성 때 이미 들어 있었다.
- 이유: 코드를 바꿀 때마다 서버를 직접 껐다 켜는 번거로움 줄이기
- 결과: 서버를 켠 채로 다시 컴파일하자 같은 프로세스에서 약 0.5초 만에 재시작됨을 확인했다. 브라우저에서도 바뀐 문구 확인 완료

### 104-02 스프링부트 도구 설치하기, 롬복으로 HelloLombok 작성
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/104-02)
- 작업: 교재 1-04에 따라 HelloLombok을 만들었다. 처음에는 Getter/Setter 애너테이션으로 접근 메서드를 만들었고, 이후 필드를 final로 바꾸고 RequiredArgsConstructor로 생성자를 만들었다.
- 이유: 반복되는 getter, setter, 생성자 코드를 롬복으로 줄이기 위해
- 결과: main 실행 시 hello, 123 출력 확인. 컴파일된 클래스를 열어 보니 getter 두 개와 필드 두 개를 받는 생성자가 실제로 만들어져 있었다.
- 주석 메모:
  - "따로 생성자와 getter setter를 안 만들어도 알아서 만들어주는 애너테이션"
  - "속성을 필요로 하는 생성자가 롬복에 의해 자동으로 생성된다."
  - 보충: Getter는 getter만 만든다. 생성자는 RequiredArgsConstructor가 만들고, 대상은 final 필드다. final 필드는 값을 바꿀 수 없어서 Setter를 붙여도 setter가 생기지 않는다.
- README 형식 변경: 기록 문체를 "~했다"로 바꾸고, 코드 표기를 줄여 말로 풀어 썼다.

### 202-01 간단한 웹 프로그램 만들기, MainController 추가
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/202-01)
- 작업: 교재 2-02에 따라 MainController를 만들고, /sbb 요청에 문자열을 그대로 응답하도록 했다.
- 이유: URL 매핑과 컨트롤러의 역할 익히기
- 결과: 실행 후 브라우저(`localhost:8080/sbb`)에 접속하여 index! 출력 확인 완료

### 203-01 JPA로 데이터베이스 사용하기, H2와 JPA 설정
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/203-01)
- 작업: 교재 2-03에 따라 H2 콘솔을 켜고, 홈 폴더의 local 파일 DB에 연결하도록 설정했다. JPA 설정으로 H2 방언과 ddl-auto update도 추가했다. 의존성은 프로젝트 생성 때 이미 들어 있었다.
- 이유: 엔티티로 테이블을 만들고 데이터를 저장할 DB 준비
- 결과: 실행 후 H2 콘솔(`localhost:8080/h2-console`)에 접속 확인 완료
- 질문:
  - Q. JPA 설정을 빼면 어떻게 되나?
    - A. 스프링 부트는 메모리 DB일 때만 테이블을 자동으로 만든다. 파일 DB는 기본값이 아무것도 안 함이라, ddl-auto를 지정하지 않으면 엔티티를 만들어도 테이블이 생기지 않는다.
  - Q. 프로젝트 폴더에 만든 local.mv.db 파일은 필요한가?
    - A. 필요 없다. 설정의 물결표(~)는 홈 폴더를 뜻해서 실제 DB 파일은 홈 폴더에 생긴다. 프로젝트 안의 빈 파일은 커밋에서 뺐다.

### 204-01 엔티티로 테이블 매핑하기, Question과 Answer 엔티티 작성
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/204-01)
- 작업: 교재 2-04에 따라 Question(제목, 내용, 작성일시, 답변 목록)과 Answer(내용, 작성일시, 질문) 엔티티를 만들었다. 질문 하나에 답변 여러 개가 달리는 관계를 OneToMany와 ManyToOne으로 연결했다.
- 이유: 질문과 답변 데이터를 저장할 테이블을 자바 클래스로 정의하기 위해
- 결과: 테스트 통과. H2 콘솔에서 QUESTION, ANSWER 테이블과 ANSWER의 QUESTION_ID 외래 키 컬럼 확인 완료
- 주석 메모:
  - id 자동 생성: "autoincrement와 비슷한 역할을 한다."
  - columnDefinition: "열 데이터의 유형이나 성격을 정의할 때 사용"
  - 답변 목록: "질문 하나가 삭제되면 answer 모두가 사라진다."
  - 질문 필드: "부모는 question(one), 자식은 answer(many)"
- 시행착오:
  - 교재 코드를 그대로 옮기면서 Answer의 패키지 선언이 교재 패키지(com.mysite.sbb)로 들어갔다. 스프링 부트는 메인 클래스가 있는 패키지와 그 하위에서만 엔티티를 찾기 때문에 Answer를 인식하지 못했고, 앱이 시작되지 않았다. 패키지를 com.qanda로 바로잡아 해결했다.
