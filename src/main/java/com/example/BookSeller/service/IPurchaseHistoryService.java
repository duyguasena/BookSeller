package com.example.BookSeller.service;

import com.example.BookSeller.model.PurchaseHistory;
import com.example.BookSeller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchaseItemOfUser(Long userId);
}
