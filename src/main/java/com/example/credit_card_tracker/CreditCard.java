package com.example.credit_card_tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class CreditCard {

    // Fields
    @Id
    @SequenceGenerator(
            name = "credit_card_sequence",
            sequenceName = "credit_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credit_card_sequence"
    )

    private Long id;
    private String name;
    private String bank;
    private Integer annual_fee;
    private LocalDate opening_date;
    private List<String> multipliers;
    private String welcome_bonus;
    @Transient
    private Integer age_years;
    @Transient
    private Integer age_months;

    // Constructors
    public CreditCard() {
    }

    public CreditCard(Long id,
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

    public CreditCard(String name, String bank, Integer annual_fee, LocalDate opening_date,
            List<String> multipliers, String welcome_bonus) {
        this.name = name;
        this.bank = bank;
        this.annual_fee = annual_fee;
        this.opening_date = opening_date;
        this.multipliers = multipliers;
        this.welcome_bonus = welcome_bonus;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getAge_years() {
        return calculateAge().getYears();
    }

    public void setAge_years(Integer age_years) { this.age_years = age_years; }

    public Integer getAge_months() {
        return calculateAge().getMonths();
    }

    public void setAge_months(Integer age_months) { this.age_months = age_months; }

    // Helper Method for Age Getters
    private Period calculateAge() {
        return Period.between(opening_date, LocalDate.now());
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
