package com.example.BookSeller.repository.projection;

import java.time.LocalDateTime;

public interface IPurchaseItem {
    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
