package com.tn.service;

import com.tn.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CategoryService {

    List<Category> getAllData();


    void updateCategory(@Param("id")Integer id,
                        @Param("CcategoryName") String CcategoryName,
                        @Param("Cdescription") String Cdescription);



    void deteleCategory(@Param("id") Integer id);
}
