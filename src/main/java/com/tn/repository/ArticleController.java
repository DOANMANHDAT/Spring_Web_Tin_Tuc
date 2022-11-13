package com.tn.repository;

import com.tn.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleController extends JpaRepository<Article,Integer> {
}
