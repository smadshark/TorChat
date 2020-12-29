package com.br.api.service;

import com.br.api.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private SqlSession sqlSession;

    //회원가입
    public int insertMember(MemberVO vo) {
        return sqlSession.insert("member.insertMember", vo);
    }

    //아이디 조회
    public List<MemberVO> getMemberList(MemberVO vo) {
        return sqlSession.selectList("member.getMemberList", vo);
    }
}
