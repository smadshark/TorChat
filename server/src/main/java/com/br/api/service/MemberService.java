package com.br.api.service;

import com.br.api.model.entity.Member;
import com.br.api.model.ifs.CrudInterface;
import com.br.api.model.network.Header;
import com.br.api.model.network.reqest.MemberApiRequest;
import com.br.api.model.network.response.MemberApiResponse;
import com.br.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MemberService implements CrudInterface<MemberApiRequest, MemberApiResponse> {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Header<MemberApiResponse> create(Header<MemberApiRequest> req) {
        MemberApiRequest body = req.getData();

        Member member = Member.builder()
                .account(body.getAccount())
                .password(body.getPassword())
                .status(1)
                .createdAt(LocalDateTime.now())
                .build();

        Member newMember = memberRepository.save(member);
        return response(newMember);
    }

    @Override
    public Header<MemberApiResponse> read(Long id) {
        return memberRepository.findById(id).map(this::response).orElseGet(() -> Header.ERROR("No Member Data"));
    }

    @Override
    public Header<MemberApiResponse> update(Header<MemberApiRequest> req) {
        MemberApiRequest body = req.getData();
        return memberRepository.findById(body.getMemberNo())
        .map(willUpdateMember -> {
            willUpdateMember.setStatus(body.getStatus())
                    .setAccount(body.getAccount())
                    .setPassword(body.getPassword())
                    .setStatus(body.getStatus())
                    .setUpdatedAt(LocalDateTime.now());
            return willUpdateMember;
        })
        .map(willUpdateMember -> memberRepository.save(willUpdateMember))
        .map(this::response)
        .orElseGet(() -> Header.ERROR("No Member Data"));
    }

    @Override
    public Header delete(Long id) {
        return memberRepository.findById(id)
        .map(willDeleteMember -> {
            memberRepository.delete(willDeleteMember);
            return Header.OK();
        })
        .orElseGet(() -> Header.ERROR("No Member Data"));
    }

//    public Header getBoardList(Long id) {
//        return memberRepository.findById(id)
//        .map(this::response).orElseGet(() -> Header.ERROR("No Member Data"));
//    }

    private Header<MemberApiResponse> response(Member member) {
        MemberApiResponse body = MemberApiResponse.builder()
                .memberNo(member.getMemberNo())
                .account(member.getAccount())
                .password(member.getPassword()) // 암호화 필요
                .status(member.getStatus())
                .loginFailCount(member.getLoginFailCount())
                .passwordUpdatedAt(member.getPasswordUpdatedAt())
                .lastLoginAt(member.getLastLoginAt())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
//                .boardList(member.getBoardList())
                .build();

        return Header.OK(body);
    }


}
