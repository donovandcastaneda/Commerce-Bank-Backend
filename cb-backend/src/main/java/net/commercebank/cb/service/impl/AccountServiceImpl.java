package net.commercebank.cb.service.impl;

import jakarta.persistence.EntityNotFoundException;
import net.commercebank.cb.entity.*;
import net.commercebank.cb.dto.AccountDto;
import net.commercebank.cb.mapper.AccountMapper;
import net.commercebank.cb.repository.*;
import net.commercebank.cb.service.*;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.List;


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




	@Override
	public AccountDto getAccountByNumber(long accountId) {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new EntityNotFoundException("Account not found"));
		return AccountMapper.mapToAccountDto(account);
	}	

//	public AccountDto getBalance(double balance) {
//		// TODO Auto-generated method stub
//		throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
//	}



}