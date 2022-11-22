package com.tn.controller;

import com.tn.entity.Account;
import com.tn.entity.Article;
import com.tn.entity.Category;
import com.tn.repository.AccountRepository;
import com.tn.service.AccountService;
import com.tn.service.ArticleService;
import com.tn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAll(Model model){
        List<Account>accounts = accountService.getAllData();
        List<Article> articles=articleService.getAllData();
        List<Category> categories =categoryService.getAllData();
        System.out.println(articles);
        System.out.println();
        model.addAttribute("listArticle",articles);
        System.out.println(accounts);
        System.out.println();
        model.addAttribute("listAccount",accounts);
        System.out.println(categories);
        System.out.println();
        model.addAttribute("listCategory",categories);
        return "account-list";
    }

    @GetMapping("detele/{id}")
    public  String deteleAccount(@PathVariable Integer id){
        System.out.println(id);
        accountService.deteleAccount(id);
        return "redirect:/account";
    }


    @PutMapping("update")
    public ResponseEntity<?> updateAccount(@PathVariable Integer id,
                                            @PathVariable String AfullName,
                                            @PathVariable String AuserName,
                                            @PathVariable String Apassword,
                                            @PathVariable String Aemail){
      accountService.updateAccount(id, AfullName, AuserName, Apassword, Aemail);
       return new ResponseEntity<>("UPDATE Thành Công",HttpStatus.OK);
    }


    @PostMapping("save")
    public String saveAccount(){
        Account account = new Account();
        account.setUserName("");
        account.setFullName("");
        account.setPassword("");
        account.setEmail("");
        accountRepo.save(account);
        return "Save success";
    }


}
//    @PostMapping("product/save")
//    public String save(){
//        Product product = new Product();
//        product.setProductName("Iphone");
//        productRepo.save(product);
//
//        return "save success";
//
//    }

//    @PostMapping("login/{userName}/passWord")
//    public String login(@RequestParam String userName,
//                        @RequestParam String passWord){
//        if (userName.equals("admin") && passWord.equals("123456")){
//            return "Đăng Nhập Thành Công";
//        }else {
//            return "Đăng Nhập Thất Bại";
//        }
//    }