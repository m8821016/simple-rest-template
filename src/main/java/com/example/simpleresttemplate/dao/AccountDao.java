package com.example.simpleresttemplate.dao;

import com.example.simpleresttemplate.model.Account;
import com.example.simpleresttemplate.model.BulkAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountDao extends CrudRepository<Account, UUID> {
    public void addAccount(Account account);
    public BulkAccount getBulkAccount();
    public boolean deleteAccount(UUID id);
}
