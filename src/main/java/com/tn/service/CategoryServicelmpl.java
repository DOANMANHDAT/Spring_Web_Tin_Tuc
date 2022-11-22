package com.tn.service;

import com.tn.entity.Category;
import com.tn.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> getAllData() {
        return categoryRepo.findAll();
    }

    @Override
    public void updateCategory(Integer id, String CcategoryName, String Cdescription) {

    }

    @Override
    public void deteleCategory(Integer id) {
        categoryRepo.deleteById(id);

    }
}
