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
	private Integer account_id;


    
	
	@Column(name = "user_id")
	private Integer user_id;



	@Enumerated(value = EnumType.STRING)
	private Type account_Type;


	@Column(name = "balance")
    private double balance_amt;



	public Integer getaccountId() {
        return account_id;
    }

    public void setaccountId(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getuserId() {
        return user_id;
    }

    public void setuserId(Integer user_id) {
        this.user_id = user_id;
    }

   

    public Type getType() {
        return account_Type;
    }

    public void setType(Type account_Type) {
        this.account_Type = account_Type;
    }

    public double getbalanceAmt() {
        return balance_amt;
    }

    public void setbalanceAmt(double balance_amt) {
        this.balance_amt = balance_amt;
    }
	
}