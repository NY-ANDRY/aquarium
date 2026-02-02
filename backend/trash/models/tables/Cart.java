package com.aquarium.models.tables;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "t_carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();

    // @ManyToOne
    // @JoinColumn(name = "id_area")
    // private Area area;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> details;

    @Transient
    private double totalProducts;

    @Transient
    private double totalDeliveries;

    @Transient
    private double discount;

    @Transient
    private double totalCost;

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<CartDetail> getDetails() {
        return details;
    }

    public double getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(double total) {
        this.totalProducts = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDetails(List<CartDetail> details) {
        this.details = details;
    }

    // public Area getArea() {
    // return area;
    // }

    // public void setArea(Area area) {
    // this.area = area;
    // }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(double totalDelivery) {
        this.totalDeliveries = totalDelivery;
    }
}
