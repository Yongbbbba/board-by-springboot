package com.mysite.sbb.question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
	@NotEmpty(message="제목은 필수항목입니다.")
	@Size(max=200)  // 200 byte가 넘으면 안된다는 뜻임
	private String subject;
	
	@NotEmpty(message="내용은 필수항목입니다.")
	private String content;
}
