package com.example.customer.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "branch")
public class Branch {

    @Id
    private Integer branchCode;

    private String branchName;
    private String branchType;
    private int bankId;
    public Branch() {
    }

    @OneToMany(mappedBy = "branch")
    @JsonManagedReference
    private List<Customer> customerList;

    public Branch(int branchCode, String branchName, String branchType, int bankId, List<Customer> customerList) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.branchType = branchType;
        this.bankId = bankId;
        this.customerList = customerList;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return " {" +
            "branchCode:" + branchCode +
            ", branchName:'" + branchName + '\'' +
            ", branchType:'" + branchType + '\'' +
            ", bankId:'" + bankId + '\'' +
            '}';
    }
}
