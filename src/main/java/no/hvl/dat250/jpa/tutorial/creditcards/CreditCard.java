package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToOne
    private Bank owningBank;

    @ManyToOne
    private Pincode pincode;

    @ManyToMany(mappedBy = "creditCards")
    private Set<Customer> cardOwners = new HashSet<>();

    public CreditCard() {}
}