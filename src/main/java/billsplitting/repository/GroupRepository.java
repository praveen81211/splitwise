package billsplitting.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import billsplitting.entities.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    // You can add custom query methods if needed
}
