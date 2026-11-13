package com.qanda.question;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list (Model model) { // 매개변수 Model : 객체가 자동으로 생성됨
        List <Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList); // 전달받은 model 객체에 questionList 넣기
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail (Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}
