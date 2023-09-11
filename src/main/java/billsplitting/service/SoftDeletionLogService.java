package billsplitting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import billsplitting.entities.SoftDeletionLog;
import billsplitting.repository.SoftDeletionLogRepository;

@Service
public class SoftDeletionLogService {

    @Autowired
    private SoftDeletionLogRepository softDeletionLogRepository;

    public List<SoftDeletionLog> getAllSoftDeletionLogs() {
        return softDeletionLogRepository.findAll();
    }
}
