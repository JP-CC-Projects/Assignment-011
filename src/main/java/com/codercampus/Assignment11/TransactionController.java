package com.codercampus.Assignment11;
import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class TransactionController {
    final TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("")
    public String getRootWebPage (ModelMap modelMap){
        modelMap.put("String", new Object());
        return "redirect:/transactions";
    }
    @GetMapping("/transactions")
    public String transactionsList(ModelMap modelMap){
        List<Transaction> listOfAllTransactionsByDate = transactionService.listOfAllTransactionsByDate();
        modelMap.put("listOfAllTransactionsByDate", listOfAllTransactionsByDate);
        return "transactions";
    }
    @GetMapping("/transactions/{transactionId}")
    public String getSingleTransaction (@PathVariable Long transactionId, ModelMap modelMap){
        Transaction transaction = transactionService.findById(transactionId);
        modelMap.put("transaction", transaction);
        return "singletransaction";
    }
    @PostMapping("/transactions")
    public String postRootWebPage (Transaction transaction){
        Transaction savedTransaction = transactionService.save(transaction);
        return "redirect:/transactions";
    }
}
