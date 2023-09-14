package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Bidirectional many-to-many relation
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Address> addresses = new HashSet<>();

    @OneToMany
    private Set<CreditCard> creditCards = new HashSet<>();

    // Get- and set-methods
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }
    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    
    @Override
    public String toString() {
        return "Person [Name = " + name 
               +  ", address = " + addresses 
            + ", credit card = " + creditCards + "]";
    }
}
