package com.github.idimabr.springbank.controllers;

import com.github.idimabr.springbank.dtos.TransactionDTO;
import com.github.idimabr.springbank.dtos.UserDTO;
import com.github.idimabr.springbank.entities.Transaction;
import com.github.idimabr.springbank.entities.User;
import com.github.idimabr.springbank.services.TransactionService;
import com.github.idimabr.springbank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
