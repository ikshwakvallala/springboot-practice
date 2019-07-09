package com.example.branch.repository;

import com.example.branch.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Integer> {

  @Modifying
  @Query("UPDATE Branch SET address_id = NULL WHERE (branch_code = :branch_code)")
  void deleteAddressId(@Param("branch_code") int branchCode);

  @Modifying
  @Query("DELETE FROM Branch WHERE (branch_code = :branch_code)")
  void deleteBranch(@Param("branch_code") int branchCode);

}
