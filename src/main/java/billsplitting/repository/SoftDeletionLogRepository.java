package billsplitting.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import billsplitting.entities.SoftDeletionLog;

@Repository
public interface SoftDeletionLogRepository extends JpaRepository<SoftDeletionLog, Long> {
    // You can add custom query methods if needed
}
