package com.Share_Sense.bill_splitting.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Share_Sense.bill_splitting.entities.Settlement;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {
    // You can add custom query methods if needed
}
