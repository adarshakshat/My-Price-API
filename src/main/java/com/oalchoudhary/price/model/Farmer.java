package com.oalchoudhary.price.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.scheduling.annotation.Async;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Entity
@Table(name = "farmers")
@EntityListeners(AuditingEntityListener.class)


public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String phone_number;
    @NotBlank
    private String district;
    @NotBlank
    private String state;
    @NotBlank
    private String name;
    @NotBlank
    private String whatsapp_number;
    @JsonManagedReference
    @OneToMany(mappedBy = "farmer",
            cascade = CascadeType.ALL
    )
    private List<Product> productList = new ArrayList<>();

    public Farmer() {
    }

    public Long getId() {
            return id;
    }

    public Farmer(@NotBlank String phone_number, @NotBlank String district, @NotBlank String state, @NotBlank String name, @NotBlank String whatsapp_number) {
        this.phone_number = phone_number;
        this.district = district;
        this.state = state;
        this.name = name;
        this.whatsapp_number = whatsapp_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getDistrict() {
        return this.district;
    }

    public List<Product> getProductList() {
        return productList;
    }


    public String getState() {
        return this.state;
    }


    public String getWhatsapp_number() {
        return whatsapp_number;
    }

    public String getName() {
        return name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setWhatsapp_number(String whatsapp_number) {
        this.whatsapp_number = whatsapp_number;
    }
   // @Async
   // Future <List<Farmer>> findByPhone_Number(String phone_number);



}
