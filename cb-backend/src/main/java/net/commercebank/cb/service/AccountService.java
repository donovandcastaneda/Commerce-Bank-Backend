package net.commercebank.cb.service;

import net.commercebank.cb.dto.*;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountByNumber(Integer id);
	AccountDto getBalance(double balance);


	
}