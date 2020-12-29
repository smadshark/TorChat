package com.br.api.vo;

import lombok.Data;

@Data
public class BoardVO {

    private int idx;
    private int code;
    private String title;
    private String contents;
    private String create_id;
    private String create_ymd;
}
