package com.br.api.controller;

import com.br.api.model.ifs.CrudInterface;
import com.br.api.model.network.Header;
import com.br.api.model.network.reqest.MemberApiRequest;
import com.br.api.model.network.response.MemberApiResponse;
import com.br.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/member")
public class MemberController implements CrudInterface<MemberApiRequest, MemberApiResponse> {
    @Autowired
    private MemberService memberService;

    @Override
    @PostMapping("")
    public Header<MemberApiResponse> create(@RequestBody Header<MemberApiRequest> req) {
        return memberService.create(req);
    }

    @Override
    @GetMapping("{id}")
    public Header<MemberApiResponse> read(@PathVariable Long id) {
        return memberService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<MemberApiResponse> update(@RequestBody Header<MemberApiRequest> req) {
        return memberService.update(req);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return memberService.delete(id);
    }

//    @GetMapping("{id}/boardlist")
//    public Header getBoardList(@PathVariable Long id) {
//        return memberService.getBoardList(id);
//    }
}
