package com.Share_Sense.bill_splitting.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Share_Sense.bill_splitting.entities.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    // You can add custom query methods if needed
}
