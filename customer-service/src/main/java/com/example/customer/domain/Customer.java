package com.example.customer.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    @Id
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private int contactNumber;
    private String aadharNumber;

   @ManyToOne
   @JoinColumn(name = "branch_code")
   @JsonBackReference
   private Branch branch;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

   @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true,
      targetEntity = Account.class)
    @JsonManagedReference
    private Set<Account>accountSet =new HashSet<>();

  public Customer(int customerId, String firstName, String lastName, String email, int contactNumber,
      String aadharNumber, Address address, Set<Account> accountSet, Branch branch) {
    super();
    this.customerId = customerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.contactNumber = contactNumber;
    this.aadharNumber = aadharNumber;
    this.address = address;
    this.accountSet = accountSet;
    this.branch = branch;
  }
    public Customer() {
    }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(int contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getAadharNumber() {
    return aadharNumber;
  }

  public void setAadharNumber(String aadharNumber) {
    this.aadharNumber = aadharNumber;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Set<Account> getAccountSet() {
    return accountSet;
  }

  public void setAccountSet(Set<Account> accountSet) {
    this.accountSet = accountSet;
  }

  public Branch getBranch() {
    return branch;
  }

  public void setBranch(Branch branch) {
    this.branch = branch;
  }

  @Override
  public String toString() {
    return "{" +
        "customerId=" + customerId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", contactNumber=" + contactNumber +
        ", aadharNumber='" + aadharNumber + '\'' +
        ", address=" + address +
        ", branch:" + branch +
        '}';
  }
}
