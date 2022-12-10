package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{ // Repository 대상이 되는 엔터티와 그 엔터티의 기본키를 입력
	Question findBySubject(String subject); // 이 메소드가 실행될 때 JPA가 해당 메서드명을 분석하여 쿼리를 만들고 실행한다. findBy + 엔터티의 속성명
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	Page<Question> findAll(Pageable pageable);
}
