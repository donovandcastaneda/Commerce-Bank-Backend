package net.commercebank.cb.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id", nullable = false)
    private Long transaction_id;

    @Column(name = "transaction_type")
    private String transaction_type;

    @Column(name = "transaction_name")
    private String transaction_name;


    @Column(name = "amount")
    private double amount;

    @Column(name = "transaction_date")
    private LocalDateTime transaction_date;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public void processTransaction() {
        if (account != null) {
            switch (transaction_type) {
                case "DEPOSIT":
                    account.deposit(amount);
                    break;
                case "WITHDRAWAL":
                    account.withdraw(amount);
                    break;
                default:
                    throw new UnsupportedOperationException("Transaction type " + transaction_type + " is not supported.");
            }
        }
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }


    public String getTransaction_name() {
        return transaction_name;
    }

    public void setTransaction_name(String transaction_name) {
        this.transaction_name = transaction_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
        processTransaction();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        processTransaction();
    }


}
