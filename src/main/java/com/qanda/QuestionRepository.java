package com.qanda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    // findBy + 엔티티의 속성명과 같은 리포지터리의 메서드를 작성하면 입력한 속성의 값으로 데이터를 조회할 수 있다!
    // AND, LIKE, OR, BETWEEN.. 과 같이 여러 엔터티들을 합쳐서 조회할 수도 있다.
    Question findBySubjectAndContent(String subject, String content); // 💡 메서드 이름의 And → SQL의 where subject = ? and content = ?
    List<Question> findBySubjectLike(String subject); // 💡 결과가 여러 건일 수 있어서 List로 받아요. %는 호출하는 쪽에서 붙여요.
}
