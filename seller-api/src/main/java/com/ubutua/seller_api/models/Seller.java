package com.ubutua.seller_api.models;

import com.ubutua.seller_api.dto.SellerResponse;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_SELLER")
public class Seller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private Double salary;

    private Double bonus;

    @Column(nullable = false)
    private Integer gender;


    public Seller(Long id, String name, Double salary, Double bonus, Integer gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.gender = gender;
    }

    public Seller() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", gender=" + gender +
                '}';
    }

    public SellerResponse toDto(){
        SellerResponse sellerResponse = new SellerResponse();
        sellerResponse.setId(id);
        sellerResponse.setName(name);
        sellerResponse.setSalary(salary);
        sellerResponse.setBonus(bonus);
        sellerResponse.setGender(gender);

        return sellerResponse;
    }
}
