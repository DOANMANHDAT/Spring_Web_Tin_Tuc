package com.tn.service;

import com.tn.entity.Article;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ArticleService {


    List<Article> getAllData();

    void updateArticle(@Param("id") Integer id,
                       @Param("Atitle")String Atitle,
                       @Param("Acontent") String Acontent,
                       @Param("AcreateDate") Date AcreateDate,
                       @Param("AupdateDate")Date AupdateDate,
                       @Param("Aimage")String Aimage);

    void deteleArticle(@Param("id")Integer id);
}
