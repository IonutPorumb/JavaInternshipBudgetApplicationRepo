package com.accenture.transactionapplication.controller.transaction;

import com.accenture.transactionapplication.model.ActionType;
import com.accenture.transactionapplication.model.Product;
import com.accenture.transactionapplication.model.Transaction;
import com.accenture.transactionapplication.service.transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> findAllByProductAndTypeAndAmountBeforeAndAmountAfterOrderByCreatedAtAsc
            (@RequestParam(required = false) Product productId,
             @RequestParam(required = false) ActionType actionType,
             @RequestParam(required = false) Double minAmount,
             @RequestParam(required = false) Double maxAmount,
             @RequestParam(required = false) Integer page,
             @RequestParam(required = false) Integer size) {
        return transactionService.findAllByProductAndTypeAndAmountBeforeAndAmountAfterOrderByCreatedAtAsc
                (productId, actionType, minAmount, maxAmount, page, size);
    }

    @GetMapping("/byAmount")
    public List<Transaction> findAllByAmountBeforeAndAmountAfterOrderByAmountDesc
            (@RequestParam(required = false) Double minAmount,
             @RequestParam(required = false) Double maxAmount) {
        return transactionService.findAllByAmountBeforeAndAmountAfterOrderByAmountDesc(minAmount, maxAmount);
    }

    @GetMapping("/{id}")
    public Transaction findTransactionById(@PathVariable Integer id) {
        return transactionService.findTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public Integer deleteTransactionById(@PathVariable Integer id) {
        return transactionService.deleteTransactionById(id);
    }

    @PostMapping
    public Transaction insertNewTransaction(@RequestBody Transaction transaction) {
        return transactionService.insertNewTransaction(transaction);
    }

    @PutMapping("/{id}")
    public Transaction updateTransactionById(@PathVariable Integer id, @RequestBody Transaction transaction) {
        return transactionService.updateTransactionById(transaction, id);
    }

    @GetMapping("/product-transactions_amount/{id}")
    public Map<Product, List<Double>>reportProductTransactions(@PathVariable Integer id){
        return transactionService.reportProductTransactions(id);
    }

    @GetMapping("/actionType-transaction_amount")
    public Map<ActionType, List<Double>>reportActionTypeTransactions(){
        return transactionService.reportActionTypeTransactions();
    }
}
