package net.commercebank.cb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.commercebank.cb.entity.Account;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long transaction_id;

    private String transaction_type;

    private String transaction_name;

    private double amount;

    private LocalDateTime transaction_date;

    private Account account;

}
