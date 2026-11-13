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
- 질문:
  - Q. `qanda` 패키지 안에 다른 패키지를 더 만들어야 하나요?
    - A. 아직은 아니에요. 1장에서는 메인 패키지에 바로 두고, 하위 패키지는 2-06 "도메인별로 분류하기"에서 처음 나눠요.
  - Q. `ServletInitializer`는 꼭 필요한가요?
    - A. 프로젝트 생성 때 war 패키징을 골라서 자동으로 생긴 파일이에요. 외부 톰캣에 war로 배포할 때만 쓰여요. 교재는 jar 패키징과 내장 톰캣을 쓰기 때문에 필요 없어요. 그래서 jar로 바꾸기로 했어요.
  - Q. Docker를 켜야 하나요?
    - A. 아니요. H2는 애플리케이션 안에서 같이 실행되는 내장 DB라 별도 DB 서버나 Docker가 필요 없어요.
  - Q. 실행할 때 `Port 8080 was already in use` 오류가 나요.
    - A. 검증용으로 띄워둔 서버가 8080을 쓰고 있었어요. 같은 포트로 서버를 두 개 띄울 수 없어서 생긴 오류예요. 기존 서버를 끄고 해결했어요.

### 102-03 프로젝트 생성, war에서 jar 패키징으로 전환
- [링크](https://github.com/SqueezeTheLemon/qanda/tree/102-03)
- 작업: `build.gradle.kts`에서 `war` 플러그인과 `providedRuntime(...tomcat-runtime)`을 지웠어요. `ServletInitializer.java`도 삭제했어요.
- 이유: 교재는 jar 패키징과 내장 톰캣을 써요. 외부 톰캣 배포용 설정은 필요 없어서 교재에 맞췄어요.
- 결과: `./gradlew clean test bootJar`가 통과했고, `build/libs/qanda-0.0.1-SNAPSHOT.jar`가 생겼어요. jar 안에 내장 톰캣이 들어 있고, `java -jar`로 실행해서 `/hello` 응답을 확인했어요.
