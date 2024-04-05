package net.commercebank.cb.controller;

import net.commercebank.cb.service.*;
import net.commercebank.cb.dto.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	// Add Account REST API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}


	// Endpoint to get account details by account number
	@GetMapping("/{account_id}")
    public ResponseEntity<AccountDto> getAccountByNumber(@PathVariable Integer account_id) {
        AccountDto account = accountService.getAccountByNumber(account_id);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(account);
    }

	    // Endpoint to perform a transaction (e.g., deposit or withdrawal)
		@PostMapping("/{account_id}/transactions")
		public ResponseEntity<String> performTransaction(
				@PathVariable Integer account_id,
				@RequestParam double balance_amt,
				@RequestParam String type) {
	
			AccountDto account = accountService.getAccountByNumber(account_id);
			if (account == null) {
				return ResponseEntity.notFound().build();
			}
	
			if ("deposit".equalsIgnoreCase(type)) {
				account.setBalance_amt(account.getBalance_amt() + balance_amt);
			} else if ("withdrawal".equalsIgnoreCase(type)) {
				if (account.getBalance_amt() < balance_amt) {
					return ResponseEntity.badRequest().body("Insufficient balance");
				}
				account.setBalance_amt(account.getBalance_amt() - balance_amt);
			} else {
				return ResponseEntity.badRequest().body("Invalid transaction type");
			}
	
			
			return ResponseEntity.ok().body("Transaction completed successfully");
		}
}