package com.example.simpleresttemplate.dao;

import com.example.simpleresttemplate.model.Account;
import com.example.simpleresttemplate.model.BulkAccount;

import java.util.Optional;
import java.util.UUID;


public class AccountDaoImpl implements AccountDao {

    private static BulkAccount bulkAccount = new BulkAccount();

    {
        this.bulkAccount.getAccountList().add(new Account(UUID.randomUUID(), "Aaple"));
        this.bulkAccount.getAccountList().add(new Account(UUID.randomUUID(), "Baple"));
    }

    public void addAccount(Account account) {
        bulkAccount.getAccountList().add(account);
    }

    public BulkAccount getBulkAccount() {
        return bulkAccount;
    }

    public boolean deleteAccount(UUID id) {
        return this.bulkAccount.getAccountList().removeIf(acct -> acct.getId() == id);
    }

    @Override
    public <S extends Account> S save(S s) {
        return null;
    }

    @Override
    public <S extends Account> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Account> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<Account> findAll() {
        return null;
    }

    @Override
    public Iterable<Account> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public void deleteAll(Iterable<? extends Account> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
