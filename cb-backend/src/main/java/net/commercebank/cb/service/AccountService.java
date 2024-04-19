package net.commercebank.cb.service;

import net.commercebank.cb.dto.*;
import net.commercebank.cb.entity.User;

import java.util.List;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountByNumber(long accountId);

//	AccountDto getBalance(long accountId);

}