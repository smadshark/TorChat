package com.br.api.controller;

import com.br.api.service.BoardService;
import com.br.api.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/Board")
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = boardService.getBoardList();
        return boardList;
    }
}
