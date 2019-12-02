package com.example.simpleresttemplate.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BulkAccount {
    private List<Account> accountList = new ArrayList<Account>();
}
