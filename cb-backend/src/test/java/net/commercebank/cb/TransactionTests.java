package net.commercebank.cb;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.commercebank.cb.dto.TransactionDto;
import net.commercebank.cb.entity.Account;
import net.commercebank.cb.entity.Type;
import net.commercebank.cb.repository.AccountRepository;
import net.commercebank.cb.repository.TransactionRepository;
import net.commercebank.cb.service.impl.TransactionServiceImpl;

public class TransactionTests {

    @Mock
    private TransactionRepository transactionRepositoryMock;

    @Mock
    private AccountRepository accountRepositoryMock;

    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionServiceImpl(transactionRepositoryMock, accountRepositoryMock);
    }

    @Test
    public void testDepositTransaction() {
        // Given
        long accountId = 3;
        double amount = 1000.0;
        LocalDateTime transactionDate = LocalDateTime.now();
        String transactionName = "Deposit";
        String transactionType = "DEPOSIT";

        // Mock behavior to retrieve account by ID
        Account account = new Account();
        account.setAccount_id(accountId);
        account.setAccount_type(Type.SAVINGS);
        account.setBalance_amt(1000.0);
        when(accountRepositoryMock.findById(accountId)).thenReturn(java.util.Optional.of(account));

        // When
        TransactionDto depositTransactionDto = new TransactionDto();
        depositTransactionDto.setTransaction_id(1L);
        depositTransactionDto.setAmount(amount);
        depositTransactionDto.setTransaction_date(transactionDate);
        depositTransactionDto.setTransaction_name(transactionName);
        depositTransactionDto.setTransaction_type(transactionType);
        depositTransactionDto.setAccount(account);

        TransactionDto createdTransactionDto = transactionService.createTransaction(depositTransactionDto);

        // Then
        assertNotNull(createdTransactionDto);
        assertEquals(1L, createdTransactionDto.getTransaction_id());
        assertEquals(amount, createdTransactionDto.getAmount());
        assertEquals(transactionDate, createdTransactionDto.getTransaction_date());
        assertEquals(transactionName, createdTransactionDto.getTransaction_name());
        assertEquals(transactionType, createdTransactionDto.getTransaction_type());
        assertEquals(accountId, createdTransactionDto.getAccount().getAccount_id());
    }
}
