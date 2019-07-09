package com.example.account.repository;

import com.example.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {

    @Modifying
    @Query(value = "SELECT type FROM localmysql.account where (customer_id = :customer_id)", nativeQuery = true)
    Collection findExistingAccountType(@Param("customer_id") int customer_id);
}
