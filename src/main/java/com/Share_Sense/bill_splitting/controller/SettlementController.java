package com.Share_Sense.bill_splitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.Settlement;
import com.Share_Sense.bill_splitting.service.SettlementService;

@RestController
@RequestMapping("/settlements")
public class SettlementController {

	@Autowired
	private SettlementService settlementservice;

	@GetMapping
	public List<Settlement> AllSettlements() {
		return settlementservice.getAllSettlements();
	}

	@GetMapping("/{id}")
	public Optional<Settlement> getSettlementById(@PathVariable Long id) {
		return settlementservice.getSettlementById(id);
	}

}
