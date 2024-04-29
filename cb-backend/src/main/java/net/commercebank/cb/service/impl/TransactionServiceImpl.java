package net.commercebank.cb.service.impl;

import jakarta.persistence.EntityNotFoundException;
import net.commercebank.cb.dto.TransactionDto;
import net.commercebank.cb.entity.Account;
import net.commercebank.cb.entity.Transaction;
import net.commercebank.cb.mapper.TransactionMapper;
import net.commercebank.cb.repository.*;
import net.commercebank.cb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionMapper.mapToTransaction(transactionDto);

        if (transaction.getAccount() == null) {
            throw new IllegalArgumentException("Account data missing in the transaction");
        }

        Long accountId = transaction.getAccount().getAccount_id();
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + accountId));

        accountRepository.save(account);
        Transaction savedTransaction = transactionRepository.save(transaction);

        return TransactionMapper.mapToTransactionDto(savedTransaction);
    }



    public TransactionDto getTransactionByNumber(long transaction_id) {
        Transaction transaction = transactionRepository.findById(transaction_id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
        return TransactionMapper.mapToTransactionDto(transaction);
    }

}


//	public TransactionDto getBalance(double balance) {
//		// TODO Auto-generated method stub
//		throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
//	}




