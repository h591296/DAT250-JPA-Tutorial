package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pincode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private Integer count;

    public Pincode () {}

    public Long getId() {
        return id;
    }
    public String getCode(){
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
}