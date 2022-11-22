package com.tn.controller;

import com.tn.dto.ArticleDTO;
import com.tn.dto.CategoryDTO;
import com.tn.entity.Article;
import com.tn.entity.Category;
import com.tn.repository.ArticleRepository;
import com.tn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController{

    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    private ArticleService articleService;

//    @GetMapping
//    public String getAll(Model model){
//        List<Article> articles=articleService.getAllData();
//        System.out.println(articles);
//        System.out.println();
//        model.addAttribute("listArticle",articles);
//        return "account-list";
//    }
    @GetMapping()
    public String getAllArticle(Model model) {
        List<Article> articles = articleRepo.findAll();
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        articles.forEach(obj -> {
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setId(obj.getId());
            articleDTO.setTitle(obj.getTitle());
            articleDTO.setContent(obj.getContent());
            articleDTO.setCreateDate(obj.getCreateDate());
            System.out.println(obj.getCategory().getCategoryName());
//            articleDTO.setCategoryName(obj.getCategory().getCategoryName());
//            articleDTO.setUpdateDate(obj.getUpdateDate());
//            articleDTO.setImage(obj.getImage());

            articleDTOS.add(articleDTO);
        });
        model.addAttribute("listArticle", articleDTOS);
        return "account-list";
    }
    @GetMapping("detele/{id}")
    public String deteleArticle(@PathVariable Integer id){
        System.out.println(id);
        articleService.deteleArticle(id);
        return "redirect:/account";
    }

//    @PutMapping("update")
//    public ResponseEntity<?> updateArticle(@PathVariable Integer id,
//                                            @PathVariable String Atitle,
//                                            @PathVariable String Acontent,
//                                            @PathVariable Date AcreateDate,
//                                            @PathVariable Date AupdateDate,
//                                            @PathVariable String Aimage){
//        articleService.updateArticle(id, Atitle, Acontent, AcreateDate, AupdateDate, Aimage);
//        return new ResponseEntity<>("UPDATE Thành Công",HttpStatus.OK);
//    }
//
//    @PostMapping("save")
//    public String save(){
//        Article article = new Article();
//        Date date = new Date();
//        System.out.println(date.toString());
//        article.setTitle("");
//        article.setContent("");
//        article.setCreateDate(date);
//        article.setUpdateDate(date);
//        article.setImage("");
//        articleRepo.save(article);
//        return "save success";
//    }

}
