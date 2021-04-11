package com.oalchoudhary.price.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String price;

    @NotBlank
    private String quality;

    @NotBlank
    private String unit;

    @NotBlank
    private String stock;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="farmer_id")
    private Farmer farmer;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Product() {
    }

    public Product(@NotBlank String title, @NotBlank String price, @NotBlank String quality, @NotBlank String unit, @NotBlank String stock, Farmer farmer, Date createdAt, Date updatedAt) {
        this.title = title;
        this.price = price;
        this.quality = quality;
        this.unit = unit;
        this.stock = stock;
        this.farmer = farmer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setQuality(String quality){this.quality=quality;}

    public String getQuality(){
        return quality;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public String getStock() {
        return stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
