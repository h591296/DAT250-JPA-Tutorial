package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;

    // Oppdatert etter slide: Bidirectional many-to-many
    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> owners = new HashSet<>();

    // Empty constructor
    public Address() {}

    // Get- and set-methods
    public Long getId() {
        return id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Set<Customer> getOwners() {
        return owners;
    }
    public void setOwners(Set<Customer> customers) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Address [Street = " + street 
                   +  ", number = " + number + "]";
    }
}
