package net.commercebank.cb.repository;

import net.commercebank.cb.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
  

}
