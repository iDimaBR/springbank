package com.github.idimabr.springbank.services;

import com.github.idimabr.springbank.dtos.UserDTO;
import com.github.idimabr.springbank.entities.User;
import com.github.idimabr.springbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getBalance().compareTo(amount) < 0){
            throw  new Exception("Saldo insuficiente.");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
    }

    public User findUserByEmail(String email) throws Exception {
        return this.repository.findUserByEmail(email).orElseThrow(() -> new Exception("Usuário não encontrado!"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }
}
