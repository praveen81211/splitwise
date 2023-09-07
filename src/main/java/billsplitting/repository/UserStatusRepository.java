package billsplitting.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import billsplitting.entities.UserStatus;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {
    // You can add custom query methods if needed
}
