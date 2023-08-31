package com.Share_Sense.bill_splitting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.entities.Settlement;
import com.Share_Sense.bill_splitting.repository.SettlementRepository;

@Service
public class SettlementService {

	@Autowired
	SettlementRepository settlementRepository;

	public List<Settlement> getAllSettlements() {
		return settlementRepository.findAll();
	}

	public Optional<Settlement> getSettlementById(Long id) {
		return settlementRepository.findById(id);
	}

}
