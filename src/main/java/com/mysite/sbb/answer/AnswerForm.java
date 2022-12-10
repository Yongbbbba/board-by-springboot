package com.mysite.sbb.answer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	@NotEmpty(message = "내용은 필수 항목입니다.")
	@Size(max = 1000)
	private String content;
}
