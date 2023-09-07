package billsplitting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import billsplitting.entities.UserStatus;
import billsplitting.repository.UserStatusRepository;

@Service
public class UserStatusService {

    @Autowired
    private UserStatusRepository userStatusRepository;

    public List<UserStatus> getAllUserStatuses() {
        return userStatusRepository.findAll();
    }

    public Optional<UserStatus> getUserStatusById(Long id) {
        return userStatusRepository.findById(id);
    }
}
