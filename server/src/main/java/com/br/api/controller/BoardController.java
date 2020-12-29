package com.br.api.controller;

import com.br.api.service.BoardService;
import com.br.api.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public List<BoardVO> getBoardList() {
        return boardService.getBoardList();
    }
}
