package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public static Transaction save(Transaction transaction) {
        return transaction;
    }
    public void saveTransaction(Transaction transaction){

    }
    public Transaction findById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }


    public List<Transaction> listOfAllTransactionsByDate(){
        return transactionRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Transaction::getDate))
                .collect(Collectors.toList());
    }
}
