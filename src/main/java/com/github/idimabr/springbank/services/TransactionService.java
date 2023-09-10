package com.github.idimabr.springbank.services;

import com.github.idimabr.springbank.dtos.TransactionDTO;
import com.github.idimabr.springbank.entities.Transaction;
import com.github.idimabr.springbank.entities.User;
import com.github.idimabr.springbank.repositories.TransactionRepository;
import com.github.idimabr.springbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public void createTransaction(TransactionDTO transaction) throws Exception {
        final User sender = this.userService.findUserById(transaction.senderID());
        final User receiver = this.userService.findUserById(transaction.receiverID());

        final BigDecimal amount = transaction.amount();
        userService.validateTransaction(sender, amount);

        final boolean isAuthorized = this.authorizeTransaction(amount);
        if(!isAuthorized)
            throw  new Exception("Transação não autorizada.");


        final Transaction newTransaction = new Transaction();
        newTransaction.setAmount(amount);
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));

        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
    }

    public boolean authorizeTransaction(BigDecimal value){
        if(value.compareTo(BigDecimal.ZERO) <= 0) return false;

        final ResponseEntity<Map> response = restTemplateBuilder.build().getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

        if(!response.hasBody()) return false;
        return response.getStatusCode() == HttpStatus.OK && response.getBody().get("message") == "Autorizado";
    }
}
