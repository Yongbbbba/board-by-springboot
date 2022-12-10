package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mysite.sbb.answer.Answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity  // JPA가 이거로 엔터티로 인식함
public class Question {
	
	@Id   // 기본키로 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 해당 칼럼만의 독립적인 시퀀스로 번호를 1씩 증가시킴
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")  // 컬럼 속성 정의. @Transient는 칼럼으로 인식하고 싶지 않을 때 사용
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // 이렇게 하면 양방향 매핑, mappedBy를 쓰는 쪽은 양방향 관계의 주인이 아니다. N:1에서 N이 연관관계의 주인으로 설정해야함
	private List<Answer> answerList;
}
