package com.example.branch.serviceImpl;

import com.example.branch.domain.Branch;
import com.example.branch.repository.AddressRepository;
import com.example.branch.repository.BranchRepo;
import com.example.branch.service.BranchService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private AddressRepository addressRepository;

 /*   @Override
    public String getBranchById(int id) {
        return String.valueOf(branchRepo.getOne(id));
    }*/

  @Transactional
  public String getBranchById(int branchCode) {
    String str = branchRepo.getOne(branchCode).toString();
    JsonParser jsonParser = new JsonParser();
    JsonObject objectFromString = jsonParser.parse(str).getAsJsonObject();
    System.out.println("BranchDetails---->" + objectFromString);
    return String.valueOf(objectFromString);
  }

    @Override
    public Boolean saveBranch(Branch branch) {
        return branchRepo.save(branch)!=null;

    }

    @Transactional
    public Branch getBranchInfo(int branchCode) {
    return branchRepo.getOne(branchCode);
  }

    @Override
    public void deleteBranch(int branchId) {
        Branch branch = branchRepo.getOne(branchId);
        int addressId = branch.getAddress().getAddressId();
        branchRepo.deleteAddressId(branchId);
        branchRepo.deleteById(addressId);
         branchRepo.deleteBranch(branchId);

    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepo.findAll();
    }

    @Override
    public boolean updateBranch(Branch branch) {
        addressRepository.save(branch.getAddress());
        return branchRepo.save(branch)!=null;
    }

}
