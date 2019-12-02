package com.example.simpleresttemplate.model;

import lombok.Data;

import javax.persistence.Entity;
//For me, javax.persistence.Id should be used instead of org.springframework.data.annotation.Id. For anyone who encountered this issue, you can check if you imported the right Id class.
//https://stackoverflow.com/questions/4381290/hibernate-exception-org-hibernate-annotationexception-no-identifier-specified
//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import java.util.UUID;


@Data
@Entity
public class Account {
    @Id
    private UUID id;
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public Account(UUID accountId, String name) {
        this.id = accountId;
        this.name = name;
    }

    public String toString() {
        return "Account [id="+this.id+", name="+this.name+"]";
    }
}