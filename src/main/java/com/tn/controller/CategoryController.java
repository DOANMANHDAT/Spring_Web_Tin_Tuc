package com.tn.controller;

import com.tn.dto.CategoryDTO;
import com.tn.entity.Article;
import com.tn.entity.Category;
import com.tn.repository.CategoryRepository;
import com.tn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private CategoryService categoryService;

//    @GetMapping
//    public String getAll(Model model){
//        List<Category> categories =categoryService.getAllData();
//        System.out.println(categories);
//        System.out.println();
//        model.addAttribute("listCategory",categories);
//        return "account-list" ;
//    }

    @GetMapping
    public String getAllCategory(Model model){
        List<Category> categories =categoryService.getAllData();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categories.forEach(obj -> {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(obj.getId());
            categoryDTO.setCategoryName(obj.getCategoryName());
            categoryDTO.setDescription(obj.getDescription());

            categoryDTOS.add(categoryDTO);
        });

        model.addAttribute("listCategory",categoryDTOS);
        return "account-list" ;
    }


    @GetMapping("category")
    public String getAll() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categories.forEach(obj -> {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(obj.getId());
            categoryDTO.setCategoryName(obj.getCategoryName());
            categoryDTO.setDescription(obj.getDescription());

            categoryDTOS.add(categoryDTO);

        });
        return "account-list";
    }


    @GetMapping("detele/{id}")
    public String deteleCategory(@PathVariable Integer id) {
        System.out.println(id);
        categoryService.deteleCategory(id);
        return "redirect:/account";
    }

//    @PutMapping("update")
//    public ResponseEntity<?> updateCategory(@PathVariable Integer id,
//                                            @PathVariable String CcategoryName,
//                                            @PathVariable String Cdescription ){
//        categoryService.updateCategory(id, CcategoryName, Cdescription);
//        return new ResponseEntity<>("UPDATE THÀNH CÔng",HttpStatus.OK);
//
//    }
//
//
//
//    @PostMapping("save")
//    public String save(){
//        Category category = new Category();
//        category.setCategoryName("");
//        category.setDescription("");
//        categoryRepo.save(category);
//        return "Save success";
//    }

}
