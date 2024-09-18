package net.commercebank.cb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.commercebank.cb.entity.Transaction;
import net.commercebank.cb.entity.Type;
import net.commercebank.cb.entity.User;
import org.mapstruct.control.MappingControl;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	private Long account_id;

	private String account_name;

	private Type account_type;

    private double balance_amt;

	private User user;

	private List<Transaction> transactions;





}