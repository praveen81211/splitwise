package billsplitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import billsplitting.entities.UserStatus;
import billsplitting.service.UserStatusService;

@RestController
@RequestMapping("/user-status")
public class UserStatusController {

	@Autowired
	private UserStatusService userStatusService;

	@GetMapping
	public List<UserStatus> getAllUserStatuses() {
		return userStatusService.getAllUserStatuses();
	}

	@GetMapping("/user-status-by/{id}")
	public Optional<UserStatus> getUserStatusById(@PathVariable Long id) {
		return userStatusService.getUserStatusById(id);
	}
}
