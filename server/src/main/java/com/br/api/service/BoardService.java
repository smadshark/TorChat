package com.br.api.service;

import com.br.api.model.entity.Board;
import com.br.api.model.ifs.CrudInterface;
import com.br.api.model.network.Header;
import com.br.api.model.network.reqest.BoardApiRequest;
import com.br.api.model.network.response.BoardApiResponse;
import com.br.api.repository.BoardRepository;
import com.br.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoardService implements CrudInterface<BoardApiRequest, BoardApiResponse> {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Header<BoardApiResponse> create(Header<BoardApiRequest> req) {
        BoardApiRequest body = req.getData();
        Board board = Board.builder()
                .subject(body.getSubject())
                .content(body.getContent())
                .status(1)
                .member(memberRepository.getOne(body.getMemberNo()))
                .build();
        Board newBoard = boardRepository.save(board);
        return response(newBoard);
    }

    @Override
    public Header<BoardApiResponse> read(Long id) {
        return boardRepository.findById(id).map(this::response).orElseGet(() -> Header.ERROR("No Board Data"));
    }

    @Override
    public Header<BoardApiResponse> update(Header<BoardApiRequest> req) {
        BoardApiRequest body = req.getData();
        return boardRepository.findById(body.getBoardNo())
        .map(willUpdateBoard -> {
            willUpdateBoard.setStatus(body.getStatus())
                    .setSubject(body.getSubject())
                    .setContent(body.getContent())
                    .setUpdatedAt(LocalDateTime.now());
            return willUpdateBoard;
        })
        .map(updatedBoard -> boardRepository.save(updatedBoard))
        .map(this::response)
        .orElseGet(() -> Header.ERROR("No Board Data"));
    }

    @Override
    public Header delete(Long id) {
        return boardRepository.findById(id)
        .map(willDeleteBoard -> {
            boardRepository.delete(willDeleteBoard);
            return Header.OK();
        })
        .orElseGet(() -> Header.ERROR("No Board Data"));
    }

    private Header<BoardApiResponse> response(Board board) {
        BoardApiResponse body = BoardApiResponse.builder()
                .boardNo(board.getBoardNo())
                .subject(board.getSubject())
                .content(board.getContent())
                .status(board.getStatus())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
//                .member(board.getMember())
                .build();

        return Header.OK(body);
    }
}
