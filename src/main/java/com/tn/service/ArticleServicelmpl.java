package com.tn.service;

import com.tn.entity.Article;
import com.tn.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServicelmpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepo;

    @Override
    public List<Article> getAllData() {
        return articleRepo.findAll();
    }

    @Override
    public void updateArticle(Integer id, String Atitle, String Acontent, Date AcreateDate, Date AupdateDate, String Aimage) {

    }

    @Override
    public void deteleArticle(Integer id) {
        articleRepo.deleteById(id);

    }
}
