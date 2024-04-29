package net.commercebank.cb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.commercebank.cb.dto.AccountDto;
import net.commercebank.cb.entity.Type;
import net.commercebank.cb.entity.User;
import net.commercebank.cb.service.AccountService;

@SpringBootTest
public class RealAccountAdd {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAddAccountWithUserDetails() {
        // Given
        AccountDto accountDto = new AccountDto();
        accountDto.setAccount_name("Savings Account");
        accountDto.setAccount_type(Type.SAVINGS);
        accountDto.setBalance_amt(1000.0);
        
        // Create a User object
        User user = new User();
        user.setFirstName("Michael");
        user.setLastName("Georgi");
        user.setUsername("mgeorgi");
        user.setPassword("Naruto11");
        user.setTotalDeposited(1000.0);
        user.setTotalWithdrawn(1000.0);

        // Set the User
        accountDto.setUser(user);

        // When
        AccountDto createdAccountDto = accountService.createAccount(accountDto);

        // Then
        assertNotNull(createdAccountDto);
        assertNotNull(createdAccountDto.getAccount_id());

        // Check if account details match
        assertEquals(accountDto.getAccount_name(), createdAccountDto.getAccount_name());
        assertEquals(accountDto.getAccount_type(), createdAccountDto.getAccount_type());
        assertEquals(accountDto.getBalance_amt(), createdAccountDto.getBalance_amt());

        // Check if user details match
        User createdUser = createdAccountDto.getUser();
        assertNotNull(createdUser);
        assertEquals(user.getFirstName(), createdUser.getFirstName());
        assertEquals(user.getLastName(), createdUser.getLastName());
        assertEquals(user.getUsername(), createdUser.getUsername());
        assertEquals(user.getPassword(), createdUser.getPassword());
        assertEquals(user.getTotalDeposited(), createdUser.getTotalDeposited());
        assertEquals(user.getTotalWithdrawn(), createdUser.getTotalWithdrawn());

        // Clean up (delete the account from the database)
        // This step depends on your implementation
    }
}
