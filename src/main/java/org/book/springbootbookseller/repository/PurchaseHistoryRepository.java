package org.book.springbootbookseller.repository;

import org.book.springbootbookseller.model.PurchaseHistory;
import org.book.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query("select " +
            "b.title as Title, ph.price as Price, ph.purchaseTime as PurchaseTime " +
            "from PurchaseHistory ph left join Book b on b.id = ph.bookId " +
    "where ph.userId = :userId")
    List<IPurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);

}
