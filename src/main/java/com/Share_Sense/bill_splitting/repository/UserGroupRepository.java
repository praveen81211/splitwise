package com.Share_Sense.bill_splitting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Share_Sense.bill_splitting.entities.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

}
