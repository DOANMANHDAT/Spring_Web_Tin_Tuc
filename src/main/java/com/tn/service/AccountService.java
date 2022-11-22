package com.tn.service;

import com.tn.entity.Account;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AccountService {
    List<Account> getAllData();

    void updateAccount(@Param("id")Integer id,
                       @Param("AfullName")String AfullName,
                       @Param("AuserName")String AuserName,
                       @Param("Apassword") String Apassword,
                       @Param("Aemail") String Aemail);


    void deteleAccount(@Param("id") Integer id);
}
