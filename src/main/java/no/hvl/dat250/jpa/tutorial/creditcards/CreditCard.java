package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToOne
    @JoinColumn(name = "pincode_id")
    private Pincode pincode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CreditCard() {}

    public Long getId() {
        return id;
    }
    public Integer getNumber() {
        return balance;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Integer getBalance() {
        return number;
    }
    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    public Integer getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }
    public Bank getOwningBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public Pincode getPincode() {
        return pincode;
    }
    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}