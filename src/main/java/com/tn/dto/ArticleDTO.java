package com.tn.dto;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleDTO {
    private Integer id;

    private String title;

    private String content;

    private Date createDate;

    private String categoryName;

    private String image;
}
