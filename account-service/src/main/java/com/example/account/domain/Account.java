package com.example.account.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account implements Serializable {

    @Id
    @Column(name = "account_id",nullable = false)
    private int accountId;
    private String type;
    private double balance;
    private String status;
    private Date createdDate;
    private Date closeDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    public Customer customer;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private Set<Transaction> transactionSet = new HashSet<Transaction>();

    public Account(int accountId, String type, double balance, String status, Date createdDate, Date closeDate, Customer customer) {
        this.accountId = accountId;
        this.type = type;
        this.balance = balance;
        this.status = status;
        this.createdDate = createdDate;
        this.closeDate = closeDate;
        this.customer = customer;
    }

    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "{" +
            "accountId=" + accountId +
            ", type='" + type + '\'' +
            ", balance='" + balance + '\'' +
            ", status='" + status + '\'' +
            ", createdDate='" + createdDate + '\'' +
            ", closeDate='" + closeDate + '\'' +
            ", customer=" + customer +
            '}';
    }
}
