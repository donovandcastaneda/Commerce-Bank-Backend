package net.commercebank.cb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.commercebank.cb.entity.Role;

@Data
@AllArgsConstructor
public class UserDto {
	private Integer id;

	private String firstName;

	private String lastName;

	private String username;

	private String password;

	private double balance; //added from account

	private Role role;

}
