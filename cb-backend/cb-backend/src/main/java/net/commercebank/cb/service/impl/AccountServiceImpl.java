package net.commercebank.cb.service.impl;

import net.commercebank.cb.entity.*;
import net.commercebank.cb.dto.AccountDto;
import net.commercebank.cb.mapper.AccountMapper;
import net.commercebank.cb.respoitory.*;
import net.commercebank.cb.service.*;
import org.springframework.stereotype.*;


@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

}
