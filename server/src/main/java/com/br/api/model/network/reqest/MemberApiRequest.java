package com.br.api.model.network.reqest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberApiRequest {
    private Long memberNo;
    private String account;
    private String password;
    private Integer status;
}
