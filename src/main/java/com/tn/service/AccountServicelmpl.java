package com.tn.service;

import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServicelmpl implements AccountService {

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public List<Account> getAllData() {
        return accountRepo.findAll();
    }

    @Override
    public void updateAccount(Integer id, String AfullName, String AuserName, String Apassword, String Aemail) {

    }

    @Override
    public void deteleAccount(Integer id) {
        accountRepo.deleteById(id);

    }
}
