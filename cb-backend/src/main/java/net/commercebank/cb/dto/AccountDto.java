package net.commercebank.cb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.commercebank.cb.entity.Type;
import net.commercebank.cb.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	private Long account_id;

	private Type account_type;

    private double balance_amt;

}