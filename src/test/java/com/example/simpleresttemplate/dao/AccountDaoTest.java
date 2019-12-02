package com.example.simpleresttemplate.dao;

import com.example.simpleresttemplate.config.AppConfig;
import com.example.simpleresttemplate.model.Account;
import com.example.simpleresttemplate.model.BulkAccount;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@SpringBootTest
class AccountDaoTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    AccountDao accountDao;

    @Test
    public void test_get_bulkAccoung() {
        assertNotNull(accountDao);
        BulkAccount bulkAccount = accountDao.getBulkAccount();
        assertEquals(2, bulkAccount.getAccountList().size());
    }

    @Test
    public void test_add_bulkAccoung() {
        assertNotNull(accountDao);
        BulkAccount bulkAccount = accountDao.getBulkAccount();
        assertEquals(true, bulkAccount.getAccountList().add(new Account("Dapple")));
        assertEquals(3, bulkAccount.getAccountList().size());
    }

    @Test
    public void test_delete_bulkAccoung() {
        assertNotNull(accountDao);
        BulkAccount bulkAccount = accountDao.getBulkAccount();
        assertEquals(true, bulkAccount.getAccountList().add(new Account("Dapple")));
        assertEquals(3, bulkAccount.getAccountList().size());

        UUID id = bulkAccount.getAccountList().get(2).getId();
        assertEquals(true, accountDao.deleteAccount(id));
    }
}