package com.upc.edu.pe.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upc.edu.pe.models.Account;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {



   /* @Query("SELECT q FROM Account q WHERE q.user=?1 and q.password=?2")
    Account getAccountByUsername(String username, String password);*/
}
