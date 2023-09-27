package com.codercampus.Assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {

	private List<Transaction> transactions = new ArrayList<>(100);
	private String filePath = "transactions.txt";

	public TransactionRepository () {
		super();
		populateData();
	}

//	// Overloaded constructor for testing
//	public TransactionRepository(String filePath) {
//		this.filePath = filePath;
//		populateData();
//	}

	public Transaction findById(Long transactionId) {
		for (Transaction transaction : transactions) {
			if (transaction.getId().equals(transactionId)) {
				return transaction;
			}
		}
		return null;
	}

	public List<Transaction> findAll () {
		return transactions;
	}

	public void populateData() {
		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
			 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			this.transactions = (List<Transaction>) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
}
