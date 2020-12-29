package com.br.api.vo;

import lombok.Data;

@Data
public class MemberVO {

    private int idx;
    private String user_id;
    private String user_pw;
    private String user_nm;
    private String memo;
    private String create_ymd;
}
