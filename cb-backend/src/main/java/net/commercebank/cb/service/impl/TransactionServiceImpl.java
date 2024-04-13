package net.commercebank.cb.service.impl;

import jakarta.persistence.EntityNotFoundException;
import net.commercebank.cb.dto.TransactionDto;
import net.commercebank.cb.entity.Transaction;
import net.commercebank.cb.mapper.TransactionMapper;
import net.commercebank.cb.repository.*;
import net.commercebank.cb.service.TransactionService;
import org.springframework.stereotype.Service;
@Service
public class TransactionServiceImpl implements TransactionService {

        private TransactionRepository transactionRepository;


        public TransactionServiceImpl(TransactionRepository transactionRepository) {
            this.transactionRepository = transactionRepository;
        }

        public TransactionDto createTransaction(TransactionDto transactionDto) {
            Transaction transaction = TransactionMapper.mapToTransaction(transactionDto);
            Transaction savedTransaction = transactionRepository.save(transaction);
            return TransactionMapper.mapToTransactionDto(savedTransaction);
        }




        public TransactionDto getTransactionByNumber(long transaction_id) {
            Transaction transaction = transactionRepository.findById(transaction_id)
                    .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
            return TransactionMapper.mapToTransactionDto(transaction);
        }

//	public TransactionDto getBalance(double balance) {
//		// TODO Auto-generated method stub
//		throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
//	}



    }
