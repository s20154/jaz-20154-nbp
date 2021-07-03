package com.example.demo.Model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Root{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(
            name = "table",
            dataType = "String")
    private String table;
    @ApiModelProperty(
            name = "currency",
            dataType = "String",
            example = "euro")
    private String currency;
    @ApiModelProperty(
            name = "currency",
            dataType = "String",
            example = "eur")
    private String code;

    @ApiModelProperty(
            name = "currency",
            dataType = "String",
            example = "3.2")
    @Column(name="arguments")
    @ElementCollection(targetClass=String.class)
    private List<Rate> rates;

    public Root() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
