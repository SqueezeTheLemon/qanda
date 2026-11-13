# qanda

『점프 투 스프링부트』를 따라 질문·답변 게시판(SBB)을 구현하는 프로젝트예요.

- 교재: [점프 투 스프링부트](https://wikidocs.net/book/7601)
- 환경: Spring Boot 4.1.2, Java 25, Gradle 9.8.2 (Kotlin DSL)
- 커밋 번호: 교재 절 번호 + 세부 작업 번호 (예: 1-03 → `103-01`)

## 작업내역

### 102-01 프로젝트 생성, 스프링 프로젝트 기본 설정
- [링크](https://github.com/SqueezeTheLemon/qanda/commit/59cb0e79935afd41d34035054a813556aa6dfa97)
- 작업: 교재 1-02에 따라 프로젝트를 생성했어요. 의존성은 Web MVC, Thymeleaf, JPA, H2, Lombok, Devtools예요. `qanda` 전용 git 저장소도 만들었어요.
- 이유: SBB 구현을 시작하기 위한 기본 뼈대를 준비하고, 홈 폴더 저장소와 분리하기 위해서예요.
- 결과: git 루트가 `qanda`로 잡혔고, `./gradlew test`가 통과했어요.

### 102-02 프로젝트 생성, README 작업내역 추가
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/102-02)
- 작업: `README.md`를 만들고 `## 작업내역`에 102-01 기록을 추가했어요.
- 이유: 모든 작업을 README에 누적 기록하는 미션 규칙을 따르기 위해서예요.
- 결과: README에 작업내역 섹션이 생겼어요.

### 103-01 스프링부트 맛보기, HelloController 추가
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/103-01)
- 작업: 교재 1-03에 따라 `HelloController`를 만들었어요. `@Controller`, `@GetMapping("/hello")`, `@ResponseBody`로 `Hello World` 문자열을 응답해요.
- 이유: URL 요청이 컨트롤러 메서드에 매핑되는 기본 흐름을 확인하기 위해서예요.
- 결과: `./gradlew bootRun`으로 실행한 뒤 브라우저에서 `localhost:8080/hello`에 접속해 `Hello World`가 출력되는 걸 확인했어요.
