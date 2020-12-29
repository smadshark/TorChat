package com.br.api.service;

import com.br.api.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private SqlSession sqlSession;

    public List<BoardVO> getBoardList() {

        List<BoardVO> boardList = sqlSession.selectList("board.getBoardList");

        return boardList;
    }
}
