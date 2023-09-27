package com.codercampus.Assignment11.repository;
import com.codercampus.Assignment11.domain.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


class TransactionRepositoryTest {

    private TransactionRepository repository;

    @BeforeEach
    void setUp() {
        // Assuming the file is placed in the test resources directory
        repository = new TransactionRepository("src/test/resources/transactions.txt");
    }

    @Test
    void testPopulateData() {
        repository.populateData();
        List<Transaction> transactions = repository.findAll();
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        assertEquals(100, transactions.size());
    }
}




