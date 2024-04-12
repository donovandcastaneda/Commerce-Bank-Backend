package net.commercebank.cb.mapper;

import net.commercebank.cb.dto.*;
import net.commercebank.cb.entity.*;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getAccount_id(),
				accountDto.getAccount_type(),
                accountDto.getBalance_amt(),
				accountDto.getUser()
				);

		return account;
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
            account.getAccount_id(),
            account.getAccount_type(),
            account.getBalance_amt(),
			account.getUser()
				);

		return accountDto;
	}
}