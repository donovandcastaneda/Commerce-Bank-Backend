package net.commercebank.cb.mapper;

import net.commercebank.cb.dto.*;
import net.commercebank.cb.entity.*;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getAccount_id(),
				accountDto.getUser_id(),
				accountDto.getAccount_Type(),
                accountDto.getBalance_amt()
				);
		
		return account;
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
            account.getAccount_id(),
            account.getUser_id(),
            account.getAccount_Type(),
            account.getBalance_amt()
				);
		
		return accountDto;
	}
}