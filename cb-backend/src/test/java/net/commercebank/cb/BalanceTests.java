//package net.commercebank.cb;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import net.commercebank.cb.dto.AccountDto;
//import net.commercebank.cb.entity.Account;
//import net.commercebank.cb.repository.AccountRepository;
//import net.commercebank.cb.service.AccountService;
//import net.commercebank.cb.service.impl.AccountServiceImpl;
//
//public class BalanceTests {
//
//    @Mock
//    private AccountRepository accountRepositoryMock;
//
//    @InjectMocks
//    private AccountService accountService = new AccountServiceImpl(accountRepositoryMock);
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetAccountByNumber() {
//        // Given
//        long accountId = 1L;
//        Account account = new Account();
//        account.setAccount_id(accountId);
//        account.setBalance_amt(1000.0);
//        when(accountRepositoryMock.findById(accountId)).thenReturn(java.util.Optional.of(account));
//
//        // When
//        AccountDto retrievedAccountDto = accountService.getAccountByNumber(accountId);
//
//        // Then
//        assertNotNull(retrievedAccountDto);
//        assertEquals(accountId, retrievedAccountDto.getAccount_id());
//        assertEquals(1000.0, retrievedAccountDto.getBalance_amt());
//    }
//}
