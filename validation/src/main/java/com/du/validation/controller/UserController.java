package com.du.validation.controller;

import com.du.validation.dto.UserRequest;
import com.du.validation.entity.UserEntity;
import com.du.validation.service.UserService;
import com.du.validation.util.PasswordUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String list(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@Valid @ModelAttribute("userRequest") UserRequest userRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        model.addAttribute("message", "회원 가입이 성공적으로 완료되었습니다.");
        UserEntity userEntity = userRequest.toEntity();
//        String hashedPassword = PasswordUtil.hashPassword(userRequest.getPassword());
//        UserEntity userEntity = userRequest.toEntity(hashedPassword);
        userService.save(userEntity);
        return "signup";
    }
}
