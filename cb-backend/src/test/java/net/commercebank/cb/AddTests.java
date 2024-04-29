package net.commercebank.cb;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.commercebank.cb.dto.AccountDto;
import net.commercebank.cb.entity.Account;
import net.commercebank.cb.entity.Type;
import net.commercebank.cb.mapper.AccountMapper;
import net.commercebank.cb.repository.AccountRepository;
import net.commercebank.cb.service.AccountService;
import net.commercebank.cb.service.impl.AccountServiceImpl;

public class AddTests {

    @Mock
    private AccountRepository accountRepositoryMock;

    @InjectMocks
    private AccountService accountService = new AccountServiceImpl(accountRepositoryMock);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAccount() {
        // Given
        AccountDto accountDto = new AccountDto();
        accountDto.setAccount_id(1L);
        accountDto.setAccount_type(Type.SAVINGS);
        // Mock repository behavior
        Account savedAccount = AccountMapper.mapToAccount(accountDto);
        when(accountRepositoryMock.save(any(Account.class))).thenReturn(savedAccount);

        // When
        AccountDto createdAccountDto = accountService.createAccount(accountDto);

        // Then
        assertNotNull(createdAccountDto);
        assertEquals(accountDto.getAccount_id(), createdAccountDto.getAccount_id());
        assertEquals(accountDto.getAccount_type(), createdAccountDto.getAccount_type());
    }
}