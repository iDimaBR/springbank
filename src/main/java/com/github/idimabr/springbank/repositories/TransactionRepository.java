package com.github.idimabr.springbank.repositories;

import com.github.idimabr.springbank.entities.Transaction;
import com.github.idimabr.springbank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
