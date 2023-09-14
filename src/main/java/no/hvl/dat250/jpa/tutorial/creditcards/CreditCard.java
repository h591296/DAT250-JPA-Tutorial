package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cardNumber;
    private Integer balance;
    private Integer creditLimit;

    // Bidirectional many-to-one relation
    @ManyToOne
    private Bank owningBank;
  
    // Unidirectional to-1 relation
    @ManyToOne
    private Pincode pincode;

    @ManyToMany(mappedBy = "creditCards")
    private Set<Customer> cardOwners = new HashSet<>();

    // Empty constructor
    public CreditCard() {}

    // Get- and set-methods
    public Long getId() {
        return id;
    }
    public Integer getNumber() {
        return cardNumber;
    }
    public void setNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Integer getBalance() {
        return balance;
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
    public Pincode getPincode() {
        return pincode;
    }
    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }
    public Bank getOwningBank() {
        return owningBank;
    }
    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }

    @Override
    public String toString() {
        return "CreditCard [Card number = " + cardNumber 
                               +  ", balance = " + balance 
                           + ", credit limit = " + creditLimit
                                   + ", bank = " + owningBank 
                                + ", pincode = ***]";
    }
}
