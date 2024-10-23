package com.example.BookSeller.service;

import com.example.BookSeller.model.PurchaseHistory;
import com.example.BookSeller.repository.IPurchaseHistoryRepository;
import com.example.BookSeller.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{

    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setCreateTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }
    @Override
    public List<IPurchaseItem> findPurchaseItemOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
