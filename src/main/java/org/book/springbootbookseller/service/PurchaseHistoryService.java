package org.book.springbootbookseller.service;



import org.book.springbootbookseller.model.PurchaseHistory;
import org.book.springbootbookseller.repository.PurchaseHistoryRepository;
import org.book.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService {

    private final PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }


    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){

        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId){

        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }


}
