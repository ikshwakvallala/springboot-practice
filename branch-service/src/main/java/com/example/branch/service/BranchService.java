package com.example.branch.service;

import com.example.branch.domain.Branch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BranchService {

    public abstract String getBranchById(int id);

    public abstract Boolean saveBranch(Branch branch);

    public abstract boolean updateBranch(Branch branch);

    public abstract void deleteBranch(int branchId);

    public abstract List<Branch> getAllBranches();

}
