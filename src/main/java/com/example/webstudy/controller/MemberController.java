package com.example.webstudy.controller;

import com.example.webstudy.dto.MemberDto;
import com.example.webstudy.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class MemberController {
    private MemberService memberService;

    // 회원가입 페이지
    @GetMapping("/signup")
    public String displaySignup() {
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String executeSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String displayLogin() {

        return "/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/login/result")
    public String displayLoginResult() {

        return "/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/logout/result")
    public String displayLogout() {

        return "/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/denied")
    public String displayDenied() {

        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/info")
    public String displayMyInfo() {

        return "/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String displayAdmin() {

        return "/admin";
    }

}