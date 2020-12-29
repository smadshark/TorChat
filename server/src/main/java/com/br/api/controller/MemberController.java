package com.br.api.controller;

import com.br.api.service.MemberService;
import com.br.api.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PutMapping(value = "/Member")
    public int insertMember(MemberVO member) {
        return memberService.insertMember(member);
    }

    @GetMapping(value = "/Member")
    public List<MemberVO>  selectMember(MemberVO member) {
        return memberService.getMemberList(member);
    }
}
