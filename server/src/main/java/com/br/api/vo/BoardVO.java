package com.br.api.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {

    private int idx;
    private int code;
    private String title;
    private String contents;
    private String create_id;
    private String create_ymd;
}
