package com.br.api.model.network.response;

import com.br.api.model.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberApiResponse {
    private Long memberNo;
    private String account;
    private String password;
    private Integer status;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordUpdatedAt;
    private int loginFailCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Board> boardList;
}
