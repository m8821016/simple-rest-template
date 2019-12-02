package com.example.simpleresttemplate.controller;

import com.example.simpleresttemplate.dao.AccountDaoImpl;
import com.example.simpleresttemplate.model.Account;
import com.example.simpleresttemplate.model.BulkAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {


    @Autowired
    AccountDaoImpl accountDao;

    @GetMapping(path = "/", produces = "application/json")
    public BulkAccount getBulkAccount() {
        return accountDao.getBulkAccount();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addAccount(@RequestBody Account account) {
        account.setId(UUID.randomUUID());
        accountDao.addAccount(account);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable UUID id) {
        boolean deleted = accountDao.deleteAccount(id);
        if(deleted) {
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
