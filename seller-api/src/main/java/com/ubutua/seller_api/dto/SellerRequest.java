package com.ubutua.seller_api.dto;

import com.ubutua.seller_api.models.Seller;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SellerRequest {

    @NotBlank(message = "Name can not be Blank")
    @Size(min = 3, max = 255, message = "Name length min=3 and max=255")
    private String name;

    @Min(value = 0, message = "Salary min value = 0")
    private Double salary;

    @Min(value = 0, message = "Bonus min value = 0")
    @Max(value = 100, message = "Gender min value = 100")
    private Double bonus;

    @Min(value = 0, message = "Gender min value = 0")
    @Max(value = 1, message = "Gender min value = 1")
    private Integer gender;



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

    public Seller toEntity(){
        Seller seller = new Seller();
        seller.setName(name);
        seller.setSalary(salary);
        seller.setBonus(bonus);
        seller.setGender(gender);

        return seller;
    }

}
