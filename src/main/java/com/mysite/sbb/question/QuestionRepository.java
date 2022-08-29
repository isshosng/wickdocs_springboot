package com.mysite.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    /*
    리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속함. JpaRepository를 상속할 때는
    제네릭 타입으로 리포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK 속성 타입(Integer)을 지정해야함
     */
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
}
