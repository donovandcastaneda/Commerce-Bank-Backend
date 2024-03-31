package net.commercebank.cb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.commercebank.cb.entity.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Integer id;

	private String firstName;

	private String lastName;

	private String username;

	private String password;

	private double balance;

	private Role role;

	private double totalDeposited;

	private double totalWithdrawn;



}
