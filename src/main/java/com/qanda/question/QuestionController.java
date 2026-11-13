package com.qanda.question;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list (Model model) { // 매개변수 Model : 객체가 자동으로 생성됨
        List <Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList); // 전달받은 model 객체에 questionList 넣기
        return "question_list";
    }
}
