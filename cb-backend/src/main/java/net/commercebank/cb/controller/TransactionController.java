package net.commercebank.cb.controller;

import net.commercebank.cb.dto.AccountDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.commercebank.cb.dto.TransactionDto;
import net.commercebank.cb.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Endpoint to create a new transaction
    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto createdTransaction = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    // Endpoint to get a transaction by its ID
    @GetMapping("/{transaction_id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable long transaction_id) {
        TransactionDto transaction = transactionService.getTransactionByNumber(transaction_id);
        if (transaction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(transaction);
    }
}

