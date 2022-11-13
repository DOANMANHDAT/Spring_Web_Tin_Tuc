package com.tn.repository;

import com.tn.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryController extends JpaRepository<Category,Integer> {
}
