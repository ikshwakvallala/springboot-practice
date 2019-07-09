package com.example.branch.controller;

import com.example.branch.domain.Branch;
import com.example.branch.serviceImpl.BranchServiceImpl;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/branch")
@Controller
public class BranchController {

    @Autowired
    public BranchServiceImpl branchServiceImpl;

    @RequestMapping(value = "/getBranchById/{branchId}",method = RequestMethod.GET,headers = "Accept=application/json")
    @ResponseBody
    public String getBranchById(@PathVariable Integer branchId){
        String branch =branchServiceImpl.getBranchById(branchId);
        return branch;
    }

    @RequestMapping(value = "/getBranchInfo/{branchCode}", method = RequestMethod.GET)
    @ResponseBody
    public Branch getBranchInfo(@PathVariable Integer branchCode) {
        Branch branch = branchServiceImpl.getBranchInfo(branchCode);
        return branch;
    }

    @RequestMapping(value = "/updateBranch", method = RequestMethod.PUT)
    @ResponseBody
    public HttpStatus updateBranch(@RequestBody Branch branch) {
        return branchServiceImpl.updateBranch(branch) ? HttpStatus.LOCKED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/getAllBranchs", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Branch> getAllBranchs() {
//        System.out.println("branch--->" + branch.getBranchType());
        return branchServiceImpl.getAllBranches();
    }

    @RequestMapping(value = "/deleteBranch/{branchId}",method = RequestMethod.DELETE)
    public HttpStatus deleteBranch(@PathVariable Integer branchId){
        branchServiceImpl.deleteBranch(branchId);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/insertBranch" , method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus insertBranch(@RequestBody Branch branch){
        Boolean insertStatus = branchServiceImpl.saveBranch(branch);
        return insertStatus ? HttpStatus.CREATED :  HttpStatus.BAD_REQUEST;
    }

}
