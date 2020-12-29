package com.br.api.model.network.response;

import com.br.api.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardApiResponse {
    private Long boardNo;
    private String subject;
    private String content;
    private Integer status;
    private int viewCnt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Member member;
}
