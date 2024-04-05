package net.commercebank.cb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.commercebank.cb.entity.Type;

@Data
@AllArgsConstructor
public class AccountDto {
	private Integer account_id;

	private Integer user_id;

	private Type account_Type;

    private double balance_amt;

}