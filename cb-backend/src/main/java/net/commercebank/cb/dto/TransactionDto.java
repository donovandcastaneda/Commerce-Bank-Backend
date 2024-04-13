package net.commercebank.cb.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private double amount;

    private LocalDateTime transaction_date;

    private Account account;

}
