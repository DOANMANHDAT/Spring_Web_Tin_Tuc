package com.tn.repository;

import com.tn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountController extends JpaRepository<Account,Integer> {
}
