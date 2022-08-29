package com.mysite.sbb;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	//객체를 주입하기 위해 사용하는 애너테이션
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		List<Question> all = this.questionRepository.findAll();
		// question 테이블에 저장된 모든 데이터를 조회하기 위해서 리포지터리의 findAll 메서드를 사용함

		assertEquals(2, all.size());
		// 총 2건의 데이터를 저장했기 때문에 데이터의 사이즈가 2인지 확인

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	void testJpa2(){
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}

	@Test
	void testJpa3(){
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1,q.getId());
	}



}
