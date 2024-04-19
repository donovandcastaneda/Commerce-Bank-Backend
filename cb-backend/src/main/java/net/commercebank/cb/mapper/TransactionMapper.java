package net.commercebank.cb.mapper;

import net.commercebank.cb.dto.*;
import net.commercebank.cb.entity.*;

public class TransactionMapper {


        public static Transaction mapToTransaction(TransactionDto transactionDto) {
            Transaction transaction = new Transaction(
                    transactionDto.getTransaction_id(),
                    transactionDto.getTransaction_type(),
                    transactionDto.getTransaction_name(),
                    transactionDto.getAmount(),
                    transactionDto.getTransaction_date(),
                    transactionDto.getAccount()
            );


            return transaction;
        }
        public static TransactionDto mapToTransactionDto(Transaction transaction) {
            TransactionDto transactionDto = new TransactionDto(
                    transaction.getTransaction_id(),
                    transaction.getTransaction_type(),
                    transaction.getTransaction_name(),
                    transaction.getAmount(),
                    transaction.getTransaction_date(),
                    transaction.getAccount()

            );

            return transactionDto;
        }

}
