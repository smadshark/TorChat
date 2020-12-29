package com.br.api.model.network.reqest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardApiRequest {
    private Long boardNo;
    private String subject;
    private String content;
    private Integer status;
    private Long memberNo;
}
