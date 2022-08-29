package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity // 엔티티로 만들기 위해 Question 클래스에 @Entity 애너테이션을 적용함. @Entity 애너테이션을 적용해야 JPA가 엔티티로 인식함.
public class Question {
    @Id
    /* 고유 번호 id 속성에 적용한 @id 애너테이션은 id 속성을 기본 키로 지정한다. 기본키로 지정하면 이제 id 속성의 값은 데이터베이스에 저장할 때
    동일한 값으로 저장할 수 없다. 고유 번호를 기본키로 한 이유는 고유 번호는 엔티티에서 각 데이터를 구분하는 유효한 값으로 중복되면 안되기때문
    * */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    GeneratedValue 애너테이션을 적용하면 데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장됨
    strategy는 고유번호를 생성하는 옵션으로 GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때
    사용함
     */
    private Integer id;

    @Column(length = 200)
    /*
    엔티티의 속성은 테이블의 컬럼명과 일치하는데 컬럼의 세부 설정을 위해 Column 애너테이션을 사용함
     */
    private String subject;

    @Column(columnDefinition = "TEXT")
    /*
    columnDefinition은 컬럼의 속성을 정의할 때 사용. 해당 내용은 글자수를 제한할 수 없는 경우에 사용함
     */
    private String content;
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    /*
    Answer 앤티티 객체로 구성된 answerList를 속성으로추가하고 OneToMany 애너테이션을 설정함
    이제 질문 객체(question)에서 답변을 참조하려면 question.getAnswerList()를 호출하면 됨
    mappedBy는 참조 엔티티의 속성명이며 Answer 엔티티에서 Question 엔티티를 참조한 속성명 question을
    mappedBy에 전달
     */
}
/*
일반적으로 엔티티에는 Setter 메서드를 구현하지 않고 사용함. 엔티티는 데이터베이스와 바로 연결되어
데이터를 자유롭게 변경할 수 있는 Setter 메서드를 허용하는 것이 안전하지 않다고 판단하기 때문
Setter 없이 엔티티에 값을 저장하려면 롬복의 @Builder 애너테이션을 통한 빌드패턴을 사용하고
데이터를 변경해야 할 경우에는 그에 해당되는 메서드를 엔티티에 추가하여 데이터를 변경
 */