package com.example.BookSeller.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id",unique = true,nullable = false,length = 100)
    private Long userId;
    @Column(name = "book_id",nullable = false,length = 100)
    private Long bookId;
    @Column(name = "price",nullable = false,length = 100)
    private Double price;
    @Column(name = "createTime",nullable = false)
    private LocalDateTime createTime;
}
