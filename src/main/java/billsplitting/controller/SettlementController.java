package billsplitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import billsplitting.entities.Settlement;
import billsplitting.service.SettlementService;

@RestController
@RequestMapping("/settlements")
public class SettlementController {

	@Autowired
	private SettlementService settlementService;

	@GetMapping
	public List<Settlement> getAllSettlements() {
		return settlementService.getAllSettlements();
	}

	@GetMapping("/{id}")
	public Optional<Settlement> getSettlementById(@PathVariable Long id) {
		return settlementService.getSettlementById(id);
	}
}
