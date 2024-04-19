package net.commercebank.cb.service;

import net.commercebank.cb.dto.TransactionDto;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
    TransactionDto getTransactionByNumber(long transaction_id);
}
