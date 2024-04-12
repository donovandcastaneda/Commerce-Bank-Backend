package net.commercebank.cb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id", nullable = false)
	private Long account_id;

	@Enumerated(value = EnumType.STRING)
	private Type account_type;


	@Column(name = "balance")
    private double balance_amt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Type getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Type account_Type) {
        this.account_type = account_Type;
    }

    public double getBalance_amt() {
        return balance_amt;
    }

    public void setBalance_amt(double balance_amt) {
        this.balance_amt = balance_amt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}