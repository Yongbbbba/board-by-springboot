package com.mysite.sbb.question;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerForm;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionService questionService;

	@GetMapping("/list")
	public String list(Model model, @RequestParam(value="page", defaultValue="0" )int page) {
		Page<Question> paging = this.questionService.getList(page);
		model.addAttribute("paging", paging);
		
		return "question_list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "question_detail";
	}
	
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) { // th:object로 인해 question_form이 questionForm이 필요
		return "question_form";
	}
	
	@PostMapping("/create") // 메서드 오버로딩 사용
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) { // subject, content 항목을 지닌 폼이 전송되면 questionForm으로 스프링이 바인딩 시켜줌
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";  // 질문 저장 후 질문 목록으로 이동
	}
}
