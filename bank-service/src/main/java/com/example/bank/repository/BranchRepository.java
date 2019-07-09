package com.example.bank.repository;

import com.example.bank.domain.Address;
import com.example.bank.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {
}
