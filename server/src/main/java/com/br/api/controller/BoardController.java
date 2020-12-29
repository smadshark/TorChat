package com.br.api.controller;

import com.br.api.model.ifs.CrudInterface;
import com.br.api.model.network.Header;
import com.br.api.model.network.reqest.BoardApiRequest;
import com.br.api.model.network.response.BoardApiResponse;
import com.br.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/board")
public class BoardController implements CrudInterface<BoardApiRequest, BoardApiResponse> {
    @Autowired
    private BoardService boardService;

    @Override
    @PostMapping("")
    public Header<BoardApiResponse> create(@RequestBody Header<BoardApiRequest> req) {
        return boardService.create(req);
    }

    @Override
    @GetMapping("{id}")
    public Header<BoardApiResponse> read(@PathVariable Long id) {
        return boardService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<BoardApiResponse> update(Header<BoardApiRequest> req) {
        return boardService.update(req);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return boardService.delete(id);
    }
}
