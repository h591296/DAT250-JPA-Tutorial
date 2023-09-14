package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankName;

    // Bidirectional one-to-many relation
    @OneToMany(mappedBy = "owningBank")
    private Set<CreditCard> ownedCards = new HashSet<>();

    // Get- and set-methods
    public Long getId() {
        return id;
    }
    public String getName() {
        return bankName;
    }
    public void setName(String bankNavn) {
        this.bankName = bankNavn;
    }
    public Set<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    @Override
    public String toString() {
        return "CreditCard [Bank = " + bankName + "]";
    }
}
