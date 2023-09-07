package billsplitting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import billsplitting.entities.SoftDeletionLog;
import billsplitting.service.SoftDeletionLogService;

@RestController
@RequestMapping("/soft-deletion-logs")
public class SoftDeletionLogController {

	@Autowired
	private SoftDeletionLogService softDeletionLogService;

	@GetMapping
	public List<SoftDeletionLog> getAllSoftDeletionLogs() {
		return softDeletionLogService.getAllSoftDeletionLogs();
	}
}
