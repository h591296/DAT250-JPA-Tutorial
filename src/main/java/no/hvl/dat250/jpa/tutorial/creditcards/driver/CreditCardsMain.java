package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
            em.getTransaction().begin();
            createObjects(em);
            em.getTransaction().commit();
        }
    }

    private static void createObjects(EntityManager em) {
    
        Customer customer = new Customer();
        customer.setName("Max Mustermann");
        em.persist(customer);

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        em.persist(address);

        CreditCard card1 = new CreditCard();
        card1.setNumber(12345);
        card1.setBalance(-5000);
        card1.setCreditLimit(-10000);
        em.persist(card1);

        CreditCard card2 = new CreditCard();
        card2.setNumber(123);
        card2.setBalance(1);
        card2.setCreditLimit(2000);
        em.persist(card2);

        Pincode pin = new Pincode();
        pin.setPincode("123");
        pin.setCount(1);
        em.persist(pin);

        Bank bank = new Bank();
        bank.setName("Pengebank");
        em.persist(bank);

        // Establish relationships
        customer.getAddresses().add(address);
        customer.getCreditCards().add(card1);
        customer.getCreditCards().add(card2);

        address.getOwners().add(customer);

        card1.setPincode(pin);
        card1.setBank(bank);

        card2.setPincode(pin);
        card2.setBank(bank);

        bank.getOwnedCards().add(card1);
        bank.getOwnedCards().add(card2);
    }
  }