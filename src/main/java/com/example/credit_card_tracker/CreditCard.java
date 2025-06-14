package com.example.credit_card_tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class CreditCard {

    // Fields
    @Id
    private Integer id;
    private String name;
    private String bank;
    private Integer annual_fee;
    private LocalDate opening_date;
    private List<String> multipliers;
    private String welcome_bonus;

    // Constructors
    public CreditCard() {
    }

    public CreditCard(Integer id,
            String name,
            String bank,
            Integer annual_fee,
            LocalDate opening_date,
            List<String> multipliers,
            String welcome_bonus) {
        this.id = id;
        this.name = name;
        this.bank = bank;
        this.annual_fee = annual_fee;
        this.opening_date = opening_date;
        this.multipliers = multipliers;
        this.welcome_bonus = welcome_bonus;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getAnnual_fee() {
        return annual_fee;
    }

    public void setAnnual_fee(Integer annual_fee) {
        this.annual_fee = annual_fee;
    }

    public LocalDate getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(LocalDate opening_date) {
        this.opening_date = opening_date;
    }

    public List<String> getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(List<String> multipliers) {
        this.multipliers = multipliers;
    }

    public String getWelcome_bonus() {
        return welcome_bonus;
    }

    public void setWelcome_bonus(String welcome_bonus) {
        this.welcome_bonus = welcome_bonus;
    }

    // Equals()
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreditCard that = (CreditCard) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(bank, that.bank) && Objects.equals(annual_fee,
                that.annual_fee) && Objects.equals(opening_date, that.opening_date)
                && Objects.equals(multipliers, that.multipliers) && Objects.equals(
                welcome_bonus, that.welcome_bonus);
    }

    // HashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id, name, bank, annual_fee, opening_date, multipliers, welcome_bonus);
    }
}
