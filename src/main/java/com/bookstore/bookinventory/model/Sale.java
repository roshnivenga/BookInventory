package com.bookstore.bookinventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleID;

    @Temporal(TemporalType.DATE)
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    private Integer quantity;
}
