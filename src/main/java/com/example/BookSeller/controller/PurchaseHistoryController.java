package com.example.BookSeller.controller;

import com.example.BookSeller.model.PurchaseHistory;
import com.example.BookSeller.security.UserPrincipal;
import com.example.BookSeller.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase-history")
public class PurchaseHistoryController {
    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;

    @PostMapping//api/purchase-history
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }
    @GetMapping
    public  ResponseEntity<?> getAllPurchaseOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseHistoryService.findPurchaseItemOfUser(userPrincipal.getId()));
    }
}
